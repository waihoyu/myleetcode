package myCode;

public class TheSumOfTwoNumbers {
	public static void main(String[] agrs) {
		 int[] nums = { 2, 7, 11, 15 };
		 int tar = 9;
		Solution2 test = new Solution2();
		System.out.println(test.twoSum(nums, tar));
	}
}


class Solution2 {
	public int[] twoSum(int[] nums, int target) {
		int[] result = {0, 0};
		int firstNum = 0;
		int secondNum = 0;
		boolean finded = false;
		for (int i = 0; i < nums.length; i++) {
			if (!finded) {
				firstNum = nums[i];
				for (int j = i + 1; j < nums.length; j++) {
					secondNum = nums[j];
					if ((firstNum + secondNum) == target) {
						result[0] = i;
						result[1] = j;
						finded = true;
						break;
					}
				}	
			}

		}
		return result;
	}
}


