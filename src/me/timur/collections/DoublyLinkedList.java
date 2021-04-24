package me.timur.collections;

import java.util.Iterator;

/**
 * Created by Timur on 19.03.2021
 */

public class DoublyLinkedList <T> implements Iterable<T>{

    private int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;

    private class Node <T> {
        T data;
        Node <T> prev, next;
        public Node(T data, Node <T> prev, Node <T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        @Override public String toString() { return data.toString(); }
    }

    public void clear() {
        Node <T> trav = head;
        while (trav != null) {
            Node <T> next = trav.next;
            trav.prev = trav.next = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size() == 0; }

    public void add(T elem) { addLast(elem); }

    public void addFirst(T elem) {
        if (isEmpty())
            head = tail = new Node<T>(elem, null, null);
        else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addLast(T elem) {
        if (isEmpty())
            head = tail = new Node<T>(elem, null, null);
        else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");

        T data = head.data;

        head = head.next;
        --size;

        if (isEmpty()) tail = null;
        else head.prev = null;

        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");

        T data = tail.data;

        tail = tail.prev;
        --size;

        if (isEmpty()) head = null;
        else tail.next = null;

        return data;
    }

    private T remove(Node<T> node) {

        T data = null;

        if (isEmpty()) throw new RuntimeException("Empty list");

        if (node == head) return removeFirst();
        if (node == tail) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        data = node.data;

        node.data = null;
        node = node.prev = node.next = null;

        --size;

        return data;
    }

    @Override
    public Iterator<T> iterator() { return null; }
}
