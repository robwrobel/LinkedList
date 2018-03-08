package robert;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    Node head;
    Node tail;
    int size;

    class Node {
        Node prev;
        Node next;
        T element;
    }

    public void add(T element) {
        addLast(element);
    }

    public void addLast(T element) {
        if (head==null) {
            addFirstElement(element);
        } else {
            addTail(element);
        }
    }

    public void addFirst(T element) {
        if (head == null) {
            addFirstElement(element);
        } else {
            addHead(element);
        }
    }

    public void add(int index, T element) {
        if (index < 0 || index>size) throw new IndexOutOfBoundsException();

        if (head == null) {
            addFirstElement(element);
            return;
        }

        Node node = head;

        for (int i = 0; i < index; i++ ) {
            node = node.next;
        }

        if (node == null) {
            addTail(element);
        } else {
            addBeforeNode(node, element);
        }
    }

    public T getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.element;
    }

    public T getLast() {
        if (tail == null) throw new NoSuchElementException();
        return tail.element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node node = head;
        for (int i = 0; i < index;i++) {
            node = node.next;
        }
        return node.element;
    }

    public int size() {
        return size;
    }

    private void addHead(T element) {
        Node node = new Node();
        head.prev = node;
        node.next = head;
        node.element = element;
        head = node;
        size++;
    }

    private void addTail(T element) {
        Node node = new Node();
        tail.next = node;
        node.prev = tail;
        tail = node;
        node.element = element;
        size++;
    }

    private void addFirstElement(T element) {
        Node node = new Node();
        node.element = element;
        head = node;
        tail = node;
        size++;
    }

    private void addBeforeNode(Node node, T element) {
        if (node == head) {
            addHead(element);
        } else {
            insertBetween(node.prev, node, element);
        }
    }

    private void insertBetween(Node prevNode, Node nextNode, T element) {
        Node node = new Node();
        prevNode.next = node;
        nextNode.prev = node;
        node.prev = prevNode;
        node.next = nextNode;
        node.element = element;
        size++;
    }
}
