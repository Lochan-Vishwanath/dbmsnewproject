import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class director extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField dirname;
	private JTextField dirphone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					director frame = new director();
					frame.setVisible(true);
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public director() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("X:\\College Projects\\DBMS-Java Project\\movie\\objects-17-512.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 578, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddADirector = new JLabel("Add a Director");
		lblAddADirector.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddADirector.setBounds(102, 35, 122, 29);
		contentPane.add(lblAddADirector);
		
		JLabel lblNewLabel = new JLabel("DIRECTOR ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 102, 133, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DIRECTOR NAME:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(30, 147, 145, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DIRECTOR PH.NO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(30, 199, 150, 32);
		contentPane.add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBounds(201, 109, 70, 22);
		contentPane.add(id);
		id.setColumns(10);
		
		dirname = new JTextField();
		dirname.setBounds(201, 157, 150, 22);
		contentPane.add(dirname);
		dirname.setColumns(10);
		
		dirphone = new JTextField();
		dirphone.setBounds(202, 206, 116, 22);
		contentPane.add(dirphone);
		dirphone.setColumns(10);
		
		//SUBMIT BUTTON//
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");  
					
					String b="INSERT INTO director values(?,?,?)";
					
					String dirid=id.getText();
					String name=dirname.getText();
					String phone=dirphone.getText();
					
					PreparedStatement pstatement;
					pstatement=con.prepareStatement(b);
					pstatement.setInt(1, Integer.parseInt(dirid));
					pstatement.setString(2, name);
					pstatement.setInt(3, Integer.parseInt(phone));
					
					pstatement.executeUpdate();
					JOptionPane.showMessageDialog(contentPane, "Successfully Added Data.. Please refresh!");
				}
				catch(Exception e)
				{ 
					JOptionPane.showMessageDialog(contentPane, "Invalid Director ID");
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setBounds(141, 274, 97, 25);
		contentPane.add(btnNewButton);
	}
}
