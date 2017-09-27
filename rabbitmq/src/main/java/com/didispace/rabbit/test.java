package com.didispace.rabbit;

public class test {
    String asdf;

    public String getAsdf() {
        return asdf;
    }

    public void setAsdf(String asdf) {
        this.asdf = asdf;
    }

    public static void main(String[] args) {
        test qwer = new test();

        String vvv = "qwerasdf";
        System.out.println(vvv);
        qwer.zxcv(vvv);
        System.out.println(vvv);


    }

    public void zxcv(String qwe) {
        qwe = "asdfas";
        System.out.println("aaaa");
    }


}
