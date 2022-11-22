package test.spring.scheduler.datastructure.linkedList;

/*
*   1. 노드 클래스를 생성한다.
*   2. 필드 변수로 int와 Node 객체를 하나씩 생성한다
*       2.1. int data;
*       2.2. Node next = null;
*   3. 생성자로 this.data = data를 할당해준다
*   4. append 메소드
*       4.1. 매개변수로 data를 받는다
*       4.2. Node 객체인 end를 생성해준다 (Node end = new Node(data))
*       4.3. Node 객체인 n을 this로 생성해준다.
*       4.4. while문을 돌면서 n객체의 next가 null인지 판정해준다.
*           4.1. null이 아니라면 n = n.next(다음 객체)로 이동한다.
*           4.2. while문에서 null인 값을 만나면 n은 해당 값이 된다
*           4.3. 마지막으로 해당 while문에 end를 할당해준다.
*   5. delete 메소드
*       5.1. n은 해당 객체(this)이다.
*       5.2. while문을 돌면서 n.next가 null인지 판별해준다
*           5.2.1. n.next.data가 파라미터 data인지 판별한다.
*           5.2.2. 파라미터 data라면 n.next = n.next.next가 된다.
*           5.2.3. 아니라면 n = n.next로 계속 돌아준다
*   6. retrive 메소드
*       6.1. n은 해당 객체(this)이다.
*       6.2. 다음 값이 null이 아닐 시 해당 값(n.data)를 찍어준 후 n = n.next로 이동한다
*       6.3. 후에 마지막 값을 한번 더 찍어준다.
*
* */

public class Node {

    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
    }

    void append(int data) {
        Node end = new Node(data);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data) {
        Node n = this;
        while(n.next!=null) {
            if(n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = this;
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    public static void main(String[] args) {

        Node node = new Node(20);

        node.append(2);
        node.append(2);
        node.append(2);
        node.append(2);
        node.append(4);
        node.append(5);
        node.append(8);

        node.delete(2);
        node.append(2);


        node.retrieve();

    }
}
