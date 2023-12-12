package cn.structures.sort.insertion;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author 原野
 * @DATE 2023/10/8 14:32
 * @Description: 插入排序
 * @Version 1.0
 */
public class InsertionSort {
    public static void main(String[] args) {

        /**
         *
         *    插入排序（Insertion Sorting）的基本思想是：把 n 个待排序的元素看成为一个有序表和一个无序表，开始时有
         * 序表中只包含一个元素，无序表中包含有 n-1 个元素，排序过程中每次从无序表中取出第一个元素，把它的排
         * 序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。
         */

//        int arr[] = {101,34,119,1,-1,89};
//        insertsort2(arr);

        int arr[] = new int[100000000];//

        //创建要给 80000 个的随机的数组， 在我的机器是 2-3 秒，比冒泡快. int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); // 生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        insertsort2(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));


    }
    //插入排序
    public static void insertsort(int[] arr){

        //定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1; //即arr[1] 前面数的下标

        //给insertVal找到插入的位置
        // 给 insertVal 找到插入的位置
        // 说明
        // 1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
        // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        // 3. 就需要将 arr[insertIndex] 后移
        while (insertIndex >= 0 && insertIndex < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // 当退出 while 循环时，说明插入的位置找到, insertIndex + 1
        //这里我们判断是否需要赋值
        arr[insertIndex + 1] = insertVal;

        System.out.println("第1论插入~~");
        System.out.println(Arrays.toString(arr));


        //第2轮
        insertVal = arr[2];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;

        System.out.println("第2论插入~~");
        System.out.println(Arrays.toString(arr));


        //第2轮
        insertVal = arr[3];
        insertIndex = 3 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;

        System.out.println("第3论插入~~");
        System.out.println(Arrays.toString(arr));

    }


    //插入排序
    public static void insertsort2(int[] arr){



        for (int i = 1; i < arr.length;i++) {

            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1; //即arr[1] 前面数的下标

            //给insertVal找到插入的位置
            // 给 insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertIndex < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出 while 循环时，说明插入的位置找到, insertIndex + 1
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }


//            System.out.println("第"+i+"论插入~~");
//            System.out.println(Arrays.toString(arr));

        }
    }

}
