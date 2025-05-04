package leetcode.滑动窗口.不定长.基础;

public class Code1208 {
    public static void main(String[] args) {
//        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
//        System.out.println(equalSubstring("abcd", "acde", 0));
//        System.out.println(equalSubstring("abcd", "cdef", 1));
//        System.out.println(equalSubstring("vjlqwkzamvyv", "suusjpqkhlkz", 7));
        /**
         * 3
         * 1
         * 1
         * 0
         */
    }

        public static int equalSubstring(String ss, String tt, int maxCost) {
            char[] s = ss.toCharArray();
            char[] t = tt.toCharArray();
            int cur = 0; //记录当前花销
            int max = 0;
            for(int R = 0,L = 0; R < t.length; R++){

                cur += Math.abs(s[R]-t[R]);

                while(cur > maxCost)  cur -= Math.abs(s[L]-t[L++]);


                max = Math.max(max,R-L+1);

            }
            return max;
        }
}
