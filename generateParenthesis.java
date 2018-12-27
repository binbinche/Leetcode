import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public List<String> solution22(int n){
        List<String> list = new ArrayList<>();
        make(list, "", n,n);
        return list;
    }
    public void make(List<String>list,String our, int left, int right){
        if(left<0 || right<0||left>right){
            return ;
        }
        if(left==0 && right ==0){
            list.add(our);
            return;
        }
        make(list, our+'(',left-1,right);
        make(list, our+')',left,right-1);
    }
}
