package leetcode.滑动窗口.定长.进阶;

import java.util.*;

public class Code2653 {
    public static void main(String[] args) {
        System.out.println(getSubarrayBeauty(new int[]{1, -1, -3, -2, 3}, 3, 2));
    }

    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        final int BIAS = 50;
        int[] cnt = new int[BIAS * 2 + 1];
        for (int i = 0; i < k - 1; i++) { // 先往窗口内添加 k-1 个数
            cnt[nums[i] + BIAS]++;
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = k - 1; i < n; i++) {
            cnt[nums[i] + BIAS]++; // 进入窗口（保证窗口有恰好 k 个数）
            int left = x;
            for (int j = 0; j < BIAS; j++) { // 暴力枚举负数范围 [-50,-1]
                left -= cnt[j];
                if (left <= 0) { // 找到美丽值
                    ans[i - k + 1] = j - BIAS;
                    break;
                }
            }
            cnt[nums[i - k + 1] + BIAS]--; // 离开窗口
        }
        return ans;
    }
}
