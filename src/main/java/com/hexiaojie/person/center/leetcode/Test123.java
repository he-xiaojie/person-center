package com.hexiaojie.person.center.leetcode;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.*;

public class Test123 {

    /**
     * 一个数组,举例为 [1,2,1,3,5,6,5,7,6,1]
     *     1. 输出没有重复出现的元素[2,3,7]
     */

    public static void main(String[] args) {
        Integer[] nums = {1,2,1,3,5,6,5,7,6,1};
        System.out.println(printNum(nums));
    }

    private static Integer[] printNum(Integer[] nums){

        /**
         * 先找到重复的元素，然后再删除重复的元素
         *
         */
        List<Integer> arrayList = new ArrayList<>();
        //重复的数据
        Set<Integer> temp = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            Integer num = nums[i];
            if(!arrayList.contains(num)){
                //过滤重复的数据
                arrayList.add(num);
            }else{
                //记录重复的数据
                temp.add(num);
            }
        }
        for(Integer num : temp){
            arrayList.remove(num);
        }
        Integer[] result = arrayList.toArray(new Integer[arrayList.size()]);

        return result;
    }
}
