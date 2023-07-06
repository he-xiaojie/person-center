package com.hexiaojie.person.center.sort;

public class QuickSort {
    /**
     * 快排：
     * 、(1)首先设定一个分界值，通过该分界值将数组分成左右两部分。
     * (2)将大于或等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。此时，左边部分中各元素都小于分界值，而右边部分中各元素都大于或等于分界值。
     * (3)然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
     * (4)重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左、右两个部分各数据排序完成后，整个数组的排序也就完成了。
     * @param args
     */
    public static void main(String[] args) {

    }

    private static void quickSort(int[] nums){
        int length = nums.length;
        quickSort_r(nums, 0, length - 1);
    }

    public static void quickSort_r(int[] nums, int p, int r){
        if(p >= r){
            return;
        }
        //获取分区点下表
        int q = partition(nums, p, r);
        quickSort_r(nums, p, q-1);
        quickSort_r(nums, q+1, r);
    }

    public static int partition(int[] nums, int p, int r){
        //初始没有元素。
        int i = p -1;
        //以数组的最后一个元素nums[r]为标志， 比它小的放到[p,i]，比它大的放到[i+1,j)
        // 未处理的(p,r-1)
        //遍历未处理的数组
        for(int j = p; i < r; j ++){
            if(nums[j] < nums[r]){
                swap(nums, i+1, j);
                i++;
            }
        }
        //最后把nums[r]跟i换个位置
        swap(nums, i +1, r);
        return i +1;
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
