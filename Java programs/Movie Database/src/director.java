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
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 649, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddADirector = new JLabel("Add a Director");
		lblAddADirector.setForeground(new Color(255, 20, 147));
		lblAddADirector.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAddADirector.setBounds(63, 35, 219, 29);
		contentPane.add(lblAddADirector);
		
		JLabel lblNewLabel = new JLabel("DIRECTOR ID:");
		lblNewLabel.setForeground(new Color(0, 255, 127));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(35, 143, 133, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DIRECTOR NAME:");
		lblNewLabel_1.setForeground(new Color(0, 255, 127));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(35, 188, 145, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DIRECTOR PH.NO");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(30, 251, 150, 32);
		contentPane.add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBounds(202, 137, 70, 22);
		contentPane.add(id);
		id.setColumns(10);
		
		dirname = new JTextField();
		dirname.setBounds(202, 198, 150, 22);
		contentPane.add(dirname);
		dirname.setColumns(10);
		
		dirphone = new JTextField();
		dirphone.setBounds(205, 258, 116, 22);
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
		btnNewButton.setBounds(184, 341, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("X:\\College Projects\\DBMS-Java Project\\movie\\dd.jpg"));
		lblNewLabel_3.setBounds(0, 0, 631, 508);
		contentPane.add(lblNewLabel_3);
	}
}
