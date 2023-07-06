package com.hexiaojie.person.center.leetcode;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int sum = nums[0] + nums[1] + nums[2] + nums[3];
        System.out.println(sum);
        System.out.println(fourSum(nums, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target){
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< length; i++){
            map.put(nums[i], i);
        }

        for (int i = 0; i < length; i++) {
            if(i != 0 && nums[i] == nums[i -1]){
                //避免a重复
               continue;
            }
            for (int j = i + 1; j < length; j++) {
                if(j != i +1 && nums[j] == nums[j -1]){
                    //避免b重复
                    continue;
                }
                for (int k = j + 1; k < length; k++) {
                    if(k != j +1 && nums[k] == nums[k -1]){
                        //避免C重复
                        continue;
                    }

                    long targetNum =  (long) target -  (long) nums[i] -  (long) nums[j] -  (long) nums[k];
                    if(targetNum > Integer.MAX_VALUE || targetNum < Integer.MIN_VALUE){
                        continue;
                    }
                    int target1 = (int) targetNum;
                    if(!map.containsKey(target1)){
                        continue;
                    }
                    Integer p = map.get(target1);

                    if(p > k){//保证了p不重复
                        List<Integer> resultItem = new ArrayList<>();
                        resultItem.add(nums[i]);
                        resultItem.add(nums[j]);
                        resultItem.add(nums[k]);
                        resultItem.add(nums[p]);
                        result.add(resultItem);
                    }
                }
            }
        }
        return result;
    }
}

