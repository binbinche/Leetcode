import java.util.Stack;

public class isvalid {
    public boolean solution20(String s){
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int len = chs.length;
        if(len == 1)
            return false;
        for(int i = 0;i<len;i++){
            if(stack.isEmpty() || !isMatch(stack.peek(), chs[i]))
                stack.push(chs[i]);
            else
                stack.pop();
        }
        return stack.isEmpty();

    }
    public boolean isMatch(char a, char b){
        switch (a){
            case '(': if(b==')') return true; else return false;
            case '{': if(b=='}') return true; else return false;
            case '[': if(b==']') return true; else return false;
            default: return false;
        }
    }
    public static void main(String []args){
        String s = "{}{}()[]";
        isvalid func = new isvalid();
        boolean reasult = func.solution20(s);
        System.out.println(reasult);
    }
}
