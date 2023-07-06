package com.hexiaojie.person.center.leetcode;

import java.util.*;

public class ThreeSum {

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     *
     * 你返回所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     * @param args
     */
    public static void main(String[] args) {

    }


    public List<List<Integer>> threeSum(int[] nums) {
        //排序是为了后面去除重复的数据
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map =new HashMap<>();
        for(int i =0; i < length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < length; i ++){
            if(i != 0 && nums[i] == nums[i -1]){
                //避免A重复
                continue;
            }
            for(int j = i  + 1 ; j < length; j ++) {
                if(j != i  + 1 && nums[j] == nums[j -1]){
                    //避免B重复
                    continue;
                }
                //计算第三个值。
                int targetNum = 0 - nums[i] - nums[j];
                if(!map.containsKey(targetNum)){
                    continue;
                }
                int k = map.get(targetNum);
                if(k > j) {//哈希表保证了不存在C重复的问题
                    List<Integer> resultItem = new ArrayList<>();
                    resultItem.add(nums[i]);
                    resultItem.add(nums[j]);
                    resultItem.add(k);
                    result.add(resultItem);
                }
            }
        }
        return result;
    }
}
