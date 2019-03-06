public class totalNQueens {
    private int count = 0;
    public int solutions52(int n){
        int[] list = new int[n];
        for(int i = 0;i<n;i++)
            list[i] = -1;
        helper(list, n, 0);
        return count;
    }
    private void helper(int[] list, int n, int row){
        if(row == n){
            count++;
            return;
        }
        for(int i = 0;i<n;i++){
            if(check(list, row, i)){
                list[row] = i;
                helper(list, n, row+1);
            }
        }
    }
    private boolean check(int[] list, int row, int col){
        for(int i =0;i<row; i++){
            if(row-i == Math.abs(col-list[i]) || col == list[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        int n = 4;
        totalNQueens func = new totalNQueens();
        System.out.println(func.solutions52(n));
    }
}
