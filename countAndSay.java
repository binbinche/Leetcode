public class countAndSay {
    /**报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     1.     1
     2.     11
     3.     21
     4.     1211
     5.     111221
     1 被读作  "one 1"  ("一个一") , 即 11。
     11 被读作 "two 1s" ("两个一"）, 即 21。
     21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     注意：整数顺序将表示为一个字符串。
     示例 1:
     输入: 1
     输出: "1"
     示例 2:
     输入: 4
     输出: "1211"*/
    //方法一是利用递归方法去做。
    public String countAndSay(int n){
        if(n ==1)
            return "1";
        String result = "1";
        for(int i = 1;i<n;i++){
            result = couvert(result);
        }
        return result;
    }

    String couvert(String str){
        int len = str.length();
        if(len==1) {
            return "1" + str;
        }
        String result = "";
        int count = 1;
        for(int i=1;i<len;i++){
            if(str.charAt(i-1)==str.charAt(i))
                count++;
            else
                result = result+ String.valueOf(count)+str.charAt(i-1);
            if(i == len-1)
                result = result+ String.valueOf(count)+str.charAt(i);
        }
        return result;
    }
    public static void main(String [] args){
        int n= 4;
        countAndSay a= new countAndSay();
        String result = a.countAndSay(4);
        System.out.println(result);
    }
}
