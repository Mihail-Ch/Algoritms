package org.example;

import java.util.ArrayList;

public class lection_2 {

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,6,7,8};
       // bubbleSort(array);
       // directSort(array);
       // insertSort(array);
       // System.out.print(find(array, 1));
       // System.out.print(binarySearch(array, 5, 0, array.length - 1));
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

    }

    //пирамидальный поиск
    public static void heapSort(int[] array) {
        //построение кучи, перегруппруем массив
        for (int i = array.length / 2 - 1; i >= 0 ; i--) {
            heapify(array, array.length, i);
        }
        //один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            //перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            //вызываем процедуру heapify на уменьшение в куче
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootindex) {
        int largest = rootindex; //инициализируем наибольший элемент как корень
        int leftChild = 2 * rootindex + 1; //левый
        int rightChild = 2 * rootindex + 2; //правый

        // Если левый дочерний элемент больше корня
        if (leftChild  < heapSize && array[leftChild] > array[rightChild]) {
            largest = rightChild;
        }

        // Если правый дочернний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        // Если самый большой элемнт не корень
        if (largest != rootindex) {
            int temp = array[rootindex];
            array[rootindex] = array[largest];
            array[largest] = temp;
            // Рекурсивно преобразуем в двоичню кучу, затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }

    //быстрый поиск
    public static void sort(int[] array, int startPos, int endPos) {
        int leftPos = startPos;
        int rightPos = endPos;
        int pivot = array[(startPos + endPos) / 2];
        do {
            while (array[leftPos] < pivot) {
                leftPos++;
            }
            while (array[rightPos] > pivot) {
                rightPos--;
            }
            if (leftPos <= rightPos) {
                if (leftPos < rightPos) {
                    int temp = array[leftPos];
                    array[leftPos] = array[rightPos];
                    array[rightPos] = temp;
                }
                leftPos++;
                rightPos--;
            }
        } while (leftPos <= rightPos);
        if (leftPos < endPos) {
            sort(array, leftPos, endPos);
        }
        if (startPos < rightPos) {
            sort(array, startPos, rightPos);
        }
    }

    //бинарный поиск
    public static int binarySearch(int[] array, int value, int min, int max) {
        int midpoint;
        if (max < min) {
            return  -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }

        if (array[midpoint] < value) {
            return binarySearch(array, value, midpoint+1, max);
        } else {
            if (array[midpoint] > value) {
                return binarySearch(array, value, min, midpoint - 1);
        } else {
                return midpoint;
            }
        }
    }

    //поиск
    public static int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //пузырьковая сортировка
    public static void bubbleSort(int[] array) {
            boolean finish;
            do {
                finish = true;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        finish = false;
                    }
                }
            } while (!finish);
    }

    //сортировка выбором
    public static void directSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int minPosition = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    //сортировка вставки
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}


