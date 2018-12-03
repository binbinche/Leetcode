public class solution58 {
    public int lengthOfLastWord(String s){
        if(s ==null ||s.length() ==0)
            return 0;
        if(s.length()==1 && s.charAt(0)!=' ')
            return 1;
        int i =0;
        int count = 0;
        int flag = 0;
        for(i= s.length()-1;i>=0;i++){
            while(s.charAt(i)==' ' && i!=0)
                i--;
            while(s.charAt(i)!=' ' && i!=0){
                count++;
                i--;
                flag=1;
            }
            if(flag==1)
                break;
        }
        if(i ==0 && s.charAt(0)!= ' ')
            return count+1;
        if(flag ==0 && s.charAt(0)!=' ')
            return 1;
        return count;
    }
    public static void main(String [] args){
        String s = "hello world";
        solution58 a = new solution58();
        int result = a.lengthOfLastWord(s);
        System.out.println(result);
    }
}
