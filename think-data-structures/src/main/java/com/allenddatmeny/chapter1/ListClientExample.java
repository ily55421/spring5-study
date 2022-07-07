package com.allenddatmeny.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: linKe
 * @Date: 2022/7/3 17:59
 * @FileName: ListClientExample
 * @version: 1.0
 * @Description: TODO 第一章  测试基于接口编程
 */
public class ListClientExample<T> {
    private List<T> list;

    public ListClientExample(){
        list = new ArrayList<T>();
    }

    private List getList(){
        return list;
    }

    public static void main(String[] args) {
        ListClientExample<String> lce = new ListClientExample<>();
        List list1 = lce.getList();
        System.out.println(list1);
        // []
    }
}
