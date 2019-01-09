package iot.consumer;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import iot.application.Genre;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Consumer {

    private final ConnectionFactory factory;
    private Channel channel;

    public Consumer(String uri) {
        factory = new ConnectionFactory();
        try {
            factory.setUri(uri);
            factory.setRequestedHeartbeat(30);
            factory.setConnectionTimeout(30000);
            Connection connection = factory.newConnection();
            channel = connection.createChannel();
        } catch (URISyntaxException | NoSuchAlgorithmException | KeyManagementException | IOException e) {
            e.printStackTrace();
        }

    }

    public void consumeQueue(String queue) {

        QueueingConsumer consumer = new QueueingConsumer(channel);
        try {
            channel.basicConsume(queue, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            QueueingConsumer.Delivery delivery = null;
            try {
                delivery = consumer.nextDelivery();
                Genre message = new Gson().fromJson(new String(delivery.getBody()), Genre.class);
                System.out.println(" [x] Received '" + message.toString() + "'");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
