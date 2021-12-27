package com.lumia.web.utils;

import jdk.nashorn.internal.objects.annotations.Where;

import java.util.HashSet;
import java.util.Set;

public class StrSplit {


//    public static Set<String> getSub(String arr, Integer deleteNum) {
//        Set<String> result = new HashSet<>();
//        if (deleteNum <= 0) {
//            result.add(arr);
//            return result;
//        }
//        String splitStr = arr;
//        while (splitStr.length() > arr.length() - deleteNum) {
//            for (int i = 0; i < ; i++) {
//
//            }
//        }
//    }

    public static void main(String[] args) {
        distinctSubSeqII("fdsdfs");
    }


    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((2 * leftSum) == (sum - nums[i])) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        int index = (nums.length / 2);
        if (target == nums[index]) {
            return index;
        }else if (target < nums[index]) {
            while (index > 0) {
                if (target > nums[index - 1]) {
                    return index;
                } else if (target == nums[index - 1]) {
                    return index - 1;
                }else {
                    index--;
                }
            }
            return 0;
        } else {
            while (index < nums.length - 1) {
                if (target <= nums[index + 1]) {
                    return index + 1;
                } else {
                    index++;
                }
            }
            return  nums.length;
        }
    }

    public static int distinctSubSeqII(String s) {

        int MOD = 1_000_000_007;

        int N = s.length();

        return MOD;
    }
}
