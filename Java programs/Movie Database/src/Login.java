import java.awt.BorderLayout;
import java.awt.EventQueue;
 import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Login extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try {
					Login frame = new Login();
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
	public Login() 
	{
		
		
		//Database Connection//
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");  
			System.out.println("Connection established");
			//here movie is database name, root is username and password  //
			
			//Statement Execution//
			Statement stmt = con.createStatement( ); 
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select Movie_title from movies where Movie_language='Hindi'");  
			while(rs.next())    
			System.out.println(rs.getString(1)); //+""+rs.getString(2)+"  "+rs.getString(3)//
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
		
		
		
			  
		setBackground(Color.GREEN);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sanjay Bhakta\\Desktop\\movie\\objects-17-512.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//Title Movie Database//
		JLabel lblMovieDatabase = new JLabel("MOVIE DATABASE");
		lblMovieDatabase.setFont(new Font("Segoe UI Semilight", Font.BOLD, 28));
		lblMovieDatabase.setForeground(new Color(65, 105, 225));
		lblMovieDatabase.setBounds(179, 13, 293, 61);
		contentPane.add(lblMovieDatabase);
		
		//Label Search//
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearch.setBounds(23, 94, 86, 36);
		contentPane.add(lblSearch);
		
		textField = new JTextField();
		textField.setBounds(121, 97, 419, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//Search button//
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Sanjay Bhakta\\Desktop\\movie\\sear.png"));
		btnNewButton.setBounds(571, 97, 39, 36);
		contentPane.add(btnNewButton);
		
		//Venom//
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Sanjay Bhakta\\Desktop\\movie\\venom.png"));
		btnNewButton_1.setBounds(37, 226, 176, 270);
		contentPane.add(btnNewButton_1);
		
		//Text Movies Playing Now//
		JLabel lblMoviesPlayingNow = new JLabel("Movies Playing Now");
		lblMoviesPlayingNow.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoviesPlayingNow.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 18));
		lblMoviesPlayingNow.setBounds(277, 175, 224, 24);
		contentPane.add(lblMoviesPlayingNow);
		
		//Villain//
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Sanjay Bhakta\\Desktop\\movie\\vill.png"));
		btnNewButton_2.setBounds(277, 226, 176, 270);
		contentPane.add(btnNewButton_2);
		
		//FirstMan//
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Sanjay Bhakta\\Desktop\\movie\\first.png"));
		btnNewButton_3.setBounds(499, 226, 176, 270);
		contentPane.add(btnNewButton_3);
		
		
		
		//Add a movie Button//
		JButton btnAddAMovie = new JButton("Add a Movie");
		btnAddAMovie.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Add a=new Add();
				a.setVisible(true);
				
			}
		});
		btnAddAMovie.setBounds(654, 103, 122, 24);
		contentPane.add(btnAddAMovie);
		
		
	}
}
