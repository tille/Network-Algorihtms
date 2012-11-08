package AdCliente;

/**
 *
 * @authores Usuario
 */

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.jms.Destination;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;
import javax.swing.JOptionPane;
import org.exolab.jms.administration.AdminConnectionFactory;
import org.exolab.jms.administration.JmsAdminServerIfc;

public class Receiver {

    JOptionPane aviso = new JOptionPane();
    Context context = null;
    ConnectionFactory factory = null;
    Connection connection = null;
    String factoryName = "ConnectionFactory";
    Destination dest = null;
    int count = 1;
    Session session = null;
    MessageConsumer receiver = null;
    JmsAdminServerIfc admin;
    Topic topic = null;
    TopicSubscriber subscriber = null;
    //String subscriptionName = "Client";

    public boolean Connect(String url) {
        boolean isConnect = false;
        try {
            Hashtable properties = new Hashtable();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
            properties.put(Context.PROVIDER_URL, "tcp://" + url + "/");

            context = new InitialContext(properties); // create the JNDI initial context

            //creo el administrador
            String host = "tcp://" + url + "/";
            admin = AdminConnectionFactory.create(host);

            // look up the ConnectionFactory
            factory = (ConnectionFactory) context.lookup(factoryName);

            // create the connection
            connection = factory.createConnection();

            // create the session
            session = connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);

            // start the connection, to enable message receipt
            connection.start();

            System.out.println("Connection Sucessful");
            isConnect = true;

        } catch (Exception ex) {
            System.out.println("Connection Failed");
        }
        return isConnect;
    }

    public String readChannel(String destSource) {
        String message = "";
        try {
            // look up the Destination
            dest = (Destination) context.lookup(destSource);
            // create the receiver
            receiver = session.createConsumer(dest);
            //connection.start();
            Message mensaje = receiver.receiveNoWait();

            if (mensaje instanceof TextMessage) {
                TextMessage text = (TextMessage) mensaje;
                message = text.getText() + "\n";
            } else {
                System.out.println("No Message in Channel");
                JOptionPane.showMessageDialog(aviso,"No hay mensajes en el Canal");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return message;
    }

    public void SubscribeTopic(String topicName, String name) {

        try {
            topic = (Topic) context.lookup(topicName);
            subscriber = session.createDurableSubscriber(
                    topic, name);
           
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("El topico no existe");
            JOptionPane.showMessageDialog(aviso,"El topico no existe");
        }
    }

    public String readTopic() {
        String mensaje = "";
        Message message;
        try {
                message = subscriber.receive();
                if (message instanceof TextMessage) {
                    TextMessage text = (TextMessage) message;
                    mensaje += text.getText() + "\n";
                    System.out.println("el topico fue " + mensaje);
                }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }
}