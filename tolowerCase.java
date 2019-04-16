package leetcode;

public class tolowerCase {
    /**实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     示例 1：
     输入: "Hello"
     输出: "hello"
     示例 2：
     输入: "here"
     输出: "here"
     示例 3：
     输入: "LOVELY"
     输出: "lovely"*/
    public String solution709(String s){
        StringBuffer str = new StringBuffer();

        if(s.length()==0 ||s =="")
            return s;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                str.append((char) (s.charAt(i)+32));
            }else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
    public static void main(String[] args){
        String s = "Hello";
        tolowerCase func = new tolowerCase();
        System.out.println(func.solution709(s));
    }

}
