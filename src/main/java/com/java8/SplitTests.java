package com.java8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SplitTests {

    @Test
    public void testSplit() {
String s = "2|apnic|20180408|55206|19830613|20180407|+1000";
String s1="\uFEFF   #";
String ss="\uFEFF   #";

String[] sub = s.split("\\|");
        System.out.println(s1.trim());
int u=s.indexOf("|");
        System.out.println(u);
assertEquals(7, sub.length);
    }
}
