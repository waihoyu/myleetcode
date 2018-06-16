/**
 * 
	给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
	
	你可以假设除了数字 0 之外，这两个数字都不会以零开头。
	
	示例：
	
	输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	输出：7 -> 0 -> 8
	原因：342 + 465 = 807
 */

package myCode;

public class TheSumOfTwoNumbers2 {
	public static void main(String[] agrs) {
		ListNode oNode = new ListNode(9);
		oNode.next = new ListNode(9);
		// oNode.next.next = new ListNode(9);
		// [1,9,9,9,9,9,9,9,9,9]
		ListNode sNode = new ListNode(9);
		// sNode.next = new ListNode(9);
		// sNode.next.next = new ListNode(9);
		// sNode.next.next.next = new ListNode(1);
		Solution3 test = new Solution3();
		ListNode sNode4 = test.addTwoNumbers(oNode, sNode);
		ListNode tempNode = sNode4;
		while (tempNode != null) {
			System.out.println(tempNode.val);
			tempNode = tempNode.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution3 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultNode = null;
		ListNode tempNode1 = l1;
		ListNode tempNode2 = l2;
		int count_l1 = 0,count_l2 = 0,value_l = 0,value_2 = 0;
//		int count_l2 = 0;
//		int value_l = 0;
//		int value_2 = 0;
		ListNode tempNode = l1;
		while (tempNode != null) {
			count_l1++;
			tempNode = tempNode.next;
		}
		tempNode = l2;
		while (tempNode != null) {
			count_l2++;
			tempNode = tempNode.next;
		}
		if (count_l1 > count_l2) {
			while (true) {
				value_l = 0;
				value_2 = 0;
				if ((tempNode1 == null) && (tempNode2 == null)) {
					break;
				}
				if (tempNode1 != null) {
					value_l = tempNode1.val;
				}
				if (tempNode2 != null) {
					value_2 = tempNode2.val;
				}
				tempNode = tempNode1;
				int a = value_l + value_2;
				if (a >= 10) {
					tempNode1.val = (a - 10);
					ListNode temp_Node = tempNode1.next;
					if (temp_Node == null) {
						tempNode1.next = new ListNode(1);
					} else {
						int val = temp_Node.val;
						temp_Node.val = val + 1;
						while (tempNode != null) {
							int value = tempNode.next.val;
							if (value > 10) {
								tempNode.val = 0;
								tempNode.next.val = value + 1;
								tempNode = tempNode.next;
							} else {
								break;
							}
						}
					}
				} else {
					tempNode1.val = value_l + value_2;
				}
				if (tempNode1 != null) {
					tempNode1 = tempNode1.next;
				}
				if (tempNode2 != null) {
					tempNode2 = tempNode2.next;
				}
			}
			resultNode = l1;
		}
		if (count_l1 <= count_l2) {
			while (true) {
				value_l = 0;
				value_2 = 0;
				if ((tempNode1 == null) && (tempNode2 == null)) {
					break;
				}
				if (tempNode1 != null) {
					value_l = tempNode1.val;
				}
				if (tempNode2 != null) {
					value_2 = tempNode2.val;
				}
				tempNode = tempNode2;
				int a = value_l + value_2;
				if (a >= 10) {
					tempNode2.val = (a - 10);
					ListNode temp_Node = tempNode2.next;
					if ( temp_Node == null) {
						tempNode2.next = new ListNode(1);
					} else {
						int val = temp_Node.val;
						temp_Node.val = val + 1;
						while (tempNode != null) {
							int value = tempNode.next.val;
							if (value > 10) {
								tempNode.val = 0;
								tempNode.next.val = value + 1;
								tempNode = tempNode.next;
							} else {
								break;
							}
						}
					}
				} else {
					tempNode2.val = value_l + value_2;
				}
				if (tempNode1 != null) {
					tempNode1 = tempNode1.next;
				}
				if (tempNode2 != null) {
					tempNode2 = tempNode2.next;
				}
			}
			resultNode = l2;
		}
		return resultNode;
	}
}



//
// class Solution13 {
// public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
// Long sum1 = (long) 0;
// int length1 = 0;
// ListNode tempNode = l1;
// while (tempNode != null) {
// sum1 = (long) (sum1 + (long) tempNode.val * Math.pow(10, length1));
// length1++;
// tempNode = tempNode.next;
// }
//
// Long sum2 = (long) 0;
// int length2 = 0;
// ListNode tempNode2 = l2;
// while (tempNode2 != null) {
// sum2 = (long) (sum2 + (long) tempNode2.val * Math.pow(10, length2));
// length2++;
// tempNode2 = tempNode2.next;
// }
//
// long sum3 = sum1 + sum2;
// String s = Long.toString(sum3);
// char[] c = s.toCharArray();
// ListNode resultNode = new ListNode((c[s.length() - 1]) - '0');
// ListNode temp = resultNode;
// for (int i = c.length - 2; i >= 0; i--) {
// temp.next = new ListNode((c[i]) - '0');
// System.out.println(temp.next.val);
// temp = temp.next;
// }
// return resultNode;
// }
// }
