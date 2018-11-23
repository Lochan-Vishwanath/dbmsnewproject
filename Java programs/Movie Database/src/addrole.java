import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class addrole extends JFrame {

	private JPanel contentPane;
	private JTextField role2;

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
					addrole frame = new addrole();
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addrole() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("X:\\College Projects\\DBMS-Java Project\\movie\\objects-17-512.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 661, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//DISPLAYS Actor COMBO BOX//
				JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.setBounds(139, 133, 193, 29);
				contentPane.add(comboBox);
				
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
					String s="select Actor_ID,Actor_name from actor order by Actor_ID asc";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(s);
					while(rs.next())
			        {
						//DISPlaY Actor ID WITH NAME//
			            comboBox.addItem(rs.getString(1)+"---> "+rs.getString(2));
			        }
				}
				catch(Exception e) 
				{
					
				}
				
				
	//DISPLAYS Movie COMBO BOX//
				JComboBox<String> comboBox2 = new JComboBox<String>();
				comboBox2.setBounds(139, 204, 289, 29);
				contentPane.add(comboBox2);
				
				try
				{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
					String s1="select Movie_id,Movie_title from movies order by Movie_id asc";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(s1);
					while(rs.next())
			        {
						//DISPlaY Movie ID WITH NAME//
			            comboBox2.addItem(rs.getString(1)+"---> "+rs.getString(2));
			        }
				}
				catch(Exception e) 
				{
					
				}
		
		JLabel lblNewLabel = new JLabel("Add a Role for an Actor");
		lblNewLabel.setForeground(new Color(128, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(32, 28, 276, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Note: Please assign roles after adding the movie successfully.");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(32, 68, 358, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Actor ID:");
		lblNewLabel_2.setForeground(new Color(240, 128, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(32, 130, 80, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Movie ID:");
		lblNewLabel_3.setForeground(new Color(240, 128, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(32, 201, 94, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Role:");
		lblNewLabel_4.setForeground(new Color(240, 128, 128));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_4.setBounds(32, 266, 80, 22);
		contentPane.add(lblNewLabel_4);
		
		role2 = new JTextField();
		role2.setBounds(139, 267, 200, 25);
		contentPane.add(role2);
		role2.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//to select and store actor id//
				char x1[]=comboBox.getSelectedItem().toString().toCharArray();
				String z1="";
				for(char y : x1)
				{
					if(y=='-')
						break;
					z1+=y;	
				}
				System.out.println(z1);
				
				
				//to select and store movie id//
				char x2[]=comboBox2.getSelectedItem().toString().toCharArray();
				String z2="";
				for(char y : x2)
				{
					if(y=='-')
						break;
					z2+=y;	
				}
				System.out.println(z2);
				
				
				try
				{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");  
					System.out.println("Connection established");
					
					String role=role2.getText();
					
					String a="INSERT INTO movie_cast values(?,?,?)";
					
					PreparedStatement pstatement;
					pstatement=con.prepareStatement(a);
					
					pstatement.setInt(1,Integer.parseInt(z1));
					pstatement.setInt(2,Integer.parseInt(z2));
					pstatement.setString(3, role);
					
					pstatement.executeUpdate();
					JOptionPane.showMessageDialog(contentPane, "Actor's Role successfully saved!.. ");
					
				}
				catch(Exception e1)
				{
					if(role2.getText().trim().equals("")) 
					{
						JOptionPane.showMessageDialog(contentPane, "Actor's Role cant be *EMPTY*");
					}
				}
					
					
			}
		});
		btnNewButton.setBounds(183, 346, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("X:\\College Projects\\DBMS-Java Project\\movie\\joker.jpg"));
		lblNewLabel_5.setBounds(0, 0, 643, 532);
		contentPane.add(lblNewLabel_5);
	}

}
