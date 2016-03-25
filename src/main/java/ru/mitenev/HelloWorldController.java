package ru.mitenev;

import org.joda.time.LocalTime;

//@Controller
public class HelloWorldController {
    public static void main(String[] args) {

//        LocalTime current = new
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }
}
