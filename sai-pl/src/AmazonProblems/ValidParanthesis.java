package AmazonProblems;

import java.util.Stack;
/**
 * Created by INSRSAI1 on 6/1/2016.
 */
public class ValidParanthesis {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }

            else if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            }

            else if(c == ']'){
                if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return false;
            }

            else if(c == '}'){
                if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
