package dataStructure;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 8, 9};
        int i = binarySearch(arr, 8);
        int j = binarySearch1(arr, 8, 0, 6);
        System.out.println(i + "," + j);
    }

    /**
     * 折半查找
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 折半查找递归实现
     */
    public static int binarySearch1(int[] arr, int key, int low, int high) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                return binarySearch1(arr, key, low, mid - 1);
            } else {
                return binarySearch1(arr, key, mid + 1, high);
            }
        }
        return -1;
    }
}
