package com.allenddatmeny.chapter8;

/**
 * @Author: linKe
 * @Date: 2022/7/6 23:34
 * @FileName: TermCounterTest
 * @version: 1.0
 * @Description: 描述
 */

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.allenddatmeny.chapter6.WikiFetcher;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;


public class TermCounterTest {

    private TermCounter counter;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        WikiFetcher wf = new WikiFetcher();
        Elements paragraphs = wf.readWikipedia(url);

        counter = new TermCounter(url.toString());
        counter.processElements(paragraphs);
    }

    @Test
    public void testSize() {
        assertThat(counter.size(), is(4798));
    }
}

