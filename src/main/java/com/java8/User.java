package com.java8;

public class User {
    private final int age;
    private String str;





    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    public User(int m){
        this.age=m;
    }

    @Override
    public String toString() {
        return Integer.toString(age) ;
    }
}
