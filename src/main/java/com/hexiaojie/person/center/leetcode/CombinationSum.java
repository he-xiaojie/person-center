package com.hexiaojie.person.center.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> result = new ArrayList<>();

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
     * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
     *  并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个
     * @param candidates
     * @param target
     * @return
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }

    /**
     *
     * @param candidates 整数数组
     * @param k 阶段
     * @param left 和剩余
     * @param path 可行解
     */
    public void backTrack(int[] candidates, int k, int left, List<Integer> path){
        if(left == 0){
            result.add(path);
            return;
        }

        if(k == candidates.length){
            return;
        }

        for (int i = 0; i <= left / candidates[i]; i++){
            for(int j = 0; j < i; j++){
                path.add(candidates[k]);
            }
            backTrack(candidates, k+1, left - i * candidates[k], path);
            for(int j = 0; j < i; j++){
                path.remove(path.size() - 1);
            }
        }
    }


}
