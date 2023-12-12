package cn.structures.sort.merge;

import cn.structures.sort.bubble.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author 原野
 * @DATE 2023/10/9 9:59
 * @Description: 归并排序
 * @Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {

        /**
         *
         *   归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，
         *   该算法采用经典的分治（divide-and-conquer）
         * 策略（分治法将问题分(divide)成一些小的问题然后递归求解，
         * 而治(conquer)的阶段则将分的阶段得到的各答案"修
         * 补"在一起，即分而治之)。
         *
         *
         */

//        int [] arr = {8,4,5,7,1,3,6,2};
        int arr[] = new int[8000000];
        //归并排序需要一个额外空间
        int temp[] = new int[arr.length];
        //创建要给 80000 个的随机的数组， 在我的机器是 2-3 秒，比冒泡快. int[] arr = new int[80000];
        for (int i = 0; i < 8000000; i++) {
            // 生成一个[0, 8000000) 数
            arr[i] = (int) (Math.random() * 8000000);
        }


        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        mergesort(arr,0,arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }

    //分 + 合
    public static void mergesort(int[] arr,int left,int right,int[] temp){

        if (left < right){
            //中间的索引
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergesort(arr,left,mid,temp);
            //向右递归进行分解
            mergesort(arr,mid + 1,right,temp);

            //合并
            merge(arr,left,mid,right,temp);
        }

    }

    //合并的方法
    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        // 初始化 i, 左边有序序列的初
        int i = left;
        //初始化 j, 右边有序序列的
        int j = mid + 1;
        // 指向 temp 数组
        int t = 0;

        //(一)
        //先把左右两边(有序)的数据按照规则填充到 temp 数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right){ //继续
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp 数组
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else { //反之,将右边有序序列的当前元素，填充到 temp 数组
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到 temp

        //左边的有序序列还有剩余的元素，就全部填充到 temp
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }

        while ( j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //(三)
        //将 temp 数组的元素拷贝到 arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int templLeft = left;
        //第一次合并 tempLeft = 0 , right = 1 // tempLeft = 2 right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0 right = 7
        while (templLeft <= right){
            arr[templLeft] = temp[t];
            t++;
            templLeft++;
        }
    }
}
