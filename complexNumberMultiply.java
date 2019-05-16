package leetcode;

public class complexNumberMultiply {
    /**给定两个表示复数的字符串。
     返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
     示例 1:
     输入: "1+1i", "1+1i"
     输出: "0+2i"
     解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
     示例 2:
     输入: "1+-1i", "1+-1i"
     输出: "0+-2i"
     解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
     注意:
     输入字符串不包含额外的空格。
     输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。*/
    public String solution537(String a, String b){
        String[] aList = a.split("[+|i]");
        String[] bList = b.split("[+|i]");
        //System.out.print(aList[0]);
        int x1 = Integer.parseInt(aList[0]);
        int y1 = Integer.parseInt(aList[1]);
        int x2 = Integer.parseInt(bList[0]);
        int y2 = Integer.parseInt (bList[1]);
        return Integer.toString(x1*x2+(-1)*y1*y2)+ "+" + Integer.toString(x1*y2+x2*y1) + "i";
    }

    public static void main(String[] args){
        String a = "1+1i";
        String b = "1+1i";
        complexNumberMultiply func = new complexNumberMultiply();
        System.out.println(func.solution537(a,b));
    }
}
