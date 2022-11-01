package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] arr = {9,8,5,2,7,1,3};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int [] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {
        int dividePoint = getDividePoint(arr,start,end);
        if(start<dividePoint-1){
            quickSort(arr,start,dividePoint-1);
        }
        if (end > dividePoint) {
            quickSort(arr, dividePoint, end);
        }
    }

    private static int getDividePoint(int[] arr, int start, int end) {
        int Pivot = arr[(start+end)/2];
        while (start <= end) {
            while (arr[start] < Pivot) {
                start++;
            }
            while (arr[end] > Pivot) {
                end--;
            }
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] array, int start, int end) {
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }

}
