package leetcode;

import java.util.ArrayList;
import java.util.List;

public class fizzBuzz {
    public List<String> solution412(int n ){
        List<String> res = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(i%3==0 && i%5==0){
                res.add("FizzBuzz");
            }else if(i%5==0){
                res.add("Buzz");
            }else if(i%3==0 ){
                res.add("Fizz");
            }else{
                res.add(i+"");
            }
        }
        return res;
    }
    public static void main(String[] args){
        int n = 15;
        fizzBuzz func = new fizzBuzz();
        System.out.println(func.solution412(n));
    }
}
