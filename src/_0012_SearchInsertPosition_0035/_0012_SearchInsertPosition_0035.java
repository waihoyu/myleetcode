package _0012_SearchInsertPosition_0035;

/**
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * @ClassName:  _0012_SearchInsertPosition_0035   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author:  WaiHoYu
 * @date:   2018年7月17日 下午12:30:48     
 * @Copyright: 2018
 */
class _0012_SearchInsertPosition_0035 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3};
		int target = 2;
		Solution solution  = new Solution();
		System.out.println(solution.searchInsert(nums, target));
	}
}

class Solution {
    public int searchInsert(int[] nums, int target) {
    	int left = 0;
    	int right = nums.length - 1;
		int middle = nums.length / 2;
		int result = -1;
		int oldRight = -1;
		int oldLeft = -1;
		while(true) {
			if (middle == left || middle == right) {
				if (nums[left] < target && target < nums[right]) {
					result = left + 1;
				}
				if (nums[left] > target) {
					result = (left - 1) < 0 ? left :left - 1;
				}
				if (nums[right] < target) {
					result = right + 1;
				}
				if (nums[left] == target) {
					result = left;
				}
				if (nums[right] == target) {
					result = right;
				}
				break;
			}
			else
			{
				if (nums[middle] > target) {
					oldLeft = left;
					right = middle;
					middle = (right + oldLeft) / 2;
				}
				if (nums[middle] < target) {
					oldRight = right;
					left = middle;					
					middle = (oldRight + left) / 2;
				}
				if (nums[middle] == target) {
					result = middle;
					break;
				}
				if ((right - left) == 1)
				{
					if (nums[left] < target && target < nums[right]) {
						result = left + 1;
					}
					if (nums[left] > target) {
						result = (left - 1) < 0 ? left :left - 1;
					}
					if (nums[right] < target) {
						result = right + 1;
					}
					if (nums[left] == target) {
						result = left;
					}
					if (nums[right] == target) {
						result = right;
					}					
				}
			}

			
		}

    	return result;       
    }
}





