package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Mundo.MailSender;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelSuperior;
	private JLabel lblEmail;
	private JLabel lblContrase�a;
	private TextField textFieldEmail;
	private TextField textFieldContrase�a;
	private JPanel panelMedio;
	private JLabel lblLogin;
	private JPanel panelInferior;
	private JButton botonIniciarSesion;
	private JPasswordField jPasswordFielPassword;

	

	/**
	 * Create the frame.
	 */
	public Login() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1));
		construyePanelSuperior();
		construyePanelMedio();
		construyePanelInferior();
		getContentPane().add(panelSuperior);
		getContentPane().add(panelMedio);
		getContentPane().add(panelInferior);

		setLocationRelativeTo(null);
	}

	public void construyePanelSuperior() {
		panelSuperior = new JPanel();
		lblLogin = new JLabel("Pesta�a para iniciar sesi�n");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panelSuperior.setLayout(new GridLayout(1, 1));
		panelSuperior.add(lblLogin);

	}

	public void construyePanelMedio() {

		panelMedio = new JPanel();
		lblEmail = new JLabel("Email: ");
		lblContrase�a = new JLabel("Contrase�a: ");
		textFieldEmail = new TextField();
		jPasswordFielPassword = new JPasswordField();
		panelMedio.setLayout(new GridLayout(2, 2));
		panelMedio.add(lblEmail);
		panelMedio.add(textFieldEmail);
		panelMedio.add(lblContrase�a);
		panelMedio.add(jPasswordFielPassword);
	}

	public void construyePanelInferior() {
		panelInferior = new JPanel();
		panelInferior.setLayout(new GridLayout(1, 1));
		botonIniciarSesion = new JButton("Iniciar sesi�n");
		botonIniciarSesion.addActionListener(this);
		panelInferior.add(botonIniciarSesion);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		VentanaMensaje miV = new VentanaMensaje();
		MailSender.usuario = textFieldEmail.getText();
		MailSender.contrase�a = new String(jPasswordFielPassword.getPassword());
		miV.setVisible(true);
		this.dispose();
	}

}
