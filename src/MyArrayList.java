import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

public class MyArrayList<E> extends AbstractList<E> {
    private Object[] array;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        this.array = new Object[INITIAL_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.array = new Object[initialCapacity];
    }

    public MyArrayList(Collection<? extends E> collection) {
        this.array = collection.toArray();
        size = collection.size();
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) this.array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = (E) array[index];
        array[index] = element;
        return oldValue;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        array[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = (E) array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null;
        return oldValue;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - array.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity * 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }


    public static <T extends Comparable<? super T>> void bubbleSort(List<T> list) {
        boolean needNextPass = true;
        for (int k = 1; k < list.size() && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.size() - k; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    T temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    needNextPass = true;
                }
            }
        }
    }
}