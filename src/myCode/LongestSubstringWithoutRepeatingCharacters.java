package myCode;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub			    
	    Solution88 string8 = new Solution88();
	    System.out.println(string8.lengthOfLongestSubstring("pwwkew"));;    	
	}
}


class Solution88 {
	
    public int lengthOfLongestSubstring(String s) {
    	String inputs = s;
    	String checkString = "";
    	String result = "";
    	boolean isReapt = false;
    	int pos = 0;
    	char temp = ' ';    	
		char[] values = inputs.toCharArray();			
		for (int i = 0; i < values.length; i++) {
			temp = values[i];			
			char[] values2 = checkString.toCharArray();			
			for (int j = 0; j < values2.length; j++) {
				if (temp == values2[j]) {				
					isReapt = true;
					pos = j;
//					restart = true;
					break;
				}
			}
			if (!isReapt) {
				checkString = checkString + temp;			
				char[] tempchek = checkString.toCharArray();				
				char[] resultchek2 = result.toCharArray();				
				if (tempchek.length > resultchek2.length ) {
					result = checkString;
				}
			}//true
			else {
//				checkString = temp + "";
				
				char[] tempchek = checkString.toCharArray();				
				char[] resultchek2 = result.toCharArray();
				if ( tempchek.length > resultchek2.length) {
					result = checkString;
					checkString = temp + "";	
				}
				else {
					String  temp5 = "";
					for (int j = pos + 1; j < tempchek.length; j++) {
						 temp5 = temp5 + tempchek[j];
					}
					checkString = temp5 + temp + "";
				}
			}		
			isReapt = false;
		}		
		char[] resultLast = result.toCharArray();		
        return resultLast.length;
    }    

}