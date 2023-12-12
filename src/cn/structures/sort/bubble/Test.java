package cn.structures.sort.bubble;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author 原野
 * @DATE 2023/10/8 11:27
 * @Description: 测试冒泡速度
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {



        //测试一下冒泡排序的速度 O(n^2), 给 80000 个数据，测试
        //创建要给 80000 个的随机的数组
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        bubblesort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        //System.out.println("排序后");
        //System.out.println(Arrays.toString(arr));

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
            if (!flag){ //一次交换都没有发生
                break;
            }else {
                flag = false; //重置flag
            }

        }

    }

}
