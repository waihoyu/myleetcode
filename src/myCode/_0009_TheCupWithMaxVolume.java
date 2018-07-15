/**
 * ʢ���ˮ������
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ��
 * �� n ����ֱ�ߣ�ʹ�ô�ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)��
 * �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 * ע�⣺�㲻����б������n ������2��
 * 2018��6��14���ύͨ�� leetcode
 */

package myCode;

public class _0009_TheCupWithMaxVolume {
	public int[] arry = { 1, 2, 4, 3 };

	public static void main(String[] agrs) {
		Solution1 test = new Solution1();
		System.out.println(test.maxArea(new _0009_TheCupWithMaxVolume().arry));
	}
}

// �ύͨ���Ĵ���
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

// ˫��ѭ��������ʱ����ʾ ����ͨ�Ľⷨ
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
