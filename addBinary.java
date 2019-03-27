package leetcode;

public class addBinary {
    public String solution67(String a, String b) {
        String res = "";
        int alen = a.length() - 1;
        int blen = b.length() - 1;
        int flag = 0;
        while (alen >= 0 && blen >= 0) {
            int a1 = a.charAt(alen) - '0';
            int b1 = b.charAt(blen) - '0';
            int re = a1 + b1 + flag;
            if (re > 1) {
                flag = 1;
                res = (re - 2) + res;
            } else {
                flag = 0;
                res = re + res;
            }
            alen--;
            blen--;
        }
        while (alen >= 0) {
            int a1 = a.charAt(alen) - '0';
            int re = a1 + flag;
            if (re > 1) {
                flag = 1;
                res = (re - 2) + res;
            } else {
                flag = 0;
                res = re + res;
            }
            alen--;
        }
        while (blen >= 0) {
            int b1 = b.charAt(blen) - '0';
            int re = b1 + flag;
            if (re > 1) {
                flag = 1;
                res = (re - 2) + res;
            } else {
                flag = 0;
                res = re + res;
            }
            blen--;
        }
        if (flag == 1)
            return res = "1" + res;
        else
            return res;
    }
    public static void main(String[] args){
        String a = "111111";
        String b = "1011110";
        addBinary func = new addBinary();
        System.out.println(func.solution67(a,b));
    }
}
