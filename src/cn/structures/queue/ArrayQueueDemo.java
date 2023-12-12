package cn.structures.queue;

import java.util.Queue;
import java.util.Scanner;

/**
 * @Author 原野
 * @DATE 2023/9/13 13:11
 * @Description: 使用数组模拟队列
 * @Version 1.0
 */
class ArrayQueue{

    private int maxSize; //数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数组用于存放数据,模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，front是指向队列头的前一个位置
        rear = -1; //指向队列尾，指向队列尾的数据(即就是队列的最后一个数据)
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++;//rear后移
        arr[rear] = n;
    }

    //获取队列数据
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列没有数据");
        }
        front++;//front后移
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            //通过抛出异常
            System.out.println("队列没有数据");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据,注意不是取出数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列没有数据~~~");
        }

        return arr[front+1];
    }

}


public class ArrayQueueDemo {
    public static void main(String[] args) {

        //test

        //创建一个队列对象
        ArrayQueue arrayQueue = new ArrayQueue(3);

        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头部数据");

            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数字:");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据是: " + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.println("队列头的数据是: " + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("你输入有误");
                    break;
            }

        }
        System.out.println("程序退出~~");


    }
}



