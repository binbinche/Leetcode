package leetcode;

public class isBoomerang {
    /**1037. 有效的回旋镖
     回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
     给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
     示例 1：
     输入：[[1,1],[2,3],[3,2]]
     输出：true
     示例 2：
     输入：[[1,1],[2,2],[3,3]]
     输出：false
     提示：
     points.length == 3
     points[i].length == 2
     0 <= points[i][j] <= 100*/

    public boolean solution1037(int[][] points){
        long slope1;
        long slope2;
        slope1 = (points[1][1]-points[0][1])*(points[2][0]-points[1][0]);
        slope2 = (points[2][1]-points[1][1])*(points[1][0]-points[0][0]);

        if(slope1 == slope2)
            return false;
        else
            return true;
    }
    public static void main(String[] args){
        int[][] points = {{0,0},{0,2},{2,1}};
        isBoomerang func = new isBoomerang();
        System.out.println(func.solution1037(points));
    }
}
