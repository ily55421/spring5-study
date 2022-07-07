package com.allenddatmeny.chapter6;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Author: linKe
 * @Date: 2022/7/6 0:03
 * @FileName: JsoupDemo
 * @version: 1.0
 * @Description: TODO jsoup 示例
 */
public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        //
        Connection connect = Jsoup.connect(url);
        Document document = connect.get();

        Element elementById = document.getElementById("mw-content-text");
        Elements p = elementById.select("p");
        System.out.println(p);
    }
}
