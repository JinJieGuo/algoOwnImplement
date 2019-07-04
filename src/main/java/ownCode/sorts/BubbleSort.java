package ownCode.sorts;

public class BubbleSort {






    public static int[] bubbleSort(int[] a){
        int n =  a.length;
        if (n <= 1) return a;
        int temp = 0;

        for (int i = 0; i < n; i++) {

            boolean flag = false;

            for (int j = 0; j < n-i-1 ; j++) {
                if (a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }

            if(!flag)break;

        }
        return a;
    }

//
//    // 冒泡排序，a 表示数组，n 表示数组大小
//    public void bubbleSort(int[] a, int n) {
//        if (n <= 1) return;
//
//        for (int i = 0; i < n; ++i) {
//            // 提前退出冒泡循环的标志位
//            boolean flag = false;
//            for (int j = 0; j < n - i - 1; ++j) {
//                if (a[j] > a[j+1]) { // 交换
//                    int tmp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = tmp;
//                    flag = true;  // 表示有数据交换
//                }
//            }
//            if (!flag) break;  // 没有数据交换，提前退出
//        }
//    }



    public static void main(String[] args) {
        int[] a = {0,4,5,5,7,8,2,3,4};
        int[] ints = bubbleSort(a);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }






}
