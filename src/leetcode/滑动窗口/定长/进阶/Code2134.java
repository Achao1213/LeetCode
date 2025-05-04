package leetcode.滑动窗口.定长.进阶;

public class Code2134 {
    public static void main(String[] args) {
//        System.out.println(minSwaps(new int[]{0,1,0,1,1,0,0}));
        System.out.println(minSwaps(new int[]{1, 1, 0, 0, 1}));
    }

    public static int minSwaps(int[] nums) {
        int k = 0, count = 0, MaxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            k += nums[i];    //获取窗口的大小
        }
        //主要是循环数组，相当在数组num拼接
        for (int i = 0; i < nums.length + k - 1; i++) {
            if (nums[i % nums.length] == 1) {    //当i超过数组的长度时，获取i的余数便是数组的首段元素
                count++;
            }
            if (i < k - 1) {
                continue;
            }
            MaxCount = Math.max(MaxCount, count);

            if (nums[(i - k + 1) % nums.length] == 1) {
                count--;
            }
        }
        return k - MaxCount;
    }

}
