package com.seop.jwt.pratice;

public class LinkedList {

    Node header;

    static class Node {
        Object data;
        Node next = null;
    }

    LinkedList() {
        header = new Node();
    }


    public void append(Object data) {
        Node end = new Node();
        end.data = data;

        Node n = header;

        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(Object data) {
        Node n = header;
        while(n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve() {
        Node n = header.next;

        while(n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }

        System.out.println(n.data);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.append(1);
        ll.append(2);
        ll.append(3);

        ll.delete(2);

        ll.retrieve();

    }
}
