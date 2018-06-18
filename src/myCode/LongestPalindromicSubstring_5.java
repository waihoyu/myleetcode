/**
 * 第  5 题
 *给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *示例 1：
 *输入: "babad"
 *输出: "bab"
 *注意: "aba"也是一个有效答案。
 *示例 2：
 *输入: "cbbd"
 *输出: "bb" 
 */

package myCode;

public class LongestPalindromicSubstring_5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_5 execute = new Solution_5();
		System.out.println(execute.longestPalindrome("nmngaowrbsssvihklwmuqshcddwlxrywrlwtennwfvrevgvhsvgeccfulmuvrcksdmgeqrblnlwoepefhcwhmgyvgcoyyygrmttyfycxwbqktpur"));
		;
	}
}

class Solution_5 {
	
	public String longestPalindrome(String s) {
		String inputs = s;
		String resultString = "";
		boolean isPossbile = true;
		char[] longestPal = inputs.toCharArray();
		int start = 0;
		String lastCheck = "";
		String currentCheck = "";
		String thisMax = "";
		for (int i = 0; i < longestPal.length; i++) {
			start = i;	
			lastCheck ="";
			for (int j = start; j < longestPal.length; j++) {
				currentCheck ="";
				currentCheck = lastCheck + longestPal[j];	
				lastCheck = currentCheck;
				char[] checkPal = currentCheck.toCharArray();
				int a = 0;
				int b = checkPal.length - 1;				
				while(true) {
					if ((a != b) && (a <= b)) {
						if ((checkPal[a] == checkPal[b])) {							
							a++;
							b--;
							isPossbile  = true;
						}
						else {
							isPossbile  = false;						
							break;
						}	
					}
					else
					{
						isPossbile  = true;
						break;
					}

				}
				if (isPossbile) {
					thisMax  = currentCheck;	
				}
				isPossbile =false;
			}	
			if (resultString.length() < thisMax.length()) {
				resultString = thisMax;
			}			
		}		
		return resultString;
	}
	
}
