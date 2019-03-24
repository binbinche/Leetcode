package leetcode;

public class maxScoreSightseeingPair {
    public int solution1021(int[] A){
        int max = 0;
        int temp = 0;
        for(int i =0; i<A.length;i++){
            max = Math.max(max,temp+A[i]-i);
            temp = Math.max(temp,A[i] +i);
        }
        return max;
    }

    public static void main(String[] args){
        int[] A ={8,1,5,2,6};
        maxScoreSightseeingPair func = new maxScoreSightseeingPair();
        System.out.println(func.solution1021(A));
    }
}
