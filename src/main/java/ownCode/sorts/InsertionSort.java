package ownCode.sorts;

public class InsertionSort {


    /***
     * insertionSort
     * @param a
     * @return
     */
    public static int[] insertSort(int[] a){
        int n = a.length;
        if (n <= 1) return a;

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j  = i - 1;
                for (; j >=0 ; --j) {
                    if (a[j] > value){
                        a[j+1] = a[j];
                    }else{
                        break;
                    }
                }
            a[j+1] = value;
        }
        return a;
    }


    public static void main(String[] args) {
        int[] a  = {4,2,1,6,9,4,3,7};
        int[] ints = insertSort(a);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
