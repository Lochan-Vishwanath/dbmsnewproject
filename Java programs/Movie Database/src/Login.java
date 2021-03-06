import java.awt.EventQueue;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame 
{

	private JPanel contentPane;
	private JTextField search;

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
		try
		{  
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
			
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}
		
		
		
		
			  
		setBackground(Color.GREEN);
		setIconImage(Toolkit.getDefaultToolkit().getImage("X:\\College Projects\\DBMS-Java Project\\movie\\objects-17-512.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 921, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//Title Movie Database//
		JLabel lblMovieDatabase = new JLabel("CINEMA PORTAL");
		lblMovieDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieDatabase.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblMovieDatabase.setForeground(Color.MAGENTA);
		lblMovieDatabase.setBounds(267, 23, 361, 61);
		contentPane.add(lblMovieDatabase);
		
		//Label Search//
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setForeground(new Color(205, 92, 92));
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearch.setBounds(119, 94, 86, 36);
		contentPane.add(lblSearch);
		
		search = new JTextField();
		search.setBounds(217, 97, 419, 36);
		contentPane.add(search);
		search.setColumns(10);
		
		//Search button//
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");  
				System.out.println("Connection established");
				
				//here movie is database name, root is user,name and password  //
				
				//STATEMENT EXECUTION//
				String a="SELECT Movie_id,Movie_title FROM movies WHERE Movie_title like ?";
				PreparedStatement p;
				p=con.prepareStatement(a);
				
				//SEARCHING//
				String abc=search.getText();
				p.setString(1, "%"+abc+"%");
				
				//STORING SEARCH RESULTS//
				ResultSet rs=p.executeQuery();
				
				//PASSING RESULTSET TO SEARCHED CLASS//
				searched sobj=new searched(rs);
				sobj.setVisible(true);
				                
				
				}
				catch(Exception e) 
				{
					System.out.println(e.getMessage());
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("X:\\College Projects\\DBMS-Java Project\\movie\\sear.png"));
		btnNewButton.setBounds(648, 97, 39, 36);
		contentPane.add(btnNewButton);
		
		
		//Text Movies Playing Now//
				JLabel lblMoviesPlayingNow = new JLabel("Movies Playing Now");
				lblMoviesPlayingNow.setForeground(new Color(255, 255, 0));
				lblMoviesPlayingNow.setHorizontalAlignment(SwingConstants.CENTER);
				lblMoviesPlayingNow.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 18));
				lblMoviesPlayingNow.setBounds(352, 146, 224, 24);
				contentPane.add(lblMoviesPlayingNow);
		
		//Venom//
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				display dobj=new display("124");
				dobj.setVisible(true);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("X:\\College Projects\\DBMS-Java Project\\movie\\venom.png"));
		btnNewButton_1.setBounds(121, 175, 176, 270);
		contentPane.add(btnNewButton_1);
		
		
		
		//Villain//
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				display dobj=new display("1");
				dobj.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("X:\\College Projects\\DBMS-Java Project\\movie\\vill.png"));
		btnNewButton_2.setBounds(375, 175, 176, 270);
		contentPane.add(btnNewButton_2);
		
		//KGF//
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				display dobj=new display("9");
				dobj.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("X:\\College Projects\\DBMS-Java Project\\movie\\6.jpg"));
		btnNewButton_3.setBounds(625, 175, 168, 270);
		contentPane.add(btnNewButton_3);
		
		
		
		
		//Add a movie Button//
		JButton btnAddAMovie = new JButton("Login as admin");
		btnAddAMovie.setForeground(Color.BLUE);
		btnAddAMovie.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnAddAMovie.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Log l=new Log();
				l.setVisible(true);
				
			}
		});
		btnAddAMovie.setBounds(754, 23, 137, 27);
		contentPane.add(btnAddAMovie);
		
		
		
		//BACKGROUND IMAGE//
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("X:\\College Projects\\DBMS-Java Project\\movie\\ba1.jpg"));
		lblNewLabel.setBounds(0, 0, 903, 544);
		contentPane.add(lblNewLabel);
		
		
	}
}
