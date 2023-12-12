package cn.structures.search.binarys;

import java.util.ArrayList;

/**
 * @Author 原野
 * @DATE 2023/10/9 14:04
 * @Description: 二分法查找 需要先排序
 * @Version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        //注意：使用二分查找的前提是 该数组是有序的.
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };

        int result = binarySearch(arr,0,arr.length - 1,199);
        System.out.println(result);

        int arr2[] = { 1, 8, 10, 89,1000,1000, 1234 };

        ArrayList resultList = binarySearchlist(arr2, 0, arr2.length, 1000);
        System.out.println(resultList);

    }

    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param finalVal 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int binarySearch(int[] arr,int left, int right,int finalVal){

        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (finalVal > midVal){ //向右递归
            return binarySearch(arr,mid + 1,right,finalVal);
        }else if (finalVal < midVal){ //向左递归
            return binarySearch(arr,left,mid - 1,finalVal);
        }else {
            return mid;
        }

    }



    public static ArrayList binarySearchlist(int[] arr, int left, int right, int finalVal){

        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (finalVal > midVal){ //向右递归
            return binarySearchlist(arr,mid + 1,right,finalVal);
        }else if (finalVal < midVal){ //向左递归
            return binarySearchlist(arr,left,mid - 1,finalVal);
        }else {

            /*
             * 课后思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
             * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
             *
             * 思路分析
             * 1. 在找到 mid 索引值，不要马上返回
             * 2. 向 mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
             * 3. 向 mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
             * 4. 将 Arraylist 返回
             */
            ArrayList<Integer> list = new ArrayList<>();
            //向 mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合
            int temp = mid - 1;
            while(true) {
                if (temp < 0 || arr[temp] != finalVal) {//退出

                    break;
                }
            //否则，就 temp 放入到 resIndexlist
                list.add(temp);
                temp -= 1; //temp 左移
            }
            list.add(mid); //
            //向 mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            temp = mid + 1;
            while(true) {
                if (temp > arr.length - 1 || arr[temp] != finalVal) {//退出
                    break;
                }
                //否则，就 temp 放入到 resIndexlist
                list.add(temp);
                temp += 1; //temp 右移
            }
            return list;
        }
    }

}
