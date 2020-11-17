package itis.Tests;

import static itis.Tests.TestBase.generateRandomString;

public class Main {

    public static void main(String [] args) {

        String gen = generateRandomString(15);
        System.out.println(gen);
    }
}
