public class solution387 {
    /**给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     案例:
     s = "leetcode"
     返回 0.
     s = "loveleetcode",
     返回 2.
     注意事项：您可以假定该字符串只包含小写字母。*/
    // 方法二
//    public int firstUniqChar(String s){
//        int temp;
//        int minIndex = -1;
//        for(char a = 'a';a<='z';a++){
//            temp = s.indexOf(a);
//            if(temp!=-1 && temp== s.lastIndexOf(a)){
//                minIndex = (minIndex==-1)? temp: Math.min(temp, minIndex);
//            }
//        }
//        return minIndex;
//    }
    //方法一
    public int firstUniqChar(String s){
        int index = 1;
        int [] array =new int [26];
        for(int i= 0;i<s.length();i++){
            int cha = (int)s.charAt(i)-97;
            if(array[cha]==0){
                array[cha] = index;
                index++;
            }else{
                array[cha] =-1;
            }
        }
        int resultIndex = Integer.MAX_VALUE;
        char result = '#';
        for(int i =0;i<array.length;i++){
            if(array[i]>0){
                if(array[i]<resultIndex){
                    resultIndex = array[i];
                    result = (char)(i+97);
                }
            }
        }
        if(result =='#')
            return -1;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == result)
                return i;
        }
        return -1;
    }
    public static void main(String [] args){
        String s = "leetcode";
        solution387 func = new solution387();
        int result = func.firstUniqChar(s);
        System.out.println(result);
    }
}
