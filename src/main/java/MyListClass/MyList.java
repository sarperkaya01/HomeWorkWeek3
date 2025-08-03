package MyListClass;

import java.util.Arrays;

public class MyList<X> {
    private Object[] arr;
    private int size;
    private int capacity;

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public MyList() {
        this.capacity = 10;
        this.arr = new Object[capacity];
        this.size = 0;
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.arr = new Object[capacity];
        this.size = 0;
    }

    // copy constructor used by sublist
    private MyList(Object[] source, int from, int to) {
        int len = to - from + 1;
        this.capacity = len;
        this.arr = new Object[len];
        System.arraycopy(source, from, this.arr, 0, len);
        this.size = len;
    }

    public void add(X value) {
        ensureCapacity(size + 1);
        arr[size++] = value;
    }

    public X remove(int index) {
        checkIndex(index);
         
        X removed = (X) arr[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(arr, index + 1, arr, index, numMoved);
        }
        arr[--size] = null; // GC için
        return removed;
    }

    public boolean remove(X value) {
        int idx = indexOf(value);
        if (idx != -1) {
            remove(idx);
            return true;
        }
        return false;
    }

    public void set(int index, X value) {
        checkIndex(index);
        arr[index] = value;
    }

     
    public X get(int index) {
        checkIndex(index);
        return (X) arr[index];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > capacity) {
            int newCap = capacity * 2;
            if (newCap < minCapacity) newCap = minCapacity;
            Object[] newArr = new Object[newCap];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
            capacity = newCap;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

     
    public X[] toArray(Class<X> c) {
        X[] result = (X[]) java.lang.reflect.Array.newInstance(c, size);
        for (int i = 0; i < size; i++) {
            result[i] = (X) arr[i];
        }
        return result;
    }

    // Tip bilgisi olmadan generic dizi üretmeye çalışır (unchecked)
     
    public X[] toArray() {
        return (X[]) Arrays.copyOf(arr, size, arr.getClass()); // Object[]'i X[] gibi davranarak döner
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        // Referansları temizle
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    public int indexOf(X data) {
        for (int i = 0; i < size; i++) {
             
            X current = (X) arr[i];
            if ((data == null && current == null) || (data != null && data.equals(current))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(X data) {


        for (int i = size - 1; i >= 0; i--) {
             
            X current = (X) arr[i];
            if ((data == null && current == null) || (data != null && data.equals(current))) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(X data) {
        return indexOf(data) != -1;
    }

    public MyList<X> sublist(int start, int finish) {
        if (start < 0 || finish < start || finish >= size)
            throw new IndexOutOfBoundsException("Invalid sublist range: " + start + " to " + finish);
        return new MyList<>(arr, start, finish);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
             
            X elem = (X) arr[i];
            sb.append(elem);
            if (i != size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
