package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Mundo.MailSender;

import javax.mail.internet.*;

public class VentanaMensaje extends JFrame implements ActionListener{
    
	private JPanel contentPane;
	private JTextField jTextFieldRemitente;
	private JLabel jLabelPara;
	private JLabel jLabelAsunto;
	private JScrollPane jScrollPane1;
	private JLabel jLabelMensaje;
	private JTextArea jTextAreaMessage;
	private JButton jButtonCancelar;
	private JButton jButtonEnviar;
	private JButton jButtonLimpiar;
	private JPanel panelSuperior;
	private JTextField jTextFieldAsunto;
	private JPanel panelMedio;
	private JPanel panelInferior;
	
	
	 
	public VentanaMensaje() {
		setBounds(100, 100, 525, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		construyePanelSuperior();
		construyePanelMedio();
		construyePanelInferior();
		getContentPane().add(panelSuperior);
		getContentPane().add(panelMedio);
		getContentPane().add(panelInferior);
	}

	public void construyePanelSuperior() {
		
		panelSuperior = new JPanel();
		jTextFieldRemitente = new JTextField();
        jTextFieldAsunto = new JTextField();
        jLabelPara = new JLabel();
        jLabelAsunto = new JLabel();
        jLabelMensaje = new JLabel();
        
        jTextFieldRemitente.setFont(new Font("Century Gothic", 0, 12));
        jTextFieldAsunto.setFont(new Font("Century Gothic", 0, 12)); 

        jLabelPara.setFont(new Font("Century Gothic", 1, 12)); 
        jLabelPara.setText("Para");

        jLabelAsunto.setFont(new Font("Century Gothic", 1, 12)); 
        jLabelAsunto.setText("Asunto");

        jLabelMensaje.setFont(new Font("Century Gothic", 1, 12)); 
        jLabelMensaje.setText("Mensaje");
        
        panelSuperior.setLayout(new GridLayout(3, 2));
        panelSuperior.add(jLabelPara);
        panelSuperior.add(jTextFieldRemitente);
        panelSuperior.add(jLabelAsunto);
        panelSuperior.add(jTextFieldAsunto);
        panelSuperior.add(jLabelMensaje);
        
	}
	
	public void construyePanelMedio() {
		panelMedio = new JPanel();
		jTextAreaMessage = new JTextArea();
		jTextAreaMessage.setTabSize(10);
		jTextAreaMessage.setColumns(30);
        jTextAreaMessage.setFont(new Font("Century Gothic", 0, 13));
        jTextAreaMessage.setRows(10);
        panelMedio.setLayout(new GridLayout(1, 1));
        panelMedio.add(jTextAreaMessage);
	}
	public void construyePanelInferior() {
		panelInferior = new JPanel();
		jButtonEnviar = new JButton();
		jButtonCancelar = new JButton();
	    jButtonLimpiar = new JButton();
		panelMedio.setLayout(new GridLayout(3, 1));
		
		jButtonEnviar.setFont(new Font("Century Gothic", 1, 14)); 
        jButtonEnviar.setText("Enviar");
		jButtonEnviar.addActionListener(this);
        
		jButtonCancelar.setFont(new Font("Century Gothic", 1, 14)); 
	    jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(this);
     
        jButtonLimpiar.setFont(new Font("Century Gothic", 1, 14)); // NOI18N
        jButtonLimpiar.setText("Limpiar Campos");
        jButtonLimpiar.addActionListener(this);
        
        panelInferior.add(jButtonEnviar);
        panelInferior.add(jButtonCancelar);
        panelInferior.add(jButtonLimpiar);
        
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 MailSender.mensaje = jTextAreaMessage.getText();
	     MailSender.remitente= jTextFieldRemitente.getText();
	     MailSender.asunto = jTextFieldAsunto.getText();
	        
		if(arg0.getSource() == jButtonEnviar)
		{
			MailSender.SendMail();
	    }
		
		if(arg0.getSource() == jButtonCancelar)
		{
			System.exit(0);
		}
		
		if(arg0.getSource() == jButtonLimpiar)
		{
			jTextFieldRemitente.setText("");
	        jTextFieldAsunto.setText("");
	        jTextAreaMessage.setText("");
		}
		
	}

}
