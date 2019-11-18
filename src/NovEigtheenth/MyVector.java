package NovEigtheenth;

import java.util.*;
import java.util.function.UnaryOperator;

import static java.util.Comparator.naturalOrder;

/**
 * Created by seungmin.yun on 11/18/2019
 * Student ID: 010820132
 */

public class MyVector<E> implements List<E> {
    int capacity = 0;
    Object[] data = null;
    int size = 0;

    public MyVector(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid " + capacity);
        }

        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyVector() {
        this(10);
    }

    public boolean add(E o) {
        ensureCapacity(size + 1);
        data[size++] = o;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        Object[] tmp = new Object[size];
        System.arraycopy(data, 0, tmp, 0, size);
        return tmp;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                remove(i);
            }
        }

        return true;
    }

    // Insertion sort
    @Override
    public void sort(Comparator<? super E> c) {
        Comparator spr = Comparator.naturalOrder();
        for (int i = 0; i < size; i++) {
            int minIndex = i;
           while(spr.compare(data[i], data[minIndex - 1]) > 0 && minIndex > 0) {
               swap(minIndex, minIndex-1, data);
               minIndex--;
           }
        }
    }

    void swap(int a, int b, Object[] obj) {
        Object tmp = obj[a];
        obj[a] = obj[b];
        obj[b] = tmp;
    }

    void ensureCapacity(int minCapacity) {
        if (minCapacity - data.length > 0)
            throw new IllegalArgumentException("Invalid " + minCapacity);
        setCapacity(minCapacity);
    }

    void setCapacity(int capacity) {
        if (capacity == this.capacity) return;
        Object[] tmp = new Object[capacity];
        System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
    }

    public E remove(int index) {
        E tmp = null;
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("invalid " + index);
        tmp = (E) data[index];
        if (index != size - 1) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }
        data[size - 1] = null;
        size--;
        return tmp;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }


    public E get(int index) {
        if (index < 0 || index >=size)
            throw new IllegalArgumentException("Invalid "+ index);

        return (E) data[index];
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >=size)
            throw new IllegalArgumentException("Invalid "+ index);

        return data[index] = element;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index >=size)
            throw new IllegalArgumentException("Invalid "+ index);

        data[index] = element;
    }

//    public Object remove(int index) {
//        return null;
//    }

    @Override
    public int indexOf(Object o) {
        int i;
        for( i = 0; i<size; i++) {
            if(o.equals(data[i])) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return size-1;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        List tmp = new LinkedList();
        System.arraycopy(data, fromIndex, tmp, fromIndex, toIndex);
        return tmp;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object d : c) {
            d = null;
        }
        size = 0;
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        int i=0;
        for(Object d: c) {
            if(d.equals(data[i++]) && i < size) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] tmp = new Object[size];
        System.arraycopy(data, 0, tmp, 0, size);
        return tmp;
    }

    //==========================================================================
    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }


    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

}
