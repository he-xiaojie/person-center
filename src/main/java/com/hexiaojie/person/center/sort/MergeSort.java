package com.hexiaojie.person.center.sort;

public class MergeSort {
    /**
     * 归并排序
     * 利用分治的思想，用递归来实现
     */


    public void mergeSort(int[] nums){
        int length = nums.length;
        mergerSort_r(nums, 0, length -1);

    }

    public void mergerSort_r(int[] nums, int p, int r){
        if(p >= r) return;
        //防治数据过大溢出
        int q = p + (r -p)/2;
        mergerSort_r(nums, p, q);
        mergerSort_r(nums, q+1, r);

        //将上面两端合并
        merge(nums, p , q, r);
    }


    public void merge(int[] nums, int p, int q, int r){
        int i = p;
        int j = q +1;
        int k = 0;

        //申请一个大小跟nums一样的临时数组

        int[] tmp = new int[r - p +1];

        while(i <=q && j <= r){
            if(nums[i] < nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
            }
        }

        while(i <= q){
           tmp[k++] = nums[i++];
        }

        while(j <= r){
            tmp[k++] = nums[j++];
        }

        //将tmp数组拷会nums数组
        for(i = 0; i<= r -p; i++){
            nums[p + i] = tmp[i];
        }
    }

}
