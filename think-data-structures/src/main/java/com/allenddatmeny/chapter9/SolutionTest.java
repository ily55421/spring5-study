package com.allenddatmeny.chapter9;

import org.junit.Test;

/**
 * @Author: linK
 * @Date: 2022/7/7 9:46
 * @Description TODO
 */
public class SolutionTest {
    @Test
    public void test(){
        System.out.println(hammingWeight(9));
        //2
    }
    @Test
    public void testMaxSubArray(){
        int[] arr = {1, 3, 5};
        System.out.println(maxSubArray(arr));
        //9 求最大累加的和
    }
    @Test
    public void testMaxProduct(){
        int[] arr = {1, 3, 5};
        System.out.println(maxProduct(arr));
        //15 求最大乘积
    }

    public int maxSubArray(int[] nums) {
        int maxLocal = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxLocal = Math.max(nums[i], nums[i] + maxLocal);
            global = Math.max(global, maxLocal);
        }
        return global;
    }

    /**
     * 最大乘积
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int maxLocal = nums[0];
        int minLocal = nums[0];
        int global = nums[0];
        for(int i = 1; i < nums.length; i++){
            // 临时变量 用于求最小值
            int temp = maxLocal;
            maxLocal = Math.max(Math.max(nums[i] * maxLocal, nums[i]), nums[i] * minLocal);
            minLocal = Math.min(Math.min(nums[i] * temp, nums[i]), nums[i] * minLocal);
            global = Math.max(global, maxLocal);
        }
        return global;
    }
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            // n &= n - 1   相当于 n = n & n-1   & 2进制位同为1
            //
            n &= n - 1;
        }
        return count;
    }
    // you need to treat n as an unsigned value
    public int hammingOneWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
