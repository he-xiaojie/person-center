package com.hexiaojie.person.center.leetcode;

public class TwoSum {
    public static void main(String[] args) {


    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            int num = target - nums[i];
            for(int j = 0; j < nums.length; j++){
                if(num == nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


}
