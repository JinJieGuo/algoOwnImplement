package ownCode.recursion;


/***
 *
 * LeetCode - 70  《爬楼梯》
 * 假设有n个台阶，每次可以跨1个台阶或者2个台阶，请问这n个台阶有多少种走法？
 */

public class TestRecursion {




    public static int f(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return f(n-1) + f(n-2);
    }

    public static void main(String[] args) {
        int f = f(10);
        System.out.println(f);

    }


}
