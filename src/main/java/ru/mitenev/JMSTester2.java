package ru.mitenev;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.mitenev.jms.sender.MessageSender;

public class JMSTester2 {
    public static void main(String[] args) throws InterruptedException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("jms-sender-app-context.xml");
        ctx.refresh();

        MessageSender ms = ctx.getBean("messageSender", MessageSender.class);

        ms.sendMessage("Bnnnssdkff");

        Thread.sleep(5000);

        ms.sendMessage("5 seconds afrtr");
    }
}
