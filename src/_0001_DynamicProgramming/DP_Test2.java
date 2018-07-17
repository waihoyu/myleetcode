package _0001_DynamicProgramming;
/**
 * 网上实例，也有问题
 * @ClassName:  DP_Test2   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author:  WaiHoYu
 * @date:   2018年7月17日 下午11:58:25     
 * @Copyright: 2018
 */
public class DP_Test2 {

	public static void main(String[] args) {
		int[] arr = { 3, 34, 4, 12, 5, 2 };
		int s = 34;
		System.out.println(rec_subset(arr, arr.length - 1, s));
		System.out.println(dp_subset(arr, s));
	}

	public static boolean rec_subset(int[] arr, int i, int s) {
		if (s == 0)
			return true;
		else if (i == 0)
			return arr[0] == s;
		else if (arr[i] > s)
			return rec_subset(arr, i - 1, s);
		else {
			boolean a = rec_subset(arr, i - 1, s - arr[i]);
			boolean b = rec_subset(arr, i - 1, s);
			if (a || b)
				return true;
		}
		return false;

	}

	public static boolean dp_subset(int[] arr, int S) {
		boolean[][] subset = new boolean[arr.length][S + 1];
		for (int i = 0; i < arr.length; i++) {
			subset[i][0] = true;
		}
		for (int i = 0; i < S + 1; i++) {
			subset[0][i] = false;
		}
		if (S >= arr[0]) {
			subset[0][arr[0]] = true;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int s = 1; s < S + 1; s++) {
				if (arr[i] > s) {
					subset[i][s] = subset[i - 1][s];
				} else {
					boolean a = subset[i - 1][s - arr[i]];
					boolean b = subset[i - 1][s];
					subset[i][s] = a || b;
				}
			}
		}
		return subset[arr.length - 1][S];
	}
}
