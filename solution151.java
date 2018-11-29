import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class solution151 {
    public String reverseWords(String s){
        String [] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }
    public static void main(String []args){
        String s = "the man is superman";
        solution151 a = new solution151();
        String result = a.reverseWords(s);
        System.out.println(result);
    }
}
