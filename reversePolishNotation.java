import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int a, b;

        for(String str: tokens){
            if(str.equals("+")){
                a = s.pop();
                b = s.pop();
                s.push(b + a);
            }
            else if(str.equals("-")){
                a = s.pop();
                b = s.pop();
                s.push(b - a);
            }
            else if(str.equals("*")){
                a = s.pop();
                b = s.pop();
                s.push(b*a);
            }
            else if(str.equals("/")){
                a = s.pop();
                b = s.pop();
                s.push(b/a);
            }
            else s.push(Integer.valueOf(str));
        }

        return s.pop();
    }
}