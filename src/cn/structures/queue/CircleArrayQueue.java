package cn.structures.queue;

import java.util.Scanner;

/**
 * @Author 原野
 * @DATE 2023/9/13 14:03
 * @Description: 环形数组
 * @Version 1.0
 */
public class CircleArrayQueue {
    public static void main(String[] args) {


        //创建一个队列对象
        CircleQueue arrayQueue = new CircleQueue(4);

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

class CircleQueue{

    private int maxSize; //数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数组用于存放数据,模拟队列

    public CircleQueue(Integer arrMaxSize ){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
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
        //直接将数据加入
        arr[rear] = n;
        // 将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列没有数据");
        }
        //分析出front是指向队列的第一个元素
        // 1.先把front对应的值保留到一个临时变量
        // 2.将front后移，考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            //通过抛出异常
            System.out.println("队列没有数据");
            return;
        }
        // 从front开始遍历,遍历多少个元素
        //
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return  (rear + maxSize - front) % maxSize;
    }


    //显示队列的头数据,注意不是取出数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列没有数据~~~");
        }

        return arr[front];
    }


}
