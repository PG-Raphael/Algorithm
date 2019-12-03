package Dec3;

import Dec2.Queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Raphael Yun on 12/3/2019
 */

public class QueueTest<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 3;
    E[] array = (E[]) new Object[DEFAULT_CAPACITY];
    private int last, first, count;

    @Override
    public void enqueue(E el) {
        if (size() == array.length)
            ensureCapacity(size() * 2);
        array[last++] = el;
        if (array.length == last)
            last = 0;
        count++;
    }

    private void ensureCapacity(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size(); i++) {
            temp[i] = array[(first + i) % array.length];
        }
        first = 0;
        last = size();
        array = temp;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        E temp = array[first];
        array[first] = null;
        first++;
        if (first == array.length)
            first = 0;
        count--;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private int i;

        @Override
        public boolean hasNext() {
            return i < size();
        }

        @Override
        public E next() {
            E e = array[(first+i) % array.length];
            i++;
            return e;
        }
    }

    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5};
        QueueTest<Integer> queueTest = new QueueTest<>();
        for (int i : temp) {
            queueTest.enqueue(i);
        }
        System.out.println(Arrays.toString(queueTest.array));
        System.out.println(queueTest.size());
        queueTest.dequeue();
        queueTest.enqueue(8);
        queueTest.dequeue();
        queueTest.enqueue(7);
        queueTest.enqueue(9);
        queueTest.enqueue(10);
        System.out.println(queueTest.size());
        System.out.println(Arrays.toString(queueTest.array));

        for (Integer e: queueTest)
            System.out.print(e + " ");

    }
}
