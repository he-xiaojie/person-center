package com.hexiaojie.person.center.sort;

public class MergeSortTest {


    public static void main(String[] args) {

    }


    public static void mergeSort(int[] nums){
        /**
         * 归并排序：采用分治的思想，利用递归进行排序。向上递的时候分两段，向下归的的时候，做merge操作
         */
        int length = nums.length;
        mergeSort_r(nums, 0, length -1);
    }

    public static void mergeSort_r(int[] nums, int p, int r){
        /**
         * 递归处理
         */
        //防治数据过大溢出
        int q = p + (r -p)/2;
        mergeSort_r(nums, p, q);
        mergeSort_r(nums, q+1, r);
        merge(nums, p, q, r);
    }

    public static void merge(int[] nums, int p, int q, int r){
        /**
         * 把两个数组合并
         */
        //第一个数组的第一个脚标
        int i = p;
        //第二个数组的第一个脚标
        int j = q +1;
        int k = 0;
        //申请一个额外的数组空间存储原来的数组
        int[] tmp = new int[r -p +1];
        while(i <= q && j <= r){
            if(nums[i] < nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
            }
        }

        while( i <= q){
            tmp[k++] = nums[i++];
        }
        while( j <= r){
            tmp[k++] = nums[j++];
        }
        //最后把tmp数组元素，再放回原来的数组
        for(i = 0; i < r-p +1; i++){
            nums[p+i] = tmp[i];
        }
    }
}
