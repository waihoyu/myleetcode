/**
 * 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 注意：你不能倾斜容器，n 至少是2。
 * 2018年6月14日提交通过 leetcode
 */

package myCode;

public class TheCupWithMaxVolume {
	public int[] arry = { 1, 2, 4, 3 };

	public static void main(String[] agrs) {
		Solution1 test = new Solution1();
		System.out.println(test.maxArea(new TheCupWithMaxVolume().arry));
	}
}

// 提交通过的代码
class Solution1 {
	public int maxArea(int[] height) {
		int area = 0;
		int areaTemp = 0;
		if (height.length > 1) {
			int head = 0;
			int tail = height.length - 1;
			while (head != tail) {
				if (height[head] > height[tail]) {
					areaTemp = height[tail] * (tail - head);
					if (areaTemp > area) {
						area = areaTemp;
					}
					while (true) {
						if (height[tail - 1] > height[tail]) {
							tail = tail - 1;
							break;
						} else {
							tail = tail - 1;
						}
					}

				} else if (height[head] < height[tail]) {
					areaTemp = height[head] * (tail - head);
					if (areaTemp > area) {
						area = areaTemp;
					}
					while (true) {
						if (height[head + 1] > height[head]) {
							head = head + 1;
							break;
						} else {
							head = head + 1;
						}
					}

				} else if (height[head] == height[tail]) {
					areaTemp = height[head] * (tail - head);
					if (areaTemp > area) {
						area = areaTemp;
					}
					head = head + 1;
				}
			}
			return area;
		} else {
			return 0;
		}
	}
}

// 双层循环，超出时间显示 最普通的解法
class Solution {
	public int maxArea(int[] height) {
		int area = 0;
		if (height.length > 1) {
			for (int i = 0; i < height.length; i++) {
				for (int j = i + 1; j < height.length; j++) {
					if (height[i] > height[j]) {
						int tempArea = (j - i) * height[j];
						if (area < tempArea) {
							area = tempArea;
						}
					} else if (height[i] < height[j]) {
						int tempArea = (j - i) * height[i];
						if (area < tempArea) {
							area = tempArea;
						}
					} else if (height[i] == height[j]) {
						int tempArea = (j - i) * height[i];
						if (area < tempArea) {
							area = tempArea;
						}
					}
				}
			}
			return area;
		} else {
			return 0;
		}
	}
}
