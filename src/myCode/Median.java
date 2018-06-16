/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
//
//	请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
//	
//	示例 1:
//	
//	nums1 = [1, 3]
//	nums2 = [2]
//	
//	中位数是 2.0
//	示例 2:
//	
//	nums1 = [1, 2]
//	nums2 = [3, 4]
//	
//	中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */

package myCode;



public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {0,2,3,999};
		int[] nums2 = {};

		SolutionMedian temp  = new SolutionMedian();
		System.out.println(temp.findMedianSortedArrays(nums1, nums2));;
		
	}

}

class SolutionMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {    	
    	int[] values= new int[nums1.length + nums2.length] ;
    	int values_pos = 0;
    	int length_nums1 = 0;
    	int length_nums2 = 0;
    	int temp_nums1 =0;
    	int temp_nums2 =0;
    	double result = 0.0;
    	int middle = 0;
    	while(true) {   		
    		if ((length_nums1 == nums1.length) &&(length_nums2 == nums2.length)) {
				break;
			}
    		if ((length_nums1 == nums1.length) &&(length_nums2 != nums2.length)) {
				for (int i = length_nums2; i < nums2.length; i++) {
	    			values[values_pos] = nums2[i];
	    			values_pos++;
				}
				break;
			}
    		if ((length_nums2 == nums2.length) &&(length_nums1 != nums1.length)) {
				for (int i = length_nums1; i < nums1.length; i++) {
	    			values[values_pos] = nums1[i];
	    			values_pos++;
				}
				break;
			}
    		
    		if (length_nums1 < nums1.length) {
    			temp_nums1 = nums1[length_nums1];
			}
    		if (length_nums2 < nums2.length) {
    			temp_nums2 = nums2[length_nums2];
			}
    		if (temp_nums1 < temp_nums2) {
    			values[values_pos] = temp_nums1;
    			values_pos++;
    			length_nums1++;
			}else if (temp_nums1 >= temp_nums2) {
    			values[values_pos] = temp_nums2;
    			values_pos++;
    			length_nums2++;
			}
    		
    	}
    	
    	if (values.length > 0 ) {
        	int f = values.length % 2;
        	if (f == 0) {
    			middle = values.length / 2;
    			result = (values[middle - 1] + values[middle])/2.0;
    		}else if (f != 0) {
    			middle = values.length / 2;
    			result = values[middle];
    		}	
		}   	
    	return result;
    }
}
