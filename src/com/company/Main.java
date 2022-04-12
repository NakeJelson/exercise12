package com.company;
//Jake Nelson 4-12-22 exercise12

class StackFullException extends Exception {}

class StackEmptyException extends Exception {}


class Queue<E> {
    private E[] elements;
    private int index = 0;
    private int size;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void enqueue(E element ) throws StackFullException {
        if (index >= size) {
            throw new StackFullException();
        }

        elements[index] = element;
        index++;
    }

    E dequeue () throws StackEmptyException {
        if (index == 0) {
            throw new StackEmptyException();
        }

        E returnElement = elements[index - size];
        index++;
        return returnElement;
    }
}


public class Main {
    public static void main(String[] args) {
        Queue<String> strings = new Queue<>(3);
        try {
            strings.enqueue("Hello");
            strings.enqueue("World");
            strings.enqueue("Mr.K");
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
        } catch (StackFullException | StackEmptyException e) {
            e.printStackTrace();
        }

    }
}