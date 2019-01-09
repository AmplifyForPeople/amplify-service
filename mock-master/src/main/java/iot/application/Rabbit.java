package iot.application;

import iot.consumer.Consumer;
import iot.producer.Producer;

import java.io.IOException;

public class Rabbit {
    public static void main(String[] args) throws IOException, InterruptedException {
        String uri = "amqp://vbhlgvzz:ZtFq1IlSWaokjy7Yl_EhIMAYbbstFJsr@bee.rmq.cloudamqp.com/vbhlgvzz";
        Producer p = new Producer(uri);
        try {
            p.connection("amplify-site-00");
            Genre g = new Genre();
            g.id = 3;
            g.name = "hello sup";
            p.sendGenre(g, "amplify-site-00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Consumer c = new Consumer(uri);
        c.consumeQueue("amplify-site-00");
    }
}
