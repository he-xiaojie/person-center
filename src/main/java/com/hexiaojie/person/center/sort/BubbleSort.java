package com.hexiaojie.person.center.sort;

public class BubbleSort {

    /**
     * 冒泡排序：它重复地走访过要排序的元素列，依次比较两个相邻的元素，如果顺序（如从大到小、首字母从Z到A）错误就把他们交换过来
     *
     * 原理：
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param args
     */
    public static void main(String[] args) {

    }

    private int[] bubbleSort(int[] nums){
        int length = nums.length;
        if(length <= 1){
            return nums;
        }

        for(int i =0; i < length; i++){
            for(int j = i +1; j < length - i; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[j];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

        }
    return nums;
    }

    private void bubbleSort1(int[] nums){
        int length = nums.length;
        if(length <= 1){
            return ;
        }

        for(int i = 0; i < length; i ++){
            for(int j = i+1; i < length; j++){
                if(nums [i] > nums[j]){
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }

    }

}
