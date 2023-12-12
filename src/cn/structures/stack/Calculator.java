package cn.structures.stack;

/**
 * @Author 原野
 * @DATE 2023/9/19 13:58
 * @Description: 栈实现综合计算器
 * @Version 1.0
 */
public class Calculator {
    public static void main(String[] args) {

        //完成表达式的运算
        String expression = "30+2*6-2";
        //创建两个栈 数栈 一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        //定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        String keepNum = "";
        int res = 0;
        char ch = ' '; //每次扫描的char保持到ch
        //开始while循环的扫描expression
        while (true){
            //依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么 然后做相应的处理
            if (operStack.isOper(ch)){ //如果是运算符
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()){
                    //如果符号栈有操作符 就进行比较 如果当前的操作符的优先级小于或者等于栈中的操作符,就需要
                    //从数栈中pop出两个数  在从符号栈中pop出一个符号  进行运算  将得到结果 入数栈 然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        //
                        num1 = numStack.pop();
                        num2 = numStack.peek();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);

                        //把运算结果入栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈

                    }else {
                        //如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    //如果为空直接入栈
                    operStack.push(ch);
                }
            }else { //如果是数 则直接入数栈
//                numStack.push(ch - 48);
                // 1. 当处理多位数时，不能发现是一个数就立即入栈
                // 2. 在处理数，需要向expression的表达式的index后再看一位
                // 如果是数就进行扫描 如果是符号才入栈 因此我们需要定义一个变量字符串 用于拼接
                 keepNum += ch;
                 //判断下一个字符是不是数字，如果是数字 则进行继续扫描，如果是运算符 则入栈
                //如果后一位是运算符 则入栈

                //如果ch已经是expression最后一位了 就直接入栈
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        //！！！！ 情况keyNum
                        keepNum = "";
                    }
                }

            }
            //让index + 1 ,并判断扫描到express最后.
            index++;
            if (index >= expression.length()){
                break;
            }
        }

        //当表达式扫描完毕 就顺序的从数栈和符号栈中pop出相应的数和符号 并运行
        while (true){
            //如果符号栈为空，则计算到最后的结果 数栈中只有一个数字 （结果）
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res); //入栈

        }
        //将数栈的最后数 pop出来
        int res2 = numStack.pop();
        System.out.printf("表达式%s = %d",expression,res2);

    }
}

//表示栈结构
class ArrayStack2{

    private int maxSize; //栈大小
    private int[] stack; //数组模拟栈 数据就放在该数组中
    private int top = -1; //top表示栈顶 初始化为-1

    //构造器
    public ArrayStack2(int maxSize){
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

    //返回当前栈顶的值 但是不是真正的pop
    public int peek(){
        return stack[top];
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

    //返回运算符的优先级,优先级 程序员来确定  返回的数越大 优先级越高
    public Integer priority(int oper){

        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1; //假定目前的表达式只有加减乘除
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(Integer num1,Integer num2,int oper){
        int res = 0; //存放计算的结果
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }

        return res;
    }


}
