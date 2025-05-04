package leetcode.滑动窗口.定长.进阶;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Code438 {
    public static void main(String[] args) {
        findAnagrams1("cbaebabacd", "abc");
        findAnagrams("baa", "aa");
    }

    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] counts = new int[26];
        int sum = 0;
        int k = p.length();
        for (int i = 0; i < k; i++) {
            counts[p.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) {
                sum += map.merge(s.charAt(i) - 'a', 1, Integer::sum) > 0 ? 1 : 0;
            }
            if (i < k - 1) {
                continue;
            }
            if (sum == k && allMapValSum(map) == k && map.size() ==k) {
                ans.add(i - k + 1);
            }
            if (counts[s.charAt(i - k + 1) - 'a'] == 1) {
                Integer merge = map.merge(s.charAt(i - k + 1) - 'a', -1, Integer::sum);
                sum += merge >= 0 ? -1 : 0;
                if (merge == 0) {
                    map.remove(s.charAt(i - k + 1) - 'a');
                }
            }

        }
        return ans;
    }

    public static int allMapValSum(Map<Integer, Integer> map) {
        AtomicInteger sum = new AtomicInteger();
        map.entrySet().forEach(e -> sum.addAndGet(e.getValue()));
        return sum.get();
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26]; // 统计 p 的每种字母的出现次数
        int[] cntS = new int[26]; // 统计 s 的长为 p.length() 的子串 s' 的每种字母的出现次数
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++; // 统计 p 的字母
        }
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++; // 右端点字母进入窗口
            int left = right - p.length() + 1;
            if (left < 0) { // 窗口长度不足 p.length()
                continue;
            }
            if (Arrays.equals(cntS, cntP)) { // s' 和 p 的每种字母的出现次数都相同
                ans.add(left); // s' 左端点下标加入答案
            }
            cntS[s.charAt(left) - 'a']--; // 左端点字母离开窗口
        }
        return ans;
    }

}
