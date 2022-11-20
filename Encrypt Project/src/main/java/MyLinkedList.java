public class MyLinkedList {

    Node header;

    static class Node {
        Object data;
        Node next = null;
    }

    MyLinkedList() {
        header = new Node();
    }

    void append(Object data) {
        Node end = new Node();
        end.data = data;

        Node n = header;

        while(n.next!=null) {
            n = n.next;
        }

        n.next = end;
    }

    void delete(Object data) {
        Node n = header;
        while(n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retreive() {
        Node n = header.next;
        while(n.next!=null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.append("키키");

        list.retreive();

        list.delete(2);

        list.retreive();

    }
}
