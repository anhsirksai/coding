package AmazonProblems;

/**
 * Created by INSRSAI1 on 6/2/2016.
 */

// A simple solution is to one by one consider all bars as starting points and calculate area of all rectangles starting with every bar. Finally return maximum of all possible areas. Time complexity of this solution would be O(n^2).

// O(nlogn) - d&c

//We can use Divide and Conquer to solve this in O(nLogn) time. The idea is to find the minimum value in the given array. Once we have index of the minimum value, the max area is maximum of following three values.
//        a) Maximum area in left side of minimum value (Not including the min value)
//        b) Maximum area in right side of minimum value (Not including the min value)
//        c) Number of bars multiplied by minimum value.
//        The areas in left and right of minimum value bar can be calculated recursively. If we use linear search to find the minimum value, then the worst case time complexity of this algorithm becomes O(n^2). In worst case, we always have (n-1) elements in one side and 0 elements in other side and if the finding minimum takes O(n) time, we get the recurrence similar to worst case of Quick Sort.
//        How to find the minimum efficiently? Range Minimum Query using Segment Tree can be used for this. We build segment tree of the given histogram heights. Once the segment tree is built, all range minimum queries take O(Logn) time. So over all complexity of the algorithm becomes.
//        Overall Time = Time to build Segment Tree + Time to recursively find maximum area
//
//        Time to build segment tree is O(n). Let the time to recursively find max area be T(n). It can be written as following.
//        T(n) = O(Logn) + T(n-1)
//        The solution of above recurrence is O(nLogn). So overall time is O(n) + O(nLogn) which is O(nLogn).


// O(n)
//For every bar ‘x’, we calculate the area with ‘x’ as the smallest bar in the rectangle. If we calculate such area for every bar ‘x’ and find the maximum of all areas, our task is done.
//
//How to calculate area with ‘x’ as smallest bar? We need to know index of the first smaller (smaller than ‘x’) bar on left of ‘x’ and index of first smaller bar on right of ‘x’. Let us call these indexes as ‘left index’ and ‘right index’ respectively.
//
//
//We traverse all bars from left to right, maintain a stack of bars. Every bar is pushed to stack once. A bar is popped from stack when a bar of smaller height is seen.
//
//When a bar is popped, we calculate the area with the popped bar as smallest bar.
//
//How do we get left and right indexes of the popped bar – the current index tells us the ‘right index’ and index of previous item in stack is the ‘left index’. Following is the complete algorithm.


//s.top()'s(c++) equivalent in java is s.peek();

public class MaxAreaRextangle {


}
