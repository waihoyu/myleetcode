package _0001_DynamicProgramming;

public class _0002_DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 3, 34, 4, 12, 5, 2 };
		int target = 9;
		_0002_DynamicProgramming_dp exe = new _0002_DynamicProgramming_dp();
		System.out.println(exe.rec_opt(array, array.length - 1, target));
		System.out.println(exe.dp_opt(array, target));
	}

}

class _0002_DynamicProgramming_dp {
	/**
	 * @Title: rec_opt   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param:       
	 * @return:    
	 * @throws   
	 * @Copyright: MTI
	 */
	public boolean rec_opt(int[] arr, int i, int target) {
		boolean A = false;
		boolean B = false;
		if (target == 0) {
			return true;
		} else if (i == 0) {
			return arr[0] == target;
		} else if (arr[i] > target) {
			return rec_opt(arr, i - 1, target);
		} else {
			A = rec_opt(arr, i - 1, target - arr[i]);
			B = rec_opt(arr, i - 1, target);
			return A || B;
		}

	}
	/**
	 * @Title: dp_opt   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param:       
	 * @return:    
	 * @throws   
	 * @Copyright: MTI
	 */
	public boolean dp_opt(int[] arr, int target) {
		boolean A = false;
		boolean B = false;
		boolean[][] subset = new boolean[arr.length][target + 1];
		
		for (int i = 0; i < arr.length; i++) {
			subset[i][0] = true;
		}
		for (int i = 0; i < target + 1; i++) {
			subset[0][i] = false;
		}
		if (target >= arr[0]) {
			subset[0][arr[0]] = true;
		}		
		for (int i = 0; i < subset.length; i++) {
			String string = "";
			for (int j = 0; j < subset[i].length; j++) {
				string = string + Boolean.toString(subset[i][j]) + " ";
			}
			System.out.println(string + "#");
		}
		
		//		int[] array = { 3, 34, 4, 12, 5, 2 };
		//		int target = 9;	
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < target + 1; j++) {
				if (arr[i] > j) {
					subset[i][j] = subset[i - 1][j];
				} else {
					A = subset[i - 1][j - arr[i]];
					B = subset[i - 1][j];
					subset[i][j] = A || B;
				}
			}
		}		
		
		System.out.println("------------------------------------");
		for (int i = 0; i < subset.length; i++) {
			String string = "";
			for (int j = 0; j < subset[i].length; j++) {
				string = string + Boolean.toString(subset[i][j]) + " ";
			}
			System.out.println(string + "#");
//			System.out.println();
		}	
		return subset[arr.length - 1][target];
	}
}