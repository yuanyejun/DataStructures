package cn.structures.sort.donald;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author 原野
 * @DATE 2023/10/8 15:18
 * @Description: 希尔排序
 * @Version 1.0
 */
public class DonaldSort {
    public static void main(String[] args) {


        /**
         * 有一群小牛, 考试成绩分别是 {8,9,1,7,2,3,5,4,6,0} 请从小到大排序. 请分别使用
         * 1) 希尔排序时， 对有序序列在插入时采用交换法, 并测试排序速度.
         * 2) 希尔排序时， 对有序序列在插入时
         *
         * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含
         * 的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便
         */

//        int [] arr = {8,9,1,7,2,3,5,4,6,0};

        int arr[] = new int[100000000];//

        //创建要给 80000 个的随机的数组， 在我的机器是 2-3 秒，比冒泡快. int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); // 生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellsort2(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);


    }

    public static void shellsort2(int[] arr){
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0;gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共 5 组，每组有 2 个元素)
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

//            System.out.println("第"+ (++count ) +"轮~~:" + Arrays.toString(arr));
        }

    }

    public static void shellsort(int[] arr){

        //第1轮
        // 希尔排序的第 1 轮排序
        // 因为第 1 轮排序，是将 10 个数据分成了 5
        for (int i = 5; i< arr.length;i++){
            // 遍历各组中所有的元素(共 5 组，每组有 2 个元素)
            for (int j = i - 5; j >= 0; j -= 5){
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 5]){
                    int temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j+5] = temp;
                }
            }
        }

        System.out.println("第1轮~~");
        System.out.println(Arrays.toString(arr));

        //2
        // 希尔排序的第 2 轮排序
        // 因为第 2 轮排序，是将 10 个数据分成了 5/2 =
        for (int i = 2; i< arr.length;i++){
            // 遍历各组中所有的元素(共 5 组，每组有 2 个元素)
            for (int j = i - 2; j >= 0; j -= 2){
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 2]){
                    int temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("第2轮~~");
        System.out.println(Arrays.toString(arr));

        //3
        //// 因为第 3 轮排序，是将 10 个数据分成了 2/2
        for (int i = 1; i< arr.length;i++){
            // 遍历各组中所有的元素(共 5 组，每组有 2 个元素)
            for (int j = i - 1; j >= 0; j -= 1){
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("第3轮~~");
        System.out.println(Arrays.toString(arr));

    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellsort3(int[] arr){

        // 增量 gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0;gap /= 2) {

            // 从第 gap 个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length;i++){
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出 while 后，就给 temp 找到插入的位置
                    arr[j] = temp;
                }
            }
        }


    }


}
