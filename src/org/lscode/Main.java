package org.lscode;

public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("I need an argument, please.");
            return;
        }

        if (args.length > 1) {
            System.out.println("Just one is enough.");
            return;
        }

        Decoder decoder = new Decoder();

        String outStr2 = decoder.decode(args[0]);
        System.out.println(outStr2);

    }
}
