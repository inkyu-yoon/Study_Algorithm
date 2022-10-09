import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_11004_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.valueOf(input1[0]);
        int index = Integer.valueOf(input1[1]);


        int[] arr = new int[N];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < input2.length; i++) {
            arr[i] = Integer.valueOf(input2[i]);
        }
        quickSort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(arr[index-1]);

    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        int eachPivotPoint = getAfterSwapPivotPoint(array, start, end);
        if (start < eachPivotPoint - 1) {
            quickSort(array, start, eachPivotPoint - 1);
        }
        if (end > eachPivotPoint) {
            quickSort(array, eachPivotPoint, end);
        }
    }

    private static int getAfterSwapPivotPoint(int[] array, int start, int end) {
        int Pivot = array[(start + end) / 2];
        while (start <= end) {
            while (array[start] < Pivot) {
                start++;
            }
            while (array[end] > Pivot) {
                end--;
            }
            if (start <= end) {
                swap(array, start, end);
                start ++;
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
