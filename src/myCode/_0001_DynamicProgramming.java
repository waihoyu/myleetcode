package myCode;

/**
 * @ClassName:  _0001_DynamicProgramming   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author:  WaiHoYu
 * @date:   2018年7月16日 上午2:04:53        
 * @Copyright: 2018
 */

public class _0001_DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = {1, 2, 4, 1, 7, 8, 3};	
		_0001_DynamicProgramming_dp exe = new _0001_DynamicProgramming_dp();
		int res = exe.rec_opt(arry,arry.length - 1);
		System.out.println(res);
		int res2 = exe.dp_opt(arry);
		System.out.println(res2);
	}

}


class _0001_DynamicProgramming_dp
{
	public int rec_opt(int[] arr,int i)  {
		if (i == 0) {
			return arr[0];
		}
		else if (i == 1) {
			return Math.max(arr[0], arr[1]);
		}	
		else {
			int tempA = rec_opt(arr, i - 2) + arr[i];
			int tempB = rec_opt(arr, i - 1);
			
			return Math.max(tempA, tempB);
		}
	}
	
	public int dp_opt(int[] arr)  {
		int[] arry_dp = new int[7]; 
		arry_dp[0] = arr[0];
		arry_dp[1] = arr[1];
		for (int i = 2; i < arry_dp.length; i++) {
			int tempA = arry_dp[i - 2] + arr[i];
			int tempB = arry_dp[i - 1];			
			arry_dp[i] = Math.max(tempA, tempB);
		}	
		for (int i = 0; i < arry_dp.length; i++) {
			System.out.println(arry_dp[i]);
		}
		return arry_dp[arry_dp.length - 1];
	}
}


