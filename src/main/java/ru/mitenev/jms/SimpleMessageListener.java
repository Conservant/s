package ru.mitenev.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SimpleMessageListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMessageListener.class);

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            LOGGER.info("Message received: " + textMessage.getText());
        } catch (JMSException e) {
            LOGGER.error("JMS error", e);
        }
    }
}
