package leetcode;

import java.util.Arrays;

public class lastStoneWeight {
    public int solution5063(int[] stones){
        while(stones.length>1){
            Arrays.sort(stones);
            int len = stones.length;
            int x= stones[len-2];
            int y = stones[len-1];
            if(x==y){
                stones = Arrays.copyOfRange(stones,0,len-2);
            }else{
                stones[len-2] = y-x;
                stones = Arrays.copyOfRange(stones,0,len-1);
            }
        }
        if(stones.length==0)
            return 0;
        else
            return stones[0];
    }
    public static void main(String[] args){
        int[] stones = {2,7,4,1,8,1};
        lastStoneWeight func = new lastStoneWeight();
        System.out.println(func.solution5063(stones));
    }
}
