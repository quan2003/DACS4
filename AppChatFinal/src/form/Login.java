/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import javax.swing.JOptionPane;

import event.EventLogin;
import event.EventMessage;
import event.PublicEvent;
import io.socket.client.Ack;
import model.Model_Login;
import model.Model_Message;
import model.Model_Register;
import model.Model_User_Account;
import service.Service;

/**
 *
 * @author Admin
 */
public class Login extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        init();
    }
 
 
    private void init(){
        PublicEvent.getInstance().addEventLogin(new EventLogin() {
            @Override
            public void Login(Model_Login data) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                PublicEvent.getInstance().getEventMain().showLoading(true);
                   try {
                            Thread.sleep(2000); //  for test
                        } catch (InterruptedException e) {
                        }
                Service.getInstance().getClient().emit("login", data.toJsonObject(), new Ack(){
                             @Override
                             public void call(Object... os) { //nhận lại package khi hoàn thành send event login
                                 if (os.length > 0) {//nếu os tồn tại data
                                     boolean action = (boolean) os[0];
                                     if (action) { //nếu os[0] is action là true thực hiện show application
                                         Service.getInstance().setUser(new Model_User_Account(os[1]));
                                         PublicEvent.getInstance().getEventMenuRight().setImageAvatar(Service.getInstance().getUser());
                                         PublicEvent.getInstance().getEventMain().showLoading(false);
                                         PublicEvent.getInstance().getEventMain().initChat();
                                     }else{
                                         //trường hợp sai pass
                                         PublicEvent.getInstance().getEventMain().showLoading(false);
                                         JOptionPane.showMessageDialog(Slide,"Tên người dùng hoặc mật khẩu không chính xác","Thông báo", JOptionPane.ERROR_MESSAGE, null);
                                     }
                                 }
                                 }
                });
                }
            
             
            }).start();
            }

            @Override
            public void Register(Model_Register data, EventMessage message) {
                Service.getInstance().getClient().emit("register", data.toJSONObject(), new Ack(){
                    @Override
                    public void call(Object... os) {
                        if(os.length > 0){
                            Model_Message ms = new Model_Message((boolean) os[0], os[1].toString());                           
                            //gọi lại message khi hoàn thành register
                            if(ms.isAction()){
                               Model_User_Account user = new Model_User_Account(os[2]); 
                               Service.getInstance().setUser(user);
                            }
                            message.callMessage(ms);
                        }
                      }
                
                
                });
            }

            @Override
            public void goRegister() {
                Slide.show(1);
           }

            @Override
            public void goLogin() {
                Slide.show(0);
             }
        });
        P_Login login = new P_Login();
        Register register = new Register();
        Slide.init(login, register);
        Slide.setAnimate(25);
         
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Slide = new swing.PanelSlide();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout SlideLayout = new javax.swing.GroupLayout(Slide);
        Slide.setLayout(SlideLayout);
        SlideLayout.setHorizontalGroup(
            SlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
        );
        SlideLayout.setVerticalGroup(
            SlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.PanelSlide Slide;
    // End of variables declaration//GEN-END:variables
}