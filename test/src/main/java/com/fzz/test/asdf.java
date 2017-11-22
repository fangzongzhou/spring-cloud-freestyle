package com.fzz.test;

public class asdf {


    public static void main(String[] arg) {
        Qwer qwer = new Qwer();
        qwer.setName("xiao");
        qwer.setAge(12);
        System.out.println(qwer.toString());
        System.out.println(qwer.toString());
        System.out.println(qwer.toString());

        changePropertity(qwer);
    }

    public static void changePropertity(Qwer qwer) {
        qwer.setAge(12);
        qwer.setName("qqq");
    }
}
