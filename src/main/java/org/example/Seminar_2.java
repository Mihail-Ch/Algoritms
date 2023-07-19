package org.example;

import java.util.Arrays;

public class Seminar_2 {
    public static void main(String[] args) {
        int[] array1 = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array1);
        SortUtils.directSort(array1);
        ArrayUtils.printArray(array1);

        array1 = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array1);
        SortUtils.qiuckSort(array1);
        ArrayUtils.printArray(array1);

        array1 = ArrayUtils.prepareArray(100000);
        long startTime = System.currentTimeMillis();
        SortUtils.directSort(array1.clone());
        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы сортирови выбором: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.qiuckSort(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы быстрой сортирови: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        Arrays.sort(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы системной сортирови: %d мс.\n", endTime - startTime);
    }


}
