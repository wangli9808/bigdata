package cn.tedu.test;

import org.junit.Test;

import java.util.Arrays;

public class SortDemo {
    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSortTest() {
        int[] arr = {1, 4, 9, 7, 8, 6, 5, 3, 2};
        //外层--循环轮数
        for (int i = 1; i < arr.length; i++) {
            //设置一个标记，如果循环后标记为true，则表示此次循环没有进行交换，也就是待排序的已经有序，循环结束
            Boolean flag = true;
            int tmp = 0;
            //内层--参与比较的元素范围
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     */
    @Test
    public void selectSort() {
        int[] arr = {1, 4, 9, 7, 8, 6, 5, 3, 2};
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
