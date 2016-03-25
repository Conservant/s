package ru.mitenev;

import org.joda.time.LocalTime;

//@Controller
public class HelloWorldController {
    public static void main(String[] args) {
        LocalTime current = new LocalTime();
        System.out.println("The current time is: " + current);
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }
}
