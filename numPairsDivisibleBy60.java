package leetcode;

public class numPairsDivisibleBy60 {

    /**1013. Pairs of Songs With Total Durations Divisible by 60
     User Accepted: 2205
     User Tried: 2837
     Total Accepted: 2246
     Total Submissions: 6218
     Difficulty: Easy
     In a list of songs, the i-th song has a duration of time[i] seconds.

     Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
     Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.

     Example 1:
     Input: [30,20,150,100,40]
     Output: 3
     Explanation: Three pairs have a total duration divisible by 60:
     (time[0] = 30, time[2] = 150): total duration 180
     (time[1] = 20, time[3] = 100): total duration 120
     (time[1] = 20, time[4] = 40): total duration 60
     Example 2:
     Input: [60,60,60]
     Output: 3
     Explanation: All three pairs have a total duration of 120, which is divisible by 60.
     Note:
     1 <= time.length <= 60000
     1 <= time[i] <= 500*/

    public int solution1013(int[] time){
        int[] list = new int[60];
        for(int i : time){
            list[i%60]++;
        }
        int count = 0;
        for(int i = 1;i<30;i++){
            count += list[i] * list[60-i];
        }
        count += list[0]*(list[0]-1)/2;
        count += list[30]*(list[30]-1)/2;
        return count;
    }

    public static void main(String[] args){
        int[] time= {30,20,150,100,40};
        numPairsDivisibleBy60 func = new numPairsDivisibleBy60();
        System.out.println(func.solution1013(time));
    }
}
