package iot.application;

import fanout.dto.Client;
import iot.consumer.Consumer;
import iot.producer.Producer;

import java.io.IOException;

public class Rabbit {

    private static String uri = "amqp://vbhlgvzz:ZtFq1IlSWaokjy7Yl_EhIMAYbbstFJsr@bee.rmq.cloudamqp.com/vbhlgvzz";;

    public Rabbit() {
        Consumer c = new Consumer(uri);
        c.consumeQueue("amplify-site-00");
    }

    public void sendClient(Client client) {
        Producer p = new Producer();
        try {
            p.connection("amplify-site-00");
            p.sendClient(client, "amplify-site-00");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
