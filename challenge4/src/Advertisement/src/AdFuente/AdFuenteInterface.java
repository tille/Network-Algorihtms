package AdFuente;
/**
 *
 * @author Usuario 
 */

public class AdFuenteInterface extends javax.swing.JFrame {

    Sender sender;

    public AdFuenteInterface(Sender sender) {
        this.sender = sender;
        initComponents();
        String channels = sender.getChannels();
        channelsTextArea.setText(channels);
        String topics = sender.getTopics();
        topicsTextArea.setText(topics);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCreate = new javax.swing.JPanel();
        deleteChannelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        channelTextField = new javax.swing.JTextField();
        createChannelButton = new javax.swing.JButton();
        TopicTextField = new javax.swing.JTextField();
        createTopicButton = new javax.swing.JButton();
        deleteTopicButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        channelsTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        topicsTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        advertisementTextArea = new javax.swing.JTextArea();
        publishButton = new javax.swing.JButton();
        destchannelTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Advertisement Sender");

        PanelCreate.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administracion de Canales", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP)));

        deleteChannelButton.setText("Eliminar Canal");
        deleteChannelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteChannelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Canal");

        createChannelButton.setText("Crear Canal");
        createChannelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createChannelButtonActionPerformed(evt);
            }
        });

        TopicTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopicTextFieldActionPerformed(evt);
            }
        });

        createTopicButton.setText("Crear Topico");
        createTopicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTopicButtonActionPerformed(evt);
            }
        });

        deleteTopicButton.setText("Eliminar Topico");
        deleteTopicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTopicButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Topico");

        channelsTextArea.setColumns(20);
        channelsTextArea.setRows(5);
        jScrollPane2.setViewportView(channelsTextArea);

        jLabel3.setText("Canales");

        topicsTextArea.setColumns(20);
        topicsTextArea.setRows(5);
        jScrollPane3.setViewportView(topicsTextArea);

        jLabel4.setText("Topicos");

        javax.swing.GroupLayout PanelCreateLayout = new javax.swing.GroupLayout(PanelCreate);
        PanelCreate.setLayout(PanelCreateLayout);
        PanelCreateLayout.setHorizontalGroup(
            PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreateLayout.createSequentialGroup()
                .addGroup(PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreateLayout.createSequentialGroup()
                        .addGroup(PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createTopicButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(TopicTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(createChannelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(channelTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteTopicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteChannelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreateLayout.createSequentialGroup()
                        .addGroup(PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );
        PanelCreateLayout.setVerticalGroup(
            PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreateLayout.createSequentialGroup()
                .addGroup(PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TopicTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createTopicButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(deleteTopicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(channelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(PanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(createChannelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteChannelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Creacion de Anuncios", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        advertisementTextArea.setColumns(20);
        advertisementTextArea.setRows(5);
        jScrollPane1.setViewportView(advertisementTextArea);

        publishButton.setText("Publicar en");
        publishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(publishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(destchannelTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destchannelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publishButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void publishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishButtonActionPerformed
        String mensaje = advertisementTextArea.getText();
        String destino = destchannelTextField.getText();
        boolean wasSent = sender.sendMessage(mensaje, destino);
        System.out.println("the sent was " + wasSent);
    }//GEN-LAST:event_publishButtonActionPerformed

    private void deleteChannelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteChannelButtonActionPerformed
        String Canal = channelTextField.getText();
        sender.removeChannel(Canal);
        String channels = sender.getChannels();
        channelsTextArea.setText(channels);
    }//GEN-LAST:event_deleteChannelButtonActionPerformed

    private void createChannelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createChannelButtonActionPerformed
        String Canal = channelTextField.getText();
        sender.createChannel(Canal);
        String channels = sender.getChannels();
        channelsTextArea.setText(channels);
    }//GEN-LAST:event_createChannelButtonActionPerformed

    private void TopicTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopicTextFieldActionPerformed
       
    }//GEN-LAST:event_TopicTextFieldActionPerformed

    private void createTopicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTopicButtonActionPerformed
        String topicname = TopicTextField.getText();
        sender.createTopic(topicname);
        String topics = sender.getTopics();
        topicsTextArea.setText(topics);
    }//GEN-LAST:event_createTopicButtonActionPerformed

    private void deleteTopicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTopicButtonActionPerformed
        String Canal = TopicTextField.getText();
        sender.removeChannel(Canal);
        String topics = sender.getTopics();
        topicsTextArea.setText(topics);
    }//GEN-LAST:event_deleteTopicButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCreate;
    private javax.swing.JTextField TopicTextField;
    private javax.swing.JTextArea advertisementTextArea;
    private javax.swing.JTextField channelTextField;
    private javax.swing.JTextArea channelsTextArea;
    private javax.swing.JButton createChannelButton;
    private javax.swing.JButton createTopicButton;
    private javax.swing.JButton deleteChannelButton;
    private javax.swing.JButton deleteTopicButton;
    private javax.swing.JTextField destchannelTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton publishButton;
    private javax.swing.JTextArea topicsTextArea;
    // End of variables declaration//GEN-END:variables
}