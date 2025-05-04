package leetcode.滑动窗口.定长.基础;

import java.util.Arrays;

public class Code1423 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(maxScore(new int[]{9,7,7,9,7,7,9}, 7));

    }

    public static int maxScore(int[] cardPoints, int k) {
        int s = 0;
        for (int i = 0; i < k; i++) {
            s += cardPoints[i];
        }
        int ans = s;
        for (int i = 1; i <= k; i++) {
            s += cardPoints[cardPoints.length - i] - cardPoints[k - i];
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
