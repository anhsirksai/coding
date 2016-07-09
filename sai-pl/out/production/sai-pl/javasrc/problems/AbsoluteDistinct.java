import java.util.*;

public class AbsoluteDistinct
{
    public static int distinctCount(int numberArray[], int n)
    {
        Set<Integer> s = new HashSet();

        for(int i =0;i<n;i++)
        {
            s.add(Math.abs(numberArray[i] ));
        }
        return s.size();
    }

    public static void main(String args[])
    {
        int arr[] = {-2,-1,0,1,2};
        int n = arr.length;

        int count = distinctCount(arr,n);
//        System.out.println(count);

        System.out.println(distinctCount(arr,n));
    }
}
