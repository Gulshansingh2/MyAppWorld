package SourceGetter.src;

import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SourceGetter extends JFrame implements ActionListener{  
    JTextField tf;  
    JTextArea ta;  
    JButton b;  
    JLabel l;  
    Container c = null;
    SourceGetter(){  
        super("Source Getter Tool");  
        c = getContentPane();
		//c.setBackground(Color.lightGray);
		ImageIcon ikn = new ImageIcon("BG.jpg");
		JLabel lblBG = new JLabel(ikn);
		lblBG.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lblBG);
		
		Font myFont = new Font("Aerial",Font.PLAIN,17);
		Font sCodeFont = new Font("Aerial",Font.PLAIN,14);
		
        l=new JLabel("Enter Website URL:");  
        l.setBounds(50,50,250,20);  
        l.setFont(myFont);
          
        tf=new JTextField("https://www..com/");  
        tf.setBounds(50,100,250,30);
        tf.setFont(myFont);
          
        b=new JButton("Get Source Code");  
        b.setBounds(50, 150,180,30);  
        b.addActionListener(this);  
        b.setFont(myFont);  
        
        ta=new JTextArea();  
        JScrollPane sp=new JScrollPane(ta);
        sp.setBounds(50,220,580,400);  
        ta.setFont(sCodeFont);
          
        lblBG.add(l);lblBG.add(tf);lblBG.add(b);lblBG.add(sp); 
        
        setSize(700,700);  
        setLayout(null);  
        setVisible(true);  
    }  
    public void actionPerformed(ActionEvent e){  
        String s=tf.getText();  
        if(s==null){}  
        else{  
            try{  
            URL u=new URL(s);  
            URLConnection uc=u.openConnection();  
          
            InputStream is=uc.getInputStream();  
            int i;  
            StringBuilder sb=new StringBuilder();  
            while((i=is.read())!=-1){  
                sb.append((char)i);  
            }  
            String source=sb.toString();  
            ta.setText(source);  
            }catch(Exception ex){JOptionPane.showMessageDialog(this,"Exception: "+ex);}  
        }  
    }  
    
}  