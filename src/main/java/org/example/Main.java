package org.example;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
     /*   AtomicInteger counter = new AtomicInteger();
       // System.out.print(sum(17, counter));
        counter.set(0);
      //  System.out.print(findSimpleNumbers(20, counter));


        System.out.print(counter);

        long startTime = System.currentTimeMillis();
       // System.out.print(fb1(43, counter));
        System.out.print("\n");
        long endTime = System.currentTimeMillis();
        System.out.printf("Кол-во итераций: %d\n", counter.get());
        System.out.printf("Операция выполнена за %d мс.", endTime - startTime);

        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.print(fb2(43, counter));
        endTime = System.currentTimeMillis();
        System.out.printf("Кол-во итераций: %d\n", counter.get());
        System.out.printf("Операция выполнена за %d мс.", endTime - startTime);
        */

        LinkedList<Employee> linkedList = new LinkedList<>();

        Employee searchEmployee = new Employee("Ivan", 64);

        linkedList.addFirst(new Employee("Ivan", 64));
        linkedList.addFirst(new Employee("Yra", 46));
        linkedList.addFirst(new Employee("Alex", 37));
        linkedList.addFirst(new Employee("Max", 22));
        linkedList.addFirst(new Employee("Bob", 24));
        linkedList.addFirst(new Employee("Mikle", 34));
        linkedList.addFirst(new Employee("Liza", 20));
        linkedList.addFirst(new Employee("Zlata", 22));

        System.out.println(linkedList);

        linkedList.sort(new EmployeeComporator(SortType.Ascending));
        System.out.println();
        System.out.println(linkedList);



        int[] myArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int size = myArray.length;
        for (int i = 0; i < size / 2; i++) {
            int temp = myArray[i];
            myArray[i] = myArray[size - 1 - i];
            myArray[size - 1 - i] = temp;
        }
        System.out.println("Array after reverse:: ");
        System.out.println(Arrays.toString(myArray));


        // Вот тут выдает ошибку, что не видит Node
       // LinkedList<Employee>.Node resNode = linkedList.contains(searchEmployee);

    }

    // Фибоначи
    static long fb1(int num, AtomicInteger counter) {
        // 0 1
        counter.getAndIncrement();
        if (num == 0 || num == 1) {
            return num;
        }
        return fb1(num - 1, counter) + fb1(num - 2, counter);
    }

    static long fb2(int num, AtomicInteger counter){
        if (num == 0  || num == 1)
            return num;
        long[] array = new long[num + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++){
            counter.getAndIncrement();
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[num];
    }



    // Написать алгоритм поиска простых чисел(деляться только на себя и на 1)
    public static ArrayList<Integer> findSimpleNumbers(int lastNamber, AtomicInteger counter) {
       ArrayList<Integer> arrayList = new ArrayList<>();
       boolean simple;
        for (int i = 1; i <= lastNamber ; i++) {
            simple = true;
            for (int j = 2; j < i; j++) {
                counter.getAndIncrement();
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    static void f(int n) {
        System.out.println(n);
        if (n >= 3) {
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }
    }

    public static int sum(int lastNumber, AtomicInteger c) {
        int sum = 0;
        for (int i = 1; i <= lastNumber ; i++) {
            c.getAndIncrement();
            sum += i;
        }
        return  sum;
    }
}