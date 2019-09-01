package dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;

public class Stack {

    //数组实现ArrayList - stack
    public class MyArrayStack<E> {
        private ArrayList<E> list = new ArrayList<E>();

        public void push(E e) {
            list.add(e);
        }

        public E pop() {
            return list.remove(list.size() - 1);
        }

        public E peek() {
            return list.get(list.size() - 1);
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

    //链表实现栈linkedList - stack
    public class MyLinkedStack<E> {
        private LinkedList<E> list = new LinkedList<E>();

        public void push(E e) {
            list.addLast(e);
        }

        public E pop() {
            return list.removeLast();
        }

        public E peek() {
            return list.getLast();
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }
}
