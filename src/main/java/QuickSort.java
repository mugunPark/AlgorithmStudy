/**
 * @author MKPARK
 */
public class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];

        while (low < high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }

            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        return low + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 23, 4, 6, 8, 213, 3, 5};
        QuickSort.sort(arr);
        System.err.println();
    }
}
