import java.util.List;
import java.util.ArrayList;
public class solveNQueens {
    public List<List<String>> solution51(int n ){
        List<List<String>> res = new ArrayList<List<String>>();
        int[] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = -1;
        }
        helper(list, n, 0, res);
        return res;
    }
    private void helper(int[] list, int n, int row, List<List<String>> res){
        if(row == n){
            List<String> out = new ArrayList<>();
            for(int i = 0;i<n;i++){
                StringBuffer sb = new StringBuffer();
                for(int j =0;j<n;j++){
                    if(j == list[i])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                out.add(sb.toString());
            }
            res.add(out);
            return;
        }
        for(int i=0;i<n;i++){
            if(check(list, row, i)){
                list[row] = i;
                helper(list, n ,row+1,res);
            }
        }
    }
    private boolean check(int[] list, int row, int col){
        for(int i = 0;i<row;i++){
            if(row-i == Math.abs(col-list[i]) || col == list[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        int n = 4;
        solveNQueens func = new solveNQueens();
        System.out.println(func.solution51(n));
    }
}
