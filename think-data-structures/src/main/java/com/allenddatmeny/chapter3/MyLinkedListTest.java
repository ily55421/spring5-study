package com.allenddatmeny.chapter3;

import com.allenddatmeny.chapter2.MyArrayListTest;
import org.junit.Before;

import java.util.ArrayList;

/**
 * @Author: linKe
 * @Date: 2022/7/3 22:31
 * @FileName: MyLinkedListTest
 * @version: 1.0
 * @Description: TODO  继承 array的测试类  链表测试
 */
public class MyLinkedListTest extends MyArrayListTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        mylist = new MyLinkedList<Integer>();
        mylist.addAll(list);
    }
}

