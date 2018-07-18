package _0001_DynamicProgramming;
/**
 * @ClassName:  _0003_FibonacciSequence   
 * @Description: 使用动态规划思想实现斐波那契数列  缺点：integer的取值范围有限。
 * @author:  WaiHoYu
 * @date:   2018年7月18日 下午2:13:22     
 * @Copyright: MIT
 */
public class _0003_FibonacciSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[40];
		array[0] = 1;
		array[1] = 1;
		for (int i = 2; i < 20; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		for (int i = 0; i < 20; i++) {
			System.out.println(array[i]);
		}
	}
}
