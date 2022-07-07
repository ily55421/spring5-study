package com.allenddatmeny.chapter2;

import java.util.*;

/**
 * @Author: linKe
 * @Date: 2022/7/3 18:16
 * @FileName: MyArrayList
 * @version: 1.0
 * @Description: TODO  第二章 复杂度计算 实现list的四个方法并完成测试   基于数组的列表
 */
public class MyArrayList<T> implements List<T> {
    /**
     * keeps track of the number of elements
     * 跟踪元素数量
     */
    int size;
    /**
     * stores the elements
     * 存放元素
     */
    private T[] array;

    /**
     *
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        // You can't instantiate an array of T[], but you can instantiate an
        // array of Object and then typecast it.  Details at
        // http://www.ibm.com/developerworks/java/library/j-jtp01255/index.html
        array = (T[]) new Object[10];
        size = 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // run a few simple tests
        MyArrayList<Integer> mal = new MyArrayList<Integer>();
        mal.add(1);
        mal.add(2);
        mal.add(3);
        System.out.println(Arrays.toString(mal.toArray()) + " size = " + mal.size);

        mal.remove(new Integer(2));
        System.out.println(Arrays.toString(mal.toArray()) + " size = " + mal.size);
    }

    /**
     * 元素添加
     * @param element element whose presence in this collection is to be ensured
     * @return
     */
    @Override
    public boolean add(T element) {
        // TODO: FILL THIS IN!
        if (size>=array.length) {
            // 定义一个更大的数组并将元素复制过来
            T[] bigger = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // add the element to get the resizing
        // 判断是否需要扩容  添加元素
        // 调用单参数的add添加元素以调整数组的大小
        add(element);

        // shift the elements
        for (int i=size-1; i>index; i--) {
            array[i] = array[i-1];
        }
        // put the new one in the right place
        array[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean flag = true;
        for (T element: collection) {
            flag &= add(element);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        // note: this version does not actually null out the references
        // in the array, so it might delay garbage collection.
        size = 0;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element: collection) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取元素
     * @param index index of the element to return
     * @return
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * 查找元素对应的下标索引
     * @param target element to search for
     * @return
     */
    @Override
    public int indexOf(Object target) {
        // TODO: FILL THIS IN!
        // 判断是否为null 判空
        if (target == null) {
            for (int i = 0; i < size; i++)
                if (array[i]==null)
                    return i;
            // 不为null 正常比较
        } else {
            for (int i = 0; i < size; i++)
                if (target.equals(array[i]))
                    return i;
        }

//        for (int i = 0; i < size; i++) {
//            if (array[i].equals(target)) {
//                return i;
//            }
//        }

        return -1;
    }

    /** Checks whether an element of the array is the target.
     *
     * Handles the special case that the target is null.
     *
     * @param target
     * @param element
     */
    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        // make a copy of the array
        T[] copy = Arrays.copyOf(array, size);
        // make a list and return an iterator
        return Arrays.asList(copy).iterator();
    }

    @Override
    public int lastIndexOf(Object target) {
        // see notes on indexOf
        for (int i = size-1; i>=0; i--) {
            if (equals(target, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        // make a copy of the array
        T[] copy = Arrays.copyOf(array, size);
        // make a list and return an iterator
        return Arrays.asList(copy).listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // make a copy of the array
        T[] copy = Arrays.copyOf(array, size);
        // make a list and return an iterator
        return Arrays.asList(copy).listIterator(index);
    }

    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public T remove(int index) {
        // TODO: FILL THIS IN!
        // 判断下标索引是否越界
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        T oldValue = get(index);

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        }
        array[--size] = null; // clear to let GC do its work

        return oldValue;

//        if (index + 1 <= size) {
//            for (int i = index+1; i <size ; i++) {
//                // Set 覆盖对应索引的值
//                array[index] = array[index+1];
//            }
//            // 最后一个赋值为null
//            array[size - 1] = null;
//            // 数量减一
//            size--;
//        }else {
//            array[index] = null;
//            // 数量减一
//            size--;
//        }
//
//        return  array[index];
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = true;
        for (Object obj: collection) {
            flag &= remove(obj);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    /**
     * set 值覆盖后 返回旧值
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return
     */
    @Override
    public T set(int index, T element) {
        // TODO: FILL THIS IN!
        // 判断下标索引是否越界
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T old = array[index];
        // Set 覆盖对应索引的值
        array[index] = element;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        T[] copy = Arrays.copyOfRange(array, fromIndex, toIndex);
        return Arrays.asList(copy);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <U> U[] toArray(U[] array) {
        throw new UnsupportedOperationException();
    }
}

