package fanout;

import iot.consumer.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Consumer c = new Consumer("amqp://vbhlgvzz:ZtFq1IlSWaokjy7Yl_EhIMAYbbstFJsr@bee.rmq.cloudamqp.com/vbhlgvzz");
		c.consumeQueue("amplify-site-00");
	}

}