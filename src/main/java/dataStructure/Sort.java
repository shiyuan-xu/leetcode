package dataStructure;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {

    }

    /**
     * 冒泡排序
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        // 冒泡排序
        int size = a.length;
        int temp = 0;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 直接插入排序
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        // 直接插入排序
        int size = nums.length;
        int temp = 0;
        int j = 0;

        for (int i = 0; i < size; i++) {
            temp = nums[i];
            // 假如temp比前面的值小，则将前面的值后移
            for (j = i; j > 0 && temp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
    }

    /**
     * 简单选择排序
     *
     * @param a
     */
    public static void selectSort1(int[] a) {
        // 选择排序优化
        int size = a.length;
        int temp = 0;

        for (int i = 0; i < size - 1; i++) {
            int k = i;
            for (int j = k + 1; j < size; j++) {// 找出最小值的下标
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            if (i != k) {// 每次只交换一次
                temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
    }

    /**
     * 快排写法一
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] a, int low, int high) {
        //快速排序一；分化函数；获取随机数应该在的坐标，坐标左边都小于选取的数，坐标右边都大于选取的数
        int temp = a[low];

        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    public static void quickSort(int[] a, int low, int high) {
        //快速排序一；递归调用，分别对两边进行排序
        if (low < high) {
            int mid = partition(a, low, high);
            quickSort(a, low, mid - 1);
            quickSort(a, mid + 1, high);
        }
    }

    /**
     * 快排写法二
     *
     * @param a
     * @param low
     * @param high
     */
    public static void quicksort1(int[] a, int low, int high) {
        //快速排序二，合并写法
        int temp = a[low];
        int l = low;
        int h = high;

        while (l < h) {
            while (l < h && a[h] >= temp) {
                h--;
            }
            a[l] = a[h];
            while (l < h && a[l] <= temp) {
                l++;
            }
            a[h] = a[l];
        }
        a[l] = temp;

        //递归调用
        if (l > low) {
            quicksort1(a, low, l - 1);
        }
        if (h < high) {
            quicksort1(a, h + 1, high);
        }
    }

    /**
     * 归并排序
     *
     * @param nums
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] nums, int low, int mid, int high) {
        // 将（low-mid有序序列）和（mid-high有序序列）归并
        int[] temp = new int[high - low + 1];
        int i = low; // 左指针
        int j = mid + 1; // 右指针
        int k = 0;
        // 把较小的数先移到新数组
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // 把新数组覆盖nums
        for (int x = 0; x < temp.length; x++) {
            nums[x + low] = temp[x];
        }
    }

    public static void mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);// 左边有序
            mergeSort(nums, mid + 1, high);// 右边有序
            merge(nums, low, mid, high);// 左右归并
            System.out.println(low + " " + mid + " " + high);
            System.out.println(Arrays.toString(nums));
        }
    }

    /**
     * 堆排序
     *
     * @param data
     * @param lastIndex
     */
    public static void buildMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex节点的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                int childIndex = 2 * k + 1;    //k节点的左子节点
                if (childIndex < lastIndex) {    //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                    if (data[childIndex] < data[childIndex + 1]) {//若果右子节点的值较大
                        childIndex++;             //biggerIndex总是记录较大子节点的索引
                    }
                }
                if (data[k] < data[childIndex]) {//如果k节点的值小于其较大的子节点的值
                    //交换他们
                    data[k] = data[k] + data[childIndex];
                    data[childIndex] = data[k] - data[childIndex];
                    data[k] = data[k] - data[childIndex];
                    k = childIndex;        //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                } else {
                    break;
                }
            }
        }
    }

    public static void heapSort(int[] data) {
        // 堆排序
        //循环建堆
        for (int i = 0; i < data.length - 1; i++) {
            buildMaxHeap(data, data.length - 1 - i);
            //交换堆顶和最后一个元素
            int temp = data[0];
            data[0] = data[data.length - 1 - i];
            data[data.length - 1 - i] = temp;
            System.out.println(Arrays.toString(data));
        }
    }

    /**
     * 希尔排序
     *
     * @param a
     */
    public static void shellSort(int[] a) {
        // 希尔排序
        // r增量
        int size = a.length;
        int j = 0;
        int temp = 0;
        for (int r = size / 2; r > 0; r /= 2) {// 增量由大变小
            for (int i = r; i < size; i++) {
                temp = a[i];
                j = i - r;
                while (j >= 0 && temp < a[j]) {// 如果。交换位置
                    a[j + r] = a[j];
                    j -= r;
                }
                // for (j = i - increment; j >= 0; j -= increment) {
                // if (temp < a[j]) {
                // a[j + increment] = a[j];
                // } else {
                // break;
                // }
                // }
                a[j + r] = temp;
            }
        }
    }

    /**
     * 基数排序
     *
     * @param a
     * @param d
     */
    public static void radixSort(int[] a, int d) {
        int k = 0;
        int n = 1;
        int m = 1; // 控制键值排序依据在哪一位；位数对应的数：1、10、100
        int[][] temp = new int[10][a.length];// 数组的一维表示可能的余数0-9
        int[] order = new int[10];// order[i]表示该位是i的数的个数

        while (m <= d) {
            for (int i = 0; i < a.length; i++) {// 将每个数字放到相应的桶
                int lsd = (a[i] / n) % 10;
                temp[lsd][order[lsd]] = a[i];
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {// 将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
                if (order[i] != 0) {// 这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                    for (int j = 0; j < order[i]; j++) {
                        a[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;// 将桶里计数器置0，用于下一次位排序
            }
            n *= 10;
            k = 0;// 将k置0，用于下一轮保存位排序结果
            m++;
        }
    }
}
