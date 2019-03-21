package leetcode;

import java.util.Stack;

public class longestValidParenttheses {
    public int solution32(String s){
        int maxlen = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        for(int index = 0;index<s.length();index++){
            if('(' == s.charAt(index)){
                stack.push(index);
                //continue;
            }else{
                if(stack.isEmpty()){
                    start = index+1;
                    //continue;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        maxlen = Math.max(maxlen, index-start+1);
                    }else{
                        maxlen = Math.max(maxlen, index-stack.peek());
                    }
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args){
        String s = ")()())";
        longestValidParenttheses func = new longestValidParenttheses();
        System.out.println(func.solution32(s));
    }
}
