/**
 * @author MKPARK
 */
public class MergeSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        sort(arr, low, mid);
        sort(arr, mid+1, high);
        merge(arr, low, mid,high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int l = low;
        int m = mid + 1;
        int p = low;

        int[] temp = new int[arr.length];

        while (l <= mid && m <= high) {
            if(arr[l] < arr[m]) {
                temp[p++] = arr[l++];
            } else {
                temp[p++] = arr[m++];
            }
        }

        while (l <= mid) {
            temp[p++] = arr[l++];
        }

        while (m <= high) {
            temp[p++] = arr[m++];
        }

        for (int i= low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,10,23,4,6, 8, 213,3,5};
        MergeSort.sort(arr);
        System.err.println();
    }
}
