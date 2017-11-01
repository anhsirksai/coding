package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationArray {
	
	/*Given input = 5
	[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
    ]*/
	public static ArrayList<ArrayList<Integer>> pascalTriangle(int a) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
				
		//This case I handled wrongly on first go.
//		if(a==0){
//			ll.add(0);
//			result.add(ll);
//		}
//		
		//This case, I handled correctly
//		if(a == 1){
//			ll.add(1);
//			result.add(ll);
//		}
//		
		if(a == 0)
	        return result;
	    
		result.add(new ArrayList<>());
	    result.get(0).add(1);
	    
	    for(int i = 1;i<a;i++){
	    	result.add(new ArrayList<>());
	    	
	    	result.get(i).add(1); // adding the first element as 1.	    	
	    	for(int j = 0; j < i-1; j++ ){
	    		//addin the middle elements
	    		int num = result.get(i-1).get(j) + result.get(i-1).get(j+1);
	    		result.get(i).add(num);
	    	}	    	
	    	result.get(i).add(1); // adding the last element as 1
	    	
	    }	
		return result;
	}
	
	private static List<ArrayList<Integer>> spiralMatrix(int i) {

		List<ArrayList<Integer>> inputList = new ArrayList<ArrayList<Integer>>();
		String state = "ltr";
		int row =0,col =0, value =0;
		if(i == 0)
			return inputList;
		
		//This is a wrong way to handle.because list will be initialized with one value. But this can be overwritten later. so, this should not be a problem.
		if(i==1){
			inputList.get(0).add(1);
			return inputList;
		}
		int layer = 0;
		for(int step = 2; step < i*i; step++){
			switch(state){
			case "ltr":
			
			case "ttb":
			
			case "rtl":
				
			case "btt":
				
			}
			inputList.get(row).set(col,value);
		}
		
		return inputList;
	}
	
	public static void main(String[] args){
/*		List<ArrayList<Integer>> outputMatrix = new ArrayList<ArrayList<Integer>>();
		outputMatrix = pascalTriangle(7);	*/
		
		List<ArrayList<Integer>> outputMatrix1 = new ArrayList<ArrayList<Integer>>();		
		outputMatrix1 = spiralMatrix(1);
		
		for(ArrayList<Integer> i : outputMatrix1){
			for(Integer j:i){
				System.out.print(j);
			}
			System.out.println("\n");
		}
		

	}



}
