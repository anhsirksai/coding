package AmazonProblems;

import java.util.*;
/**
 * Created by INSRSAI1 on 5/30/2016.
 */
public class ConvertIntegerToString {

    //approach1
    {{
        int x=0;
        boolean negative = false;
        String out="";
        System.out.println("Please enter the input");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        if(x<0){
            negative = true;
        }
        x = Math.abs(x);
        while(x>0){
            out = x%10+out;
            x =x/10;
        }
        if(negative)
            out = "-"+out;
        System.out.println(out);
    }}

    //approach2 using stack and string builder.
    private static String convertIntegerToString(Integer num) {
        List<String> stack = new LinkedList<>();
        boolean negative = num < 0 ? true : false;
        if (num < 0) {
            num = (num * -1);
        }
        while (num > 0) {
            stack.add(num % 10 + "");
            num = num / 10;
        }
        if(negative)
            stack.add("-");
        StringBuilder sb = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
