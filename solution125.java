public class solution125 {
    /**给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     说明：本题中，我们将空字符串定义为有效的回文串。
     示例 1:
     输入: "A man, a plan, a canal: Panama"
     输出: true
     示例 2:
     输入: "race a car"
     输出: false*/
    public boolean inPalindrome(String s){
        s = s.toLowerCase();
        char [] result = s.toCharArray();
        int begin =0, end = result.length-1;
        while(begin<end){
            if(result[begin]==result[end]){
                begin++;
                end--;
            }else if((int)result[begin]<48 ||(int)result[begin]>57&&(int)result[begin]<97||(int)result[begin]>122)
                begin++;
            else if((int)result[end]<48 ||(int)result[end]>57&&(int)result[end]<97||(int)result[end]>122)
                end--;
            else
                return false;
        }
        return true;
    }
    public static void main(String [] args){
        String s = "a main, niama";
        solution125 a = new solution125();
        boolean result = a.inPalindrome(s);
        System.out.println(result);
    }
}
