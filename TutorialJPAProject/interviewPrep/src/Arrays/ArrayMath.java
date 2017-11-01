package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],

 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class ArrayMath {
	public static int maxSubArray(final List<Integer> a) {
	    
	    int sum =Integer.MIN_VALUE;
	    
	    int last = 0;
	    
	    for(int i : a){
	        last += i;
	        sum = Math.max(sum,last);
	        
	        if(last < 0)
	            last = 0;
	    }
	    
	    return sum;
	}
	
	public static void main(String[] args){
/*		program to interfaces always.
		Iterable<String> strings = new ArrayList<>();   // If you just need to iterate
		Collection<String> strings = new ArrayList<>(); // If you also need .size() or .stream()
		List<String> strings = new ArrayList<>();       // If you also need .get(index)
*/		
		List<Integer> inputList = new ArrayList<Integer>();
		//different ways of Assigning values to list.
		Collections.addAll(inputList, -2,1,-3,4,-1,2,1,-5,4);
		List<Integer> ints = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);
		maxSubArray(inputList);
		maxSubArray(ints);		
	}
}