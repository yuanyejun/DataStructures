package cn.structures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author 原野
 * @DATE 2023/9/20 15:54
 * @Description: 完成对逆波兰表达式的运算 后缀表达式
 * @Version 1.0
 */
public class PolandNotation {
    public static void main(String[] args) {

        //完成中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)×4)-5 => 转成 1 2 3 + 4 × + 5 –
        //2. 因为直接对 str 进行操作，不方便，因此 先将 "1+((2+3)×4)-5" =》 中缀的表达式对应的 List
        // 即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的 List => 后缀表达式对应的 List
        // 即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]
        String exp = "10+((2+3)×4)-5";
        List<String> list = toInfixExpressionList(exp);
        System.out.println(list);

        System.out.println("-------------------------------------------------------");
        // 先定义给逆波兰表达式
        // (3+4)* 5 - 6 => 3 4 + 5 + 5 * 6 -
        // 说明为了方便 逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "30 4 + 5 * 6 -";
        // 思路
        // 1. 先将 " 30 4 + 5 + 5 * 6 - " 放到arraylist中
        // 2.将arraylist传递给一个方法，遍历arraylist配合栈 完成计算


        List<String> rpnlist = getListString(suffixExpression);
        System.out.println(rpnlist);


        int calculate = calculate(rpnlist);
        System.out.println(calculate);


    }

    //将一个逆波兰表示 依次将数据和运算符放入arraylist中
    public static List<String> getListString(String suffixExpression){

        // 将 suffixExpression 分割
        String[] line = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<String>();
        for (String ele : line) {
            list.add(ele);
        }
        return list;

    }

    /**
     *
     1)从左至右扫描，将 3 和 4 压入堆栈；

     2)遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；

     3)将 5 入栈；

     4)接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；

     5)将 6 入栈；

     6)最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
     */

    public static int calculate(List<String> ls){

        //创建栈 只需要一个栈即可
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            //使用正则表达式取出数字
            if (item.matches("\\d+")){//匹配多位数
                //入栈
                stack.push(item);
            }else {
                // pop出两个数 并运算 在入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num1 - num2;
                }else if (item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/") ){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("符号有问题@@@");
                }
                //把res入栈
                stack.push(res + "");
            }

        }
        //最后留着stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }


    /**
     * 1) 初始化两个栈：运算符栈 s1 和储存中间结果的栈 s2；
     *
     * 2) 从左至右扫描中缀表达式；
     *
     * 3) 遇到操作数时，将其压 s2；
     *
     * 4) 遇到运算符时，比较其与 s1 栈顶运算符的优先级：
     *
     *          1.如果 s1 为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     *
     *          2.否则，若优先级比栈顶运算符的高，也将运算符压入 s1；
     *
     *          3.否则，将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到(4-1)与 s1 中新的栈顶运算符相比较；
     *
     * 5) 遇到括号时：
     *          (1) 如果是左括号“(”，则直接压入 s1
     *          (2) 如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
     *
     * 6) 重复步骤 2 至 5，直到表达式的最右边
     *
     * 7) 将 s1 中剩余的运算符依次弹出并压入 s2
     *
     * 8) 依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     */

    //将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s){

        //定义一个list 存放中缀表达式 存放的内容
        ArrayList<String> list = new ArrayList<>();
        int i = 0;// 这是一个指针 用于遍历中缀表达式字符串
        String str; //对多位数的拼接
        char c; //每遍历到一个字符 就放到c
        do {
            //如果c是一个非数字,我需要加入到c
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){ //非数字
                list.add("" + c);
                i++; // i需要后移
            }else { //如果是一个数 需要考虑多位数的问题
                str = ""; //先将str 置成空串 0[48] - 9[57]
                while (i < s.length() && ( c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c; //拼接
                    i++;
                }
                list.add(str);
            }
        }while (i < s.length());

        return list;
    }

}


