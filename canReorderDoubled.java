import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.*;

public class canReorderDoubled {
    /**给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
     示例 1：
     输入：[3,1,3,6]
     输出：false
     示例 2：
     输入：[2,1,2,6]
     输出：false
     示例 3：
     输入：[4,-2,2,-4]
     输出：true
     解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
     示例 4：
     输入：[1,2,4,16,8,4]
     输出：false
     提示：
     0 <= A.length <= 30000
     A.length 为偶数
     -100000 <= A[i] <= 100000*/
    public boolean solution954(int[] A) {
        int len = A.length;
        if(len == 0){
            return true;
        }
        int m, n;
        Map<Integer, Integer> map = new TreeMap<>();
        //把数组A每个元素的个数进行排序
        for(int key : A){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(int key : map.keySet()){
            System.out.println(key);
            if(map.get(key) == 0){
                continue;
            }
            m = map.get(key);
            if(key < 0){
                key = key / 2;//比如-4在treemap中排在-2前面，所以是key/2

            }else{
                key = key * 2;//比如2在treemap中排在4前面，所以是key*2
            }
            n = map.getOrDefault(key, 0);
            if(m > n){
                return false;
            }
            map.put(key, n - m);
        }
        return true;
    }
    public static void main (String[] args){
        int[] A ={4,-2,2,-4};
        canReorderDoubled func = new canReorderDoubled();
        boolean result = func.solution954(A);
        System.out.println(result);
    }

}

