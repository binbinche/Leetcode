public class solution593 {
    /**
     * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
     * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
     * 示例:
     * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
     * 输出: True
     * 注意:
     * 所有输入整数都在 [-10000，10000] 范围内。
     * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
     * 输入点没有顺序。
     */

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double p12 = sideLength(p1, p2);
        double p13 = sideLength(p1, p3);
        double p14 = sideLength(p1, p4);
        double p23 = sideLength(p2, p3);
        double p24 = sideLength(p2, p4);
        double p34 = sideLength(p3, p4);

        if (p12 == p13 && p12 == p24 && p24 == p34){
            if (p14 == p23 && p14 != p12)
                return true;
            else
                return false;
        } else if (p12 == p14 && p14 == p23 && p23 == p34) {
            if (p13 == p24 && p13 != p24)
                return true;
            else
                return false;
        } else if (p13 == p14 && p14 == p23 && p23 == p24) {
            if (p12 == p34 && p12 != p13)
                return true;
            else
                return false;
        } else
            return false;
    }

    private double sideLength(int[] p1, int[] p2) {
        double length = Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
        return length;
    }

    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        solution593 a = new solution593();
        boolean result = a.validSquare(p1, p2, p3, p4);
        System.out.println(result);
    }
}
