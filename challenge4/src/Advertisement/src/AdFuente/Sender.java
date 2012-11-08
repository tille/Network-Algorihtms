package AdFuente;

/**
 *
 * @author Usuario
 */

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.exolab.jms.administration.AdminConnectionFactory;
import org.exolab.jms.administration.JmsAdminServerIfc;
import javax.jms.JMSException;
import javax.jms.Destination;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.swing.JOptionPane;

public class Sender {

    JOptionPane aviso = new JOptionPane();

    Context context = null;
    ConnectionFactory factory;
    Connection connection = null;
    String factoryName = "ConnectionFactory";
    Session session = null;
    MessageProducer sender = null;
    Destination destination = null;
    JmsAdminServerIfc admin;

    public boolean Connect(String url) {
        boolean isConnect = false;
        try {
            Hashtable properties = new Hashtable();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
            properties.put(Context.PROVIDER_URL, "tcp://" + url + "/");
           
      

            context = new InitialContext(properties);

            //creo el administrador
            String host = "tcp://" + url + "/";
            admin = AdminConnectionFactory.create(host);

            factory = (ConnectionFactory) context.lookup(factoryName);

            connection = factory.createConnection();

            session = connection.createSession(
            false, Session.AUTO_ACKNOWLEDGE);

            connection.start();

            System.out.println("Connection Sucessful");
            isConnect = true;

        } catch (Exception ex) {
            ex.printStackTrace();
            isConnect = false;
        }
        return isConnect;
    }

    public void createChannel(String channelName) {

        String queue = channelName;
        Boolean isQueue = Boolean.TRUE;
        try {
            admin.addDestination(queue, isQueue);
            System.out.println("Queue was successful create");
            JOptionPane.showMessageDialog(aviso,"El canal se creo exitosamente");
        } catch (Exception ex) {
            System.out.println("Failed to create queue " + queue);
        }
    }

    public void removeChannel(String channelName) {
        String dest = channelName;
        try {
            if(destinationExists(dest)){
            admin.removeDestination(dest);
            System.out.println("Channel was successful remove");
            JOptionPane.showMessageDialog(aviso,dest + " eliminado exitosamente");
            }else{
            JOptionPane.showMessageDialog(aviso,"El elemento no existe");
            } 
        } catch (JMSException ex) {
            System.out.println("Failed to remove destination " + destination);
        }
    }

    public boolean sendMessage(String mensaje, String destino) {
        boolean wasSent = false;
        try {
            // look up the Destination
            destination = (Destination) context.lookup(destino);

            //if (destinationExists(destino)) {
            sender = session.createProducer(destination);
            //}
            //connection.start();            

            TextMessage message = session.createTextMessage();
            message.setText(mensaje);
            sender.send(message);
            System.out.println("Sent: " + message.getText());
            wasSent = true;
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("The message sent was failure");
            wasSent = false;
        }
        return wasSent;
    }

    public void createTopic(String Topicname) {

        String topic = Topicname;
        Boolean isQueue = Boolean.FALSE;
        try {
            admin.addDestination(topic, isQueue);
            System.out.println("The Topic was successful create");
            JOptionPane.showMessageDialog(aviso,"El topico fue creado exitosamente");
        } catch (JMSException ex) {
            ex.printStackTrace();
            System.err.println("Failed to create topic " + topic);
        }
    }

    public boolean destinationExists(String destination) {
        boolean exists = false;
        try {
            if (admin.destinationExists(destination)) {
                exists = true;
            } else {
                exists = false;
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
        return exists;
    }

    public String getChannels() {
        String channels = "";
        try {
            Vector destinations = admin.getAllDestinations();
            Iterator iterator = destinations.iterator();
            while (iterator.hasNext()) {
                Destination dest = (Destination) iterator.next();

                if (dest instanceof Queue) {
                    //channels += "Cola:\n";
                    Queue queue = (Queue) dest;
                    channels += queue.getQueueName() + "\n";
                }
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
        return channels;
    }

    public String getTopics() {
        String topics = "";
        try {
            Vector destinations = admin.getAllDestinations();

            Iterator iterator = destinations.iterator();
            while (iterator.hasNext()) {
                Destination dest = (Destination) iterator.next();

                if (dest instanceof Topic) {
                    Topic topic = (Topic)dest;
                    topics += topic.getTopicName() + "\n";
                }
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
        return topics;
    }
}