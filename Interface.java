package Tarea2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
 
public class Interface implements Runnable
{
	private JFrame ventana;
	private  JScrollPane panelPrincipal;
	private Observadores obser;
 
   @Override
   public void run()
   {
   		// FRAME
	   
	   
	   
   		this.ventana = new JFrame("Fast Test Content");
   		ventana.setLayout(null);
   		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mainPanel.add(paneScroll); // Add the panescroll
        ventana.setBounds(0, 0, 800, 600);
        ventana.setVisible(true);
 
   	//	FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 0, 0);
   	//	ventana.setLayout(layout);
 
   		// PANEL
   		//JPanel panel = new JPanel(); // layout
   		//panel.setSize(new Dimension(700, 700));
   		//panel.setBackground(Color.BLUE);
   		//panel.setPreferredSize(new Dimension(700, 550));
   		//ventana.add(panel);
   		
   		JTextField textField = new JTextField();
        //textField.setColumns(50);
   		textField.setBounds(10, 20, 500, 30);
   		textField.setVisible(true);
        ventana.add(textField);
        
        	
   		ActionListener escuchador = new ActionListener()
   		{
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                JButton boton = (JButton) ae.getSource();
                String nombreBoton = boton.getText();
                switch (nombreBoton)
                {
                    case "Search":
                    	Word a = new Word();
                    	String userPhrase = textField.getText();
                    	a.setPhrase(userPhrase);
                    	
                    	putFrame();//lo agregue
					try {
						a.GetWords(userPhrase);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    	System.out.println(userPhrase);
                    	break;
                }
            }
   		};
         
   	    // BOTON
        JButton boton = new JButton("Search");
        boton.setSize(new Dimension(100, 50));
        boton.setLocation(650, 10);
        ventana.add(boton);
        boton.addActionListener(escuchador);
   	
         // SCROLL
         //JScrollPane scroll = new JScrollPane(panel);
         //panel.add(scroll);
        
     // PANEL
   		JPanel panel = new JPanel(); // layout
   		panel.setBounds(0, 0, 700, 700);
   		panel.setLayout(null);
   		panel.setVisible(true);
   		panel.setPreferredSize(new Dimension(700, 700));
        
        panelPrincipal = new JScrollPane(panel);
        panelPrincipal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelPrincipal.setVisible(true);
        panelPrincipal.setBounds(20,100,700,700);
        
   		ventana.add(panelPrincipal);

         // END
       // mainPanel.add(paneScroll);
        
   }
   
   public void putFrame()
   {
   	   JEditorPane paneEditor = new JEditorPane();
       Request n = new Request();
       //n.sendGet("https://www.facebook.com");//"https://www.google.com/");
       paneEditor.setContentType("text/html");
       paneEditor.setBounds(0, 10, 400, 400);
       paneEditor.setVisible(true);
       try {
			paneEditor.setText(n.getJackson("https://www.facebook.com"));
			System.out.println(n.getJackson("https://www.facebook.com"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       JScrollPane paneScroll = new JScrollPane(paneEditor);
       paneScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       paneScroll.setVisible(true);
       paneScroll.setBounds(20,100,400,400);
       
       JLabel labelName = new JLabel();
       labelName.setText("Juan");
       labelName.setBounds(10,0,50,50);
       
       JLabel labelTime = new JLabel();
       labelTime.setText("2000");
       labelTime.setBounds(50, 0, 50, 50);
       
       
       panelPrincipal.add(paneScroll);
   }
   
   
   
   
   
   public static void main(String[] args)
   { 
       EventQueue.invokeLater(new Interface());
   }
}