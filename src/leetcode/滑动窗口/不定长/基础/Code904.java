package leetcode.滑动窗口.不定长.基础;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code904 {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));

    }

    public static int totalFruit(int[] fruits) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, left = 0; i < fruits.length; i++) {
            map.merge(fruits[i], 1, Integer::sum);
            while (map.size() > 2) {
                if (map.merge(fruits[left], -1, Integer::sum) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
