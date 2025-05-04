package leetcode.滑动窗口.不定长.基础;

public class Code1493 {
    public static void main(String[] args) {
//        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
//        System.out.println(longestSubarray(new int[]{1, 1, 1}));
    }

    /**
     * 相当于找到一个 必须包含一个0的最长全1
     */
    public static int longestSubarray(int[] nums) {
        int maxlen = 0;
        int temp = 0;
        int zero_cnt = 0;

        for (int right = 0, left = 0; right < nums.length; right++) {

            if (nums[right] == 0) zero_cnt++;

            while (zero_cnt > 1) {
                if (nums[left] == 0) zero_cnt--;
                temp -= nums[left];
                left++;
            }

            temp += nums[right];
            maxlen = Math.max(temp, maxlen);

        }
        return maxlen == nums.length ? maxlen - 1 : maxlen;
    }

}
