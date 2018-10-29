import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Add extends JFrame 
{

	private JPanel contentPane;
	private JTextField id;
	private JTextField title;
	private JTextField language;
	private JTextField reldate;
	private JTextField dirname;

	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try {
					Add frame = new Add();
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
	public Add() 
	
	{
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 802, 613);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblAddAMovie = new JLabel("Add a Movie");
		lblAddAMovie.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddAMovie.setBounds(332, 25, 129, 40);
		contentPane.add(lblAddAMovie);
		
		
		JLabel lblMovieId = new JLabel("Movie ID :");
		lblMovieId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieId.setBounds(51, 156, 115, 29);
		contentPane.add(lblMovieId);
		
		
		JLabel lblMovieTite = new JLabel("Movie Title:");
		lblMovieTite.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMovieTite.setBounds(51, 211, 115, 34);
		contentPane.add(lblMovieTite);
		
		JLabel lblLanguage = new JLabel("Language:");
		lblLanguage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLanguage.setBounds(51, 271, 103, 32);
		contentPane.add(lblLanguage);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblReleaseDate.setBounds(51, 335, 149, 34);
		contentPane.add(lblReleaseDate);
		
		
		JLabel lblNewLabel = new JLabel("Director ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(51, 393, 149, 24);
		contentPane.add(lblNewLabel);
		
		
		
		
		
	
	
		
		id = new JTextField();
		id.setBounds(212, 160, 103, 24);
		contentPane.add(id);
		id.setColumns(10);
		
		title = new JTextField();
		title.setBounds(212, 220, 315, 22);
		contentPane.add(title);
		title.setColumns(10);
		
		language = new JTextField();
		language.setBounds(212, 279, 116, 22);
		contentPane.add(language);
		language.setColumns(10);
		
		reldate = new JTextField();
		reldate.setBounds(212, 344, 116, 22);
		contentPane.add(reldate);
		reldate.setColumns(10);
		
		dirname = new JTextField();
		dirname.setBounds(212, 397, 103, 24);
		contentPane.add(dirname);
		dirname.setColumns(10);
		
		
		
		
		
		
		//Submit button//
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");  
					System.out.println("Connection established");
					
					//here movie is database name, root is username and password  //
					
					//Statement Execution//
					String a="INSERT INTO movies values(?,?,?,?,?)";
					
					String movieid=id.getText();
					String movietitle=title.getText();
					
					String movieyear=reldate.getText();
					
					String directorname=dirname.getText();
					String lang=language.getText();
					
					//Statement stmt = con.createStatement( );
					
					//ResultSet rs=((java.sql.Statement) stmt).executeQuery("INSERT INTO movies values(?,?,?,?,?)");
					
					PreparedStatement pstatement;
					pstatement=con.prepareStatement(a);
					pstatement.setInt(1, Integer.parseInt(movieid));
					pstatement.setString(2, movietitle);
					pstatement.setString(4, lang);
					
					pstatement.setString(3,movieyear);
					
					pstatement.setInt(5, Integer.parseInt(directorname));
					
					
					pstatement.executeUpdate();
					//while(rs.next())    
					//System.out.println(rs.getString(1)); //+""+rs.getString(2)+"  "+rs.getString(3)//
					
					 
					}catch(Exception e){ System.out.println(e);}
			}
		});
		btnSubmit.setBounds(318, 493, 97, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel_1 = new JLabel("Format(YYYY-MM-DD)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(340, 343, 172, 24);
		contentPane.add(lblNewLabel_1);
		
		
		
		//Connection//
	
	}
}