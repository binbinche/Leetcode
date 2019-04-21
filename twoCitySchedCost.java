package leetcode;

import java.util.*;

public class twoCitySchedCost {
    /**1029. 两地调度 
     公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
     返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
     示例：
     输入：[[10,20],[30,200],[400,50],[30,20]]
     输出：110
     解释：
     第一个人去 A 市，费用为 10。
     第二个人去 A 市，费用为 30。
     第三个人去 B 市，费用为 50。
     第四个人去 B 市，费用为 20。
     最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
     提示：
     1 <= costs.length <= 100
     costs.length 为偶数
     1 <= costs[i][0], costs[i][1] <= 1000*/
    public int solution1029(int[][] cost){
        int len = cost.length;
        int base  = 0;
        int[] savemoney = new int[len];
        for(int i = 0;i<len;i++){
            base += cost[i][0];
            savemoney[i] = cost[i][1] - cost[i][0];
        }
        //Arrays.sort(cost, (a,b)->(a[0]-a[1])-(b[0]-b[1]));
//        Arrays.sort(cost, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return (o1[0]-o1[1])-(o2[0]-o2[1]);
//            }
//        });
        Arrays.sort(savemoney);
        for(int i = 0;i<len/2;i++){
            base +=savemoney[i];
        }
        return base;
    }
    public static void main(String[] args){
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        twoCitySchedCost func = new twoCitySchedCost();
        System.out.println(func.solution1029(costs));

    }
}
