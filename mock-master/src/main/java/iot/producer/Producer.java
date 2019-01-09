package iot.producer;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import iot.application.Genre;

import java.io.IOException;

public class Producer {
    private String uri;
    private Channel channel;

    public Producer(String uri) {
        this.uri = uri;
    }

    public void connection(String queue) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(uri);

        //Recommended settings
        factory.setRequestedHeartbeat(30);
        factory.setConnectionTimeout(30000);

        Connection connection = factory.newConnection();
        channel = connection.createChannel();

        //queue name
        boolean durable = false;    //durable - RabbitMQ will never lose the queue if a crash occurs
        boolean exclusive = false;  //exclusive - if queue only will be used by one connection
        boolean autoDelete = false; //autodelete - queue is deleted when last consumer unsubscribes

        channel.queueDeclare(queue, durable, exclusive, autoDelete, null);
    }

    public void sendMessage(String message, String routingKey) throws IOException {
        String exchangeName = "";
        channel.basicPublish(exchangeName, routingKey, null, message.getBytes());
    }

    public void sendGenre(Genre genre, String routingKey) throws IOException {
        String exchangeName = "";
        channel.basicPublish(exchangeName, routingKey, null, new Gson().toJson(genre, Genre.class).getBytes());
    }

}
