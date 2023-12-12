package cn.structures.sort.bubble;

import java.util.Arrays;

/**
 * @Author 原野
 * @DATE 2023/10/8 10:54
 * @Description: 冒泡排序 O（n^2）
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {

        /**
         *  冒泡排序（Bubble Sorting）的基本思想是：通过对待排序序列从前向后（从下标较小的元素开始）,依次比较
         * 相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒

         优化：
         因为排序的过程中，各元素不断接近自己的位置，如果一趟比较下来没有进行过交换，就说明序列有序，因此要在
         排序过程中设置一个标志 flag 判断元素是否进行过交换。从而减少不必要的比较。(这里说的优化，可以在冒泡排
         序写好后，在进行)

         */

        int arr[] = {3, 9, -1, 10,20};



        System.out.println(arr.length);
        //冒泡排序演变过程 第一趟排序
        int temp = 0;
        for (int j = 0; j < arr.length - 1; j++){
            //如果前面的数比后面的数大 则交换
            if (arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));


        //冒泡排序演变过程 第二趟排序
//        int temp = 0;
        for (int j = 0; j < arr.length - 1 - 1; j++){
            //如果前面的数比后面的数大 则交换
            if (arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //冒泡排序演变过程 第三趟排序
//        int temp = 0;
        for (int j = 0; j < arr.length - 1 - 2; j++){
            //如果前面的数比后面的数大 则交换
            if (arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //冒泡排序演变过程 第四趟排序
//        int temp = 0;
        for (int j = 0; j < arr.length - 1 - 2; j++){
            //如果前面的数比后面的数大 则交换
            if (arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));


        System.out.println("------");

        int len[] = {3, 9, -1, 10,20};
        bubblesort(len);
    }

    public static void bubblesort(int[] arr){

        System.out.println("------");
        int temp = 0;
        boolean flag = false; //标识变量
        for (int i = 0; i < arr.length - 1;i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                //如果前面的数比后面的数大 则交换
                if (arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.println("第"+ (i + 1) +"次排序后的数组");
            System.out.println(Arrays.toString(arr));

            if (!flag){ //一次交换都没有发生
                break;
            }else {
                flag = false; //重置flag
            }

        }

    }
}
