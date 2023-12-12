package cn.structures.recursion;

/**
 * @Author 原野
 * @DATE 2023/10/16 14:05
 * @Description:
 * @Version 1.0
 */
public class RecursionTest {
    public static void main(String[] args) {

        test(4);

        test2(4);
    }

    public static void test(int n){
        if (n > 2){
            test(n -1);
        }
        System.out.println("n=" + n);
    }

    public static int test2(int n){
        if (n == 1){
            return 1;
        }
        return test2(n - 1) * n;
    }
}
