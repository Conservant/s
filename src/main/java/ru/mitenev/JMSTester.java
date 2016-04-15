package ru.mitenev;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JMSTester {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("jms-listener-app-context.xml");


        ctx.refresh();

        while (true) {
        }
    }

}
