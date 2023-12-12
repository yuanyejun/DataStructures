package cn.structures.stack;

/**
 * @Author 原野
 * @DATE 2023/9/19 13:29
 * @Description: 数组模拟栈
 * @Version 1.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) {

        // 数组模拟栈
        ArrayStack arrayStack = new ArrayStack(5);

        System.out.println(arrayStack.isEmpty());

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);

        System.out.println(arrayStack.isFull());

        arrayStack.list();

    }
}

//表示栈结构
class ArrayStack{

    private int maxSize; //栈大小
    private int[] stack; //数组模拟栈 数据就放在该数组中
    private int top = -1; //top表示栈顶 初始化为-1

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public  boolean isFull(){
        return top == maxSize;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈 -push
    public void push(int value){
        //判断栈是否满
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈 pop
    public Integer pop(){
        //判断栈是否为空
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return stack[top--];
    }

    //遍历栈 需要从栈顶开始显示数据
    public void list(){

        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }

    }


}