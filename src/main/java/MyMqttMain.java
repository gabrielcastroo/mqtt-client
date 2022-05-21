import auth.Credentials;
import com.hivemq.client.mqtt.MqttClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import entity.DataPackage;
import entity.Motorcycle;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.hivemq.client.mqtt.MqttGlobalPublishFilter.ALL;
import static java.nio.charset.StandardCharsets.UTF_8;

public class MyMqttMain {

    public static void main(String[] args) throws Exception {

        Motorcycle moto = new Motorcycle();
        String chassi = moto.getChassi();
        DataPackage motoDataPackage = moto.getDataPackage();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(motoDataPackage);

        final String host = Credentials.getHost();
        final String username = Credentials.getUserName();
        final String password = Credentials.getPassword();


        //create an MQTT client
        final Mqtt5BlockingClient client = MqttClient.builder()
                .useMqttVersion5()
                .serverHost(host)
                .serverPort(8883)
                .sslWithDefaultConfig()
                .buildBlocking();

        //connect to HiveMQ Cloud with TLS and username/pw
        client.connectWith()
                .simpleAuth()
                .username(username)
                .password(UTF_8.encode(password))
                .applySimpleAuth()
                .send();

        System.out.println("Connected successfully");

        //subscribe to the topic
        client.subscribeWith()
                .topicFilter("bike/telemetry/#")
                .send();

        //set a callback that is called when a message is received (using the async API style)
        client.toAsync().publishes(ALL, publish -> {
            System.out.println("Received message: " + publish.getTopic() + " -> " + UTF_8.decode(publish.getPayload().get()));

            //disconnect the client after a message was received
            //client.disconnect();
        });

        //publish a message to the topic "my/test/topic"
        client.publishWith()
                .topic("bike/telemetry/${chassi}")
                .payload(UTF_8.encode(json))
                .send();
    }
}