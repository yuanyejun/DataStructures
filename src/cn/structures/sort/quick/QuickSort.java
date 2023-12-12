package cn.structures.sort.quick;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author 原野
 * @DATE 2023/10/9 8:39
 * @Description: 快速排序
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {

        /**
         *  快速排序（Quicksort）是对冒泡排序的一种改进。基本思想是：通过一趟排序将要排序的数据分割成独立的两
         * 部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排
         * 序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
         */

//        int[] arr = {-9,78,0,23,-567,70};
//        quicksort(arr,0,arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//
//
        int arr[] = new int[8000000];//
        //创建要给 80000 个的随机的数组， 在我的机器是 2-3 秒，比冒泡快. int[] arr = new int[80000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }


        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quicksort(arr,0,arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        //System.out.println("排序后");
        //System.out.println(Arrays.toString(arr));


    }

    public static void quicksort(int[] arr,int left,int right){

        int l = left; //左下标
        int r = right; // 右下标
        int temp = 0; //临时变量，作为交换时使用
        //pivot 中轴值
        //while 循环的目的是让比 pivot 值小放到左边
        //比 pivot 值大放到右边
        int pivot = arr[(left + right) / 2];

        while ( l < r){
            //在 pivot 的左边一直找,找到大于等于 pivot 值,才退出
            while ( arr[l] < pivot){
                l += 1;
            }
            //在 pivot 的右边一直找,找到小于等于 pivot 值,才
            while ( arr[r] > pivot){
                r -= 1;
            }
            //如果 l >= r 说明 pivot 的左右两的值，已经按照左边全部是
            //小于等于 pivot 值，右边全部是大于
            if (l >= r){
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个 arr[l] == pivot 值 相等 r--， 前
            if (arr[l] == pivot){
                r--;
            }

            //如果交换完后，发现这个 arr[r] == pivot 值 相等 l++， 前
            if (arr[r] == pivot){
                l++;
            }
        }

        // 如果 l == r, 必须 l++, r--, 否则为出现
        if (l == r){
            l++;
            r--;
        }

        //向左递归
        if (left < r){
            quicksort(arr,left,r);
        }

        //向右递归
        if(right > l) {
            quicksort(arr, l, right);
        }

    }
}
