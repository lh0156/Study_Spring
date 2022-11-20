/*
* 1. static class로 Node를 선언한다.
*   1.1. Node의 필드 변수는 Object 자료형의 data와 next라는 Node 객체가 있다.
* 2. MyLinkedList의 필드 변수인 Node 객체의 header를 선언한다.
* 3. 생성자로 header를 인스턴스화 해준다.
* 4. append 메소드
*   4.1. 매개변수는 Object data이다.
*   4.2. Node 객체의 end라는 변수를 선언한다. 해당 객체의 data 프로퍼티에 파라미터 data를 할당한다.
*   4.3. Node n = header이다.
*   4.4. while문을 돌면서 n.next가 null이 아니라면 n=n.next처리를 해준다.
*   4.5. while문이 다 끝났으면 마지막 노드의 바로 앞 노드에 정지하므로 n.next = end로 값을 할당해준다.
* 5. delete 메소드
*   5.1. 매개변수는 Object data이다.
*   5.2. Node n = header.next로 할당해준다.
*       * header는 지워지면 안되는 기준값이기 때문이다.
*   5.3. while문을 돌면서 n.next != null로 끝까지 돌아준다.
*       5.3.1. while문 내에서 조건문을 분기해주고 만약 n.next.data가 data가 아니라면 n.next = n.next.next이다.
*       5.3.2. 아니라면 (else) n = n.next이다.
* 6. retrieve 메소드
*   6.1. 돌면서 뿌려준다.
*/
public class MyLinkedListPratice {

    Node header;

    static class Node {
        Object data;
        Node next = null;
    }

    MyLinkedListPratice() {
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

        MyLinkedListPratice temp = new MyLinkedListPratice();
        temp.append(1);
        temp.append(2);
        temp.append(3);
        temp.append(4);
        temp.delete(2);

        temp.retrieve();

    }
}
