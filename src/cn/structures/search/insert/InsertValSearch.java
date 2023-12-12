package cn.structures.search.insert;

import java.util.Arrays;

/**
 * @Author 原野
 * @DATE 2023/10/12 14:34
 * @Description:
 * @Version 1.0
 */
public class InsertValSearch {


//1) 插值查找原理介绍:
//插值查找算法类似于二分查找，不同的是插值查找每次从自适应 mid 处开始查找。
//2) 将折半查找中的求 mid 索引的公式 , low 表示左边索引 left, high 表示右边索引 right. key 就是前面我们讲的 findVal
//3) int mid = low + (high - low) * (key - arr[low]) / (arr[high] - arr[low]) ;/*插值索引*/
//    对应前面的代码公式：
//    int mid = left + (right – left) * (findVal – arr[left]) / (arr[right] – arr[left


    public static void main(String[] args) {

        int [] arr = new int[100];
        for (int i = 1; i < 100;i++){
//            arr[i] = (int) (Math.random() * 100) + 1;
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));

        System.out.println();

        int result = insertValSearch(arr, 0, arr.length - 1, 89);
        System.out.println("下标为:" + result);

    }

    //插值查找算法
    /**
     *
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param finalVal 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public static int insertValSearch(int [] arr,int left,int right,int finalVal){
        //注意：findVal < arr[0] 和 findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || finalVal < arr[0] || finalVal > arr[arr.length - 1]) {
            return -1;
        }

        // 求出 mid, 自适应
        int mid = left + (right - left) * (finalVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (finalVal > midVal){
            return insertValSearch(arr,mid + 1,right,finalVal);
        }else if (finalVal < midVal){
            return insertValSearch(arr,left,mid + 1,finalVal);
        }else{

            return mid;
        }
    }

    //2插值查找注意事项：
    //1) 对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
    // 2) 关键字分布不均匀的情况下，该方法不一定比折半查找要好
}
