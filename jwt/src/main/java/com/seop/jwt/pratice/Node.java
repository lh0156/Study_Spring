package com.seop.jwt.pratice;

public class Node {
    Object data;
    Node next = null;

    Node (Object data) {
        this.data = data;
    }

    void append(Object data) {
        Node end = new Node(data);
        Node n = this;

        while(n.next != null) {
            n = n.next;
        }

        n.next = end;

    }

    void delete(Object data) {
        Node n = this;

        while(n.next != null) {
            if (n.next.data != data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = this;

        while(n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }

        System.out.println(n.data);
    }

    public static void main(String[] args) {
        Node n = new Node(1);

        n.append(2);
        n.append(3);
        n.append(4);

        n.delete(3);

        n.retrieve();
    }
}
