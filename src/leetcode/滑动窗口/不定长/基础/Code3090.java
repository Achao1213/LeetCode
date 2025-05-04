package leetcode.滑动窗口.不定长.基础;

public class Code3090 {
    public static void main(String[] args) {
//        System.out.println(maximumLengthSubstring("bcbbbcba"));
        System.out.println(maximumLengthSubstring("aaaa"));
    }

    public static int maximumLengthSubstring(String s) {
        int left = 0;
        int ans = 0;
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
            if (letters[s.charAt(i) - 'a'] <= 2)
                ans = Math.max(ans, i - left + 1);
            while (letters[s.charAt(i) - 'a'] > 2) {
                letters[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return ans;
    }
}
