package leetcode.滑动窗口.定长.基础;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code2461 {
    public static void main(String[] args) {
//        System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
//        System.out.println(maximumSubarraySum(new int[]{4,4,4}, 3));
        System.out.println(maximumSubarraySum(new int[]{9, 9, 9, 1, 2, 3}, 3));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.merge(nums[i], 1, Integer::sum);
            if (i < k - 1) continue;
            if (map.size() == k)
                ans = Math.max(ans, sum);
            sum -= nums[i - k + 1];
            if (map.merge(nums[i - k + 1], -1, Integer::sum) == 0) {
                map.remove(nums[i - k + 1]);
            }
        }
        return ans;
    }
}
