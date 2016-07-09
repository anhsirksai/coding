package AmazonProblems;
import java.util.Stack;
/**
 * Created by INSRSAI1 on 6/1/2016.
 */
public class SimplifyPaths {
    public String simplifyPath(String path) {

        String[] paths = path.split("/");
        Stack<String> stack = new Stack<String>();

        for(String s : paths){

            if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            } else if(s.length()>0 && !s.equals(".")) { stack.push(s);}
        }

        StringBuilder sb = new StringBuilder();
        for(String S : stack){
            sb.append("/" + S);
        }

        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }

}
