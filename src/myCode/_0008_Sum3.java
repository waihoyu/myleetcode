package myCode;

import java.util.ArrayList;
import java.util.List;

public class _0008_Sum3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		Solution_Sum3 instance = new Solution_Sum3();
		instance.threeSum(nums);
	}
}

class Solution_Sum3 {
	@SuppressWarnings("unchecked")
	public List<List<Integer>> threeSum(int[] nums) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> conversionList = new ArrayList<Integer>();

		ArrayList<Integer> tempList = null;
		ArrayList<Integer> tempList2 = null;
		@SuppressWarnings("unused")
		ArrayList<Integer> tempList3 = null;
		for (int i = nums.length - 1; i > -1; i--) {
			conversionList.add(nums[i]);
		}
		tempList = (ArrayList<Integer>) conversionList.clone();
		for (int i = conversionList.size() - 1; i > -1; i--) {
			int nums_1 = tempList.get(i);
			tempList.remove(i);
			tempList2 = (ArrayList<Integer>) tempList.clone();
			;
			for (int j = tempList2.size() - 1; j > -1; j--) {
				int nums_2 = tempList2.get(j);
				tempList2.remove(j);
				tempList3 = (ArrayList<Integer>) tempList2.clone();
				for (int k = tempList3.size() - 1; k > -1; k--) {
					int nums_3 = tempList3.get(k);
					if (nums_1 + nums_2 + nums_3 == 0) {
						ArrayList<Integer> list2 = new ArrayList<Integer>();
						list2.add(nums_1);
						list2.add(nums_2);
						list2.add(nums_3);
						result.add(list2);
						
					}
				}
			}
		}
		System.out.println(result);	
		return null;
	}
}
