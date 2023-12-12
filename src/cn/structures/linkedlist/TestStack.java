package cn.structures.linkedlist;

import java.util.Stack;

/**
 * @Author 原野
 * @DATE 2023/9/15 15:15
 * @Description: 演示栈
 * @Version 1.0
 */
public class TestStack {







    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        // 入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("jity");

        //出栈
        while (stack.size() > 0){
            System.out.println(stack.pop()); //pop就是将stack的数据取出
        }

    }
}
