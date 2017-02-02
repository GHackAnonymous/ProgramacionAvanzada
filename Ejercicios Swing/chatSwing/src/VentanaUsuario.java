import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaUsuario extends JFrame implements ActionListener {
	final int ANCHO = 400;
	final int ALTO = 600;
	Usuario usuario;
	int id;
	Chat chat;
	JTextField texto;
	
	public VentanaUsuario (int id,Usuario usuario,Chat chat){
		super ("Ventana Usuario: " + usuario.getNombre());
		this.chat = chat;
		this.id = id;
		this.usuario = usuario;
		this.setLocation(10+(ANCHO+10)*id,100);
		this.setSize(new Dimension (ANCHO,ALTO));
		this.setContentPane(crearPanelVentana());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private Container crearPanelVentana() {
		JPanel panel = new JPanel (new BorderLayout(0,10));
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel.add(crearPanelChat(),BorderLayout.CENTER);
		panel.add(crearPanelTexto(),BorderLayout.SOUTH);
		return panel;
	}
	private Component crearPanelChat() {
		JScrollPane panel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JList<Texto> lChat = new JList<>(chat);
		lChat.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
		AdaptadorUsuario adapter = new AdaptadorUsuario(usuario);
		lChat.setCellRenderer(adapter);
		panel.setViewportView(lChat);
		return panel;
	}
	private Component crearPanelTexto() {
		JPanel panel = new JPanel (new FlowLayout(10));
		texto = new JTextField (25);
		JButton boton = new JButton ("enviar");
		boton.addActionListener(this);
		panel.add(texto);
		panel.add(boton);
		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		chat.addElement(new Texto(usuario,texto.getText()));
		texto.setText("");
	}

}
