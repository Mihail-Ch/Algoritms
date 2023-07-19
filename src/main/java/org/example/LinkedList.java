package org.example;

import java.util.Comparator;

public class LinkedList<T> {


    // Указатель на следующий элемент
    public Node head;

    // Узел (элемент)
    public class Node {

        // Указатель на следующий узел
        public Node next;

        // Значение узла
        public T value;
    }
        // Добавление нового элемента в начало связного списка

    public void addFirst(T value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }


    // Поиск элемента в связном списке по значнеию
    public Node contains(T value) {
        Node node = head;
        while (node != null) {
            if (node.value.equals(value))
                return node;
            node = node.next;
        }
        return null;
    }

    public void sort(Comparator<T> comporator) {
        Node node = head;
        while (node != null) {
            Node minValueNode = node;

            Node node2 = node.next;
            while (node2 != null) {

                if (comporator.compare(minValueNode.value, node2.value) > 0) {
                    minValueNode = node2;
                }
                node2 = node2.next;
            }

            if (minValueNode != node) {
                T buf = node.value;
                node.value = minValueNode.value;
                minValueNode.value = buf;
            }

            node = node.next;
        }
    }

    public void addLast(T value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
        }
        else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
    }

    public void removeLast(){
        if (head == null)
            return;

        Node node = head;
        while (node.next != null){
            if (node.next.next == null){
                node.next = null;
                return;
            }
            node = node.next;
        }

        head = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Node node = head;
        while (node != null) {
            stringBuilder.append(node.value);
            stringBuilder.append('\n');
            node = node.next;
        }
        return super.toString();
    }
}
