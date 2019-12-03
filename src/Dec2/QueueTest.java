package Dec2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Raphael Yun on 12/2/2019
 */

public class QueueTest<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 3;
    private int count = 0;
    private E[] array;
    private int last = 0;
    private int first = 0;

    QueueTest(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("hi");
        array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public QueueTest() {
        this(5);
    }

    @Override
    public void enqueue(E el) {
        if (count == array.length)
            ensureCapacity(array.length << 1);
        array[last++] = el;
        if (last == array.length)
            last = 0;
        count++;
    }

    @Override
    public E dequeue() {
        E e = array[first];
        array[first] = null;
        first++;
        count--;
        if (first == array.length)
            first = 0;
        if (count > 0 && count == array.length>>2)
            ensureCapacity(array.length >> 1);
        return e;
    }

    private void ensureCapacity(int capacity) {
        E[] elements = (E[]) new Object[capacity];
        for (int i=0; i<count; i++)
            elements[i] = array[(first + i) % array.length];
        // 0    1    2  3  4  5
        // {5, null, 1, 2, 3, 4}
        //first = 2, last  = 0
        //i=0 => 2:1
        //i=1 => 3:2
        //i=2 => 4:3
        //i=3 => 5:0
        //i=4 => 2+4%6 0:5

        array = elements;
        first = 0;
        last = count;
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
        return null;
    }

    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5};
        QueueTest queueTest = new QueueTest();
        for (int i : temp) {
            queueTest.enqueue(i);
        }

//        queueTest.dequeue();
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
    }
}
