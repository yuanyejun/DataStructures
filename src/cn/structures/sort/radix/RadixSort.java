package cn.structures.sort.radix;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author 原野
 * @DATE 2023/10/9 13:08
 * @Description: 基数排序 bucket sort
 * @Version 1.0
 */
public class RadixSort {
    public static void main(String[] args) {

        /**
         * 1) 基数排序（radix sort）属于“分配式排序”（distribution sort），
         *          又称“桶子法”（bucket sort）或 bin sort，顾名思义，
         *            它是通过键值的各个位的值，将要排序的元素分配至某些“桶”中，达到排序的作用
         * 2) 基数排序法是属于稳定性的排序，基数排序法的是效率高的稳定性排序法
         * 3) 基数排序(Radix Sort)是桶排序的扩展
         * 4) 基数排序是 1887 年赫尔曼·何乐礼发明的。它是这样实现的：
         *              将整数按位数切割成不同的数字，然后按每个位数分别比较
         *
         *
         *
         *  1) 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。
         *           然后，从最低位开始，依次进行一次排序。
         *          这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
         *
         *
         */
//        int [] arr = {53,3,542,748,14,214};

//        radixsort(arr);
//
//        radixsort2(arr);
//
//        radixsort3(arr);

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

        radixsortfinal(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);



    }

    public static void radixsort(int [] arr){

        //定义一个二维数组，表示 10 个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含 10 个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为 arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,
        // 我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是 bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        //第 1 轮(针对每个元素的个位进行排序处理)
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[j] % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一维数组的下标依次取出  数据，放入原来数组)
        int index = 0;
        //遍历每一桶，并将桶中是数据，放入到原数组
        for (int k = 0; k < bucketElementCounts.length;k++) {
            //如果桶中，有数据，我们才放入到原数组
            if (bucketElementCounts[k] != 0){
                //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k];l ++){
                    //取出元素放入到 ar
                    arr[index++] = bucket[k][l];
                }
            }
            //第一轮处理后 需要将每个bucketElementCounts[k] = 0 ！！！
            bucketElementCounts[k] = 0;
        }
        System.out.println("第一轮:" + Arrays.toString(arr));
    }

    public static void radixsort2(int [] arr){

        //定义一个二维数组，表示 10 个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含 10 个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为 arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,
        // 我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是 bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        //第 2 轮(针对每个元素的个位进行排序处理)
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[j] / 10 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一维数组的下标依次取出  数据，放入原来数组)
        int index = 0;
        //遍历每一桶，并将桶中是数据，放入到原数组
        for (int k = 0; k < bucketElementCounts.length;k++) {
            //如果桶中，有数据，我们才放入到原数组
            if (bucketElementCounts[k] != 0){
                //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k];l ++){
                    //取出元素放入到 ar
                    arr[index++] = bucket[k][l];
                }
            }
            //第er轮处理后 需要将每个bucketElementCounts[k] = 0 ！！！
            bucketElementCounts[k] = 0;
        }
        System.out.println("第二轮:" + Arrays.toString(arr));
    }

    public static void radixsort3(int [] arr){

        //定义一个二维数组，表示 10 个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含 10 个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为 arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,
        // 我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是 bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        //第 3 轮(针对每个元素的个位进行排序处理)
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[j] / 100 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一维数组的下标依次取出  数据，放入原来数组)
        int index = 0;
        //遍历每一桶，并将桶中是数据，放入到原数组
        for (int k = 0; k < bucketElementCounts.length;k++) {
            //如果桶中，有数据，我们才放入到原数组
            if (bucketElementCounts[k] != 0){
                //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k];l ++){
                    //取出元素放入到 ar
                    arr[index++] = bucket[k][l];
                }
            }
            //第仨轮处理后 需要将每个bucketElementCounts[k] = 0 ！！！
            bucketElementCounts[k] = 0;
        }
        System.out.println("第二轮:" + Arrays.toString(arr));
    }

    public static void radixsortfinal(int [] arr){

        //得到数组中最大的数的位数
        int max = arr[0]; //假设第一个数就是最大数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }

        //得到最大数是几位数
        int maxLength = (max + "").length();




        //定义一个二维数组，表示 10 个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含 10 个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为 arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,
        // 我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是 bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        //使用循环将代码处理
        for (int i = 0,n = 1; i < maxLength; i++, n *= 10) {
            //第 final 轮(针对每个元素的个位进行排序处理)
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶的顺序(一维数组的下标依次取出  数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length;k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0){
                    //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k];l ++){
                        //取出元素放入到 ar
                        arr[index++] = bucket[k][l];
                    }
                }
                //第仨轮处理后 需要将每个bucketElementCounts[k] = 0 ！！！
                bucketElementCounts[k] = 0;
            }
//            System.out.println("第" + (i + 1 )+ "轮:" + Arrays.toString(arr));
        }


    }
}
