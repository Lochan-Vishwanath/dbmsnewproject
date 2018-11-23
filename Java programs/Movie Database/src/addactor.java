import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class addactor extends JFrame {

	private JPanel contentPane;
	private JTextField actorid;
	private JTextField actorname;
	private JTextField gender;

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
					addactor frame = new addactor();
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
	public addactor() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("X:\\College Projects\\DBMS-Java Project\\movie\\objects-17-512.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 740, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddAnActor = new JLabel("Add an Actor");
		lblAddAnActor.setForeground(new Color(0, 0, 0));
		lblAddAnActor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAnActor.setFont(new Font("Caladea", Font.BOLD, 32));
		lblAddAnActor.setBounds(246, 13, 220, 38);
		contentPane.add(lblAddAnActor);
		
		JLabel lblNewLabel_1 = new JLabel("Actor ID");
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel_1.setBounds(12, 108, 115, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Actor Name");
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(12, 184, 138, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setForeground(Color.PINK);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel_3.setBounds(12, 260, 115, 31);
		contentPane.add(lblNewLabel_3);
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");  
					
					String b="INSERT INTO actor values(?,?,?)";
					
					String aid=actorid.getText();
					String aname=actorname.getText();
					String agender=gender.getText();
					
					PreparedStatement pstatement;
					pstatement=con.prepareStatement(b);
					pstatement.setInt(1, Integer.parseInt(aid));
					pstatement.setString(2, aname);
					pstatement.setString(3, agender);
					
					pstatement.executeUpdate();
					JOptionPane.showMessageDialog(contentPane, "Successfully Added Actor's Data.. ");
				}
				catch(Exception e1)
				{ 
					JOptionPane.showMessageDialog(contentPane, "Invalid Actor ID");
					
					if(actorid.getText().trim().equals("")) 
					{
						JOptionPane.showMessageDialog(contentPane, "Actor's ID cant be *EMPTY*");
					}
					
					if(actorname.getText().trim().equals("")) 
					{
						JOptionPane.showMessageDialog(contentPane, "Actor's Name cant be *EMPTY*");
					}
					
					if(gender.getText().trim().equals("")) 
					{
						JOptionPane.showMessageDialog(contentPane, "Actor's Gender cant be *EMPTY*");
					}
				}
				
			}
		});
		btnNewButton.setBounds(208, 347, 97, 25);
		contentPane.add(btnNewButton);
		
		actorid = new JTextField();
		actorid.setBounds(178, 111, 200, 31);
		contentPane.add(actorid);
		actorid.setColumns(10);
		
		actorname = new JTextField();
		actorname.setBounds(178, 183, 200, 38);
		contentPane.add(actorname);
		actorname.setColumns(10);
		
		gender = new JTextField();
		gender.setBounds(178, 255, 200, 31);
		contentPane.add(gender);
		gender.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("w");
		lblNewLabel.setIcon(new ImageIcon("X:\\College Projects\\DBMS-Java Project\\movie\\Platon-Yurich-Header-2-1920x1712.jpg"));
		lblNewLabel.setBounds(0, 0, 722, 524);
		contentPane.add(lblNewLabel);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
