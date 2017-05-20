package com.kotai.other;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is
 * equal to the product of all elements of nums except num[i] Without division and in O(n)
 **/
public class ProductExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int index = 0, temp = 1; index < nums.length; index++) {
            result[index] = temp;
            temp *= nums[index];
        }

        for (int index = nums.length - 1, temp = 1; index >= 0; index--) {
            result[index] *= temp;
            temp *= nums[index];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptItself product = new ProductExceptItself();
        int[] result = product.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result));
    }
}

