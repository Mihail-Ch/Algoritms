package org.example;

public class Lection_3 {
    Node head;
    Node tail;

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public class Node {
        int value;
        Node next;

    }
}
