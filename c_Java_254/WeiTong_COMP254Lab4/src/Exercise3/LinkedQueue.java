package Exercise3;
public class LinkedQueue<E> implements Queue<E> {
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E element = head.element;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return element;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.element;
    }

    // 实现 concatenate 方法
    public void concatenate(LinkedQueue<E> Q2) {
        if (Q2 == null || Q2.isEmpty()) {
            return; //Q2为空，不做任何操作
        }

        if (this.isEmpty()) { //如果当前队列为空
            this.head = Q2.head;
            this.tail = Q2.tail;
            this.size = Q2.size;
        } else {
            this.tail.next = Q2.head;
            this.tail = Q2.tail;
            this.size += Q2.size;
        }

        // clean Q2
        Q2.head = null;
        Q2.tail = null;
        Q2.size = 0;
    }

    // print Queue
    public void printQueue() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }
}