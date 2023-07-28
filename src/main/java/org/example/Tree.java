package org.example;

import java.util.List;

public class Tree {

    Node root;

    public boolean exist(int value) {
        Node node = find(root, value);
        
    }
    private Node find(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child: node.children) {
                Node result = find(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    public class Node {
        int value;
        List<Node> children;
    }
}
