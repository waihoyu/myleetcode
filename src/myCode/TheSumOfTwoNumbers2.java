package myCode;

public class TheSumOfTwoNumbers2 {
	public static void main(String[] agrs) {
		ListNode oNode = new ListNode(2);
		 oNode.next = new ListNode(4);
		 oNode.next.next = new ListNode(3);
		// [1,9,9,9,9,9,9,9,9,9]
		ListNode sNode = new ListNode(4);
		sNode.next = new ListNode(6);
		sNode.next.next = new ListNode(4);
		sNode.next.next.next = new ListNode(1);
		Solution3 test = new Solution3();
		ListNode sNode4 = test.addTwoNumbers(oNode, sNode);
		
		ListNode tempNode = sNode4;
		 while (tempNode != null) {
			 System.out.println(tempNode.val);
		 tempNode = tempNode.next;
		 }
		
//		System.out.println(sNode4.toString());
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
		ListNode tempNode = l1;
		ListNode tempNode2 = l2;
		ListNode resultNode = new ListNode(0);
		ListNode temp = resultNode;
		int sum1 = 0, sum2 = 0, sum3 = 0;
		ListNode temp2 = resultNode.next;
		while (true) {			
			if (tempNode != null) {
				sum1 = tempNode.val;
			}
			if (tempNode2 != null) {
				sum2 = tempNode2.val;
			}
			sum3 = sum1 + sum2;
			if (sum3 >= 10) {
				if (temp != null && temp.val > 0) {
					int a = temp.val + sum3;
					if (a >= 10) {
						temp = new ListNode(a - 10);
						temp.next = new ListNode(1);
					} else {
						temp.next = new ListNode(a);
					}
				} else {
					temp = new ListNode(sum3 - 10);
					temp.next = new ListNode(1);
				}

			} else {
				temp.val = sum3;
				temp.next = new ListNode(0);
//				if (temp.next != null) {
//					temp.next = new ListNode(0);
//				}
				
			}
			if (tempNode != null) {
				tempNode = tempNode.next;
			}
			if (tempNode2 != null) {
				tempNode2 = tempNode2.next;
			}
					

			if (tempNode == null && tempNode2 == null) {
				break;
			}			
		}
		return resultNode;
	}
//    public void addNode(ListNode newNode){  
//        if(newNode.next== null){  
//        	newNode.next = newNode;  
//        }else{  
//        	newNode.next.addNode(newNode);  
//        }  
//    } 
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
