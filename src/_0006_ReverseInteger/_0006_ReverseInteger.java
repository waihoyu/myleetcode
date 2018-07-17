package _0006_ReverseInteger;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class _0006_ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_ReverseInteger instance = new Solution_ReverseInteger();
		System.out.println(instance.reverse(234567899));;

	}

}

class Solution_ReverseInteger {
    public int reverse(int x) {
    	ArrayList<Integer> middleList = new ArrayList<Integer>();
    	long result = 0;
    	int result2 = 0;
    	int a = x;
    	int listSize = 0;
    	while(a != 0 ) {
    		middleList.add(a % 10);
    		a = a/10;   		
    	}
    	listSize = middleList.size() - 1;
		for (int i = 0; i < middleList.size(); i++) {
			result = (long) (result + middleList.get(i) * Math.pow(10, listSize--));
		}	
		if ((result > Math.pow(2, 31) - 1) || (result < Math.pow(-2, 31))) {
			result2 = 0;
		}else {
			result2 = (int)result;
		}
    	return result2;      
    }
}
