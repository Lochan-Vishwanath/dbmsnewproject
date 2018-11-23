import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Log extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Log() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("X:\\College Projects\\DBMS-Java Project\\movie\\objects-17-512.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 652, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel(" LOGIN PAGE");
		lblAdminLogin.setForeground(Color.RED);
		lblAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAdminLogin.setBounds(211, 13, 160, 47);
		contentPane.add(lblAdminLogin);
		
		JLabel lblNewLabel = new JLabel("Username/E-mail");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(112, 124, 149, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(112, 179, 106, 22);
		contentPane.add(lblNewLabel_1);
		
		uname = new JTextField();
		uname.setBounds(321, 124, 173, 22);
		contentPane.add(uname);
		uname.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String username=uname.getText();
				String password=pwd.getText();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
					
					String query="select * from adminlogin where username=? and password=?";
					
					
					PreparedStatement pst=con.prepareStatement(query);
					
					

					pst.setString(1, username);
					pst.setString(2, password);
					
					

					ResultSet rs=pst.executeQuery();
					
					
					try
					{
						if(rs.next())
						{
							Add a=new Add();
							JOptionPane.showMessageDialog(null,"Login Successful");
							a.setVisible(true);
							setVisible(false);

						}
						else
						{
							JOptionPane.showMessageDialog(null,"  Invalid username/password");
						}
					

					}
					catch(Exception e1)
					{
						System.out.println("cannot connect");
					}


				}



				catch(Exception e1)
				{
					System.out.println("cannot connect");
				}
			}
			
		});
		btnNewButton.setBounds(320, 232, 97, 25);
		contentPane.add(btnNewButton);
		
		pwd = new JPasswordField();
		pwd.setBounds(321, 181, 149, 22);
		contentPane.add(pwd);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("X:\\College Projects\\DBMS-Java Project\\movie\\login.jpg"));
		lblNewLabel_2.setBounds(0, 0, 682, 521);
		contentPane.add(lblNewLabel_2);
	}
}
