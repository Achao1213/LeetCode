package leetcode.滑动窗口.不定长.基础;

import java.util.HashMap;
import java.util.Map;

public class Code3 {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
            if (!map.entrySet().stream().anyMatch(e -> e.getValue() > 1)) {
                ans = Math.max(ans, i - k + 1);
            } else {
                map.merge(s.charAt(k), -1, Integer::sum);
                k++;
            }
        }
        return ans;
    }

}
