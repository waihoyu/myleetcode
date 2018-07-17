
package _0003_LongestPalindromicSubstring_5;

public class _0003_LongestPalindromicSubstring_5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_5 execute = new Solution_5();
		System.out.println(execute.longestPalindrome("abacbcabababababababababababababababababababababababababababababababababababababababababababababababababababababab"));
	}
}

class Solution_5 {
	
	public String longestPalindrome(String s) {
		String inputs = s;
		String resultString = "";
		boolean isPossbile = true;
		char[] longestPal = inputs.toCharArray();
		if (longestPal.length <= 1000) {
			int start = 0;
			String lastCheck = "";
			String currentCheck = "";
			String thisMax = "";
			for (int i = 0; i < longestPal.length; i = i+1) {
				start = i;	
				lastCheck ="";
				for (int j = start; j < longestPal.length; j++) {
					currentCheck = "";
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
				char[] arrr0 = resultString.toCharArray();
				char[] arrr1 = thisMax.toCharArray();
				if (arrr0.length < arrr1.length) {
					resultString = thisMax;
				}			
			}		
			return resultString;			
		}
		else
		{
			return "";
		}
	}
	
}


