package com.zxj.qs;

import java.util.Stack;

/**
 * Created by qs on 2018/3/21.
 */
public class Singleton {
    private volatile static Singleton instance = new Singleton();

    private static Singleton getInstance() {
        return instance;
    }
    private Singleton() {

    }

    private static Singleton getInstance1() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    enum Single{
        INSTANCE;
        String namespace;
        private String getS() {
            return namespace;
        }
        private Single(){

        }
    }

    public static void main(String[] args) {
        System.out.println(Single.INSTANCE.getS());
        System.out.println(compute(new String[]{"4", "13", "5", "/", "+"}));
    }

    public static int compute(String[] tokens) {
        Stack<String> s = new Stack<String>();
        int value = 0;
        for (int i =0; i< tokens.length; i++) {
            String s1 = tokens[i];
            if (s1.equals("*")) {
                int i1 = Integer.valueOf(s.pop());
                int i2 = Integer.valueOf(s.pop());
                s.push(String.valueOf(i1*i2));
            } else if (s1.equals("+")) {
                int i1 = Integer.valueOf(s.pop());
                int i2 = Integer.valueOf(s.pop());
                s.push(String.valueOf(i1+i2));
            } else if (s1.equals("-")) {
                int i1 = Integer.valueOf(s.pop());
                int i2 = Integer.valueOf(s.pop());
                s.push(String.valueOf(i2-i1));
            } else if (s1.equals("/")) {
                int i1 = Integer.valueOf(s.pop());
                int i2 = Integer.valueOf(s.pop());
                s.push(String.valueOf(i2/i1));
            } else {
                s.push(tokens[i]);
            }
        }
        return Integer.valueOf(s.pop());
    }
}
