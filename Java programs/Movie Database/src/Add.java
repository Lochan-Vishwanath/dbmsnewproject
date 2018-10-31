import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Add extends JFrame 
{

	private JPanel contentPane;
	private JTextField id;
	private JTextField title;
	private JTextField language;
	private JTextField reldate;
	private JTextField genre_txt;
	private JTextField runtime_txt;
	

	
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sanjay Bhakta\\Desktop\\movie\\objects-17-512.png"));
		
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 802, 613);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//DISPLAYS DIRECTOR COMBO BOX//
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(197, 333, 193, 29);
		contentPane.add(comboBox);
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
			String s="select Director_ID,Director_name from director order by Director_ID asc";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(s);
			while(rs.next())
	        {
				//DISPlaY DIRECTOR ID WITH NAME//
	            comboBox.addItem(rs.getString(1)+" ---> "+rs.getString(2));
	        }
		}
		catch(Exception e) {
			
		}
		
		String s=null;
		
		JLabel lblAddAMovie = new JLabel("Add a Movie");
		lblAddAMovie.setForeground(Color.ORANGE);
		lblAddAMovie.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddAMovie.setBounds(332, 25, 129, 40);
		contentPane.add(lblAddAMovie);
		
		
		JLabel lblMovieId = new JLabel("Movie ID :");
		lblMovieId.setForeground(new Color(255, 222, 173));
		lblMovieId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieId.setBounds(38, 92, 115, 29);
		contentPane.add(lblMovieId);
		
		
		JLabel lblMovieTite = new JLabel("Movie Title:");
		lblMovieTite.setForeground(new Color(255, 222, 173));
		lblMovieTite.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMovieTite.setBounds(38, 147, 115, 34);
		contentPane.add(lblMovieTite);
		
		JLabel lblLanguage = new JLabel("Language:");
		lblLanguage.setForeground(new Color(255, 222, 173));
		lblLanguage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLanguage.setBounds(38, 207, 103, 32);
		contentPane.add(lblLanguage);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		lblReleaseDate.setForeground(new Color(255, 222, 173));
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblReleaseDate.setBounds(38, 271, 149, 34);
		contentPane.add(lblReleaseDate);
		
		
		JLabel lblNewLabel = new JLabel("Director ID :");
		lblNewLabel.setForeground(new Color(255, 222, 173));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 329, 149, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGenre.setBackground(new Color(255, 228, 181));
		lblGenre.setForeground(new Color(255, 222, 173));
		lblGenre.setBounds(377, 98, 56, 16);
		contentPane.add(lblGenre);
		
		JLabel lblNewLabel_3 = new JLabel("RunTime:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(255, 222, 173));
		lblNewLabel_3.setBounds(377, 218, 86, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Add Poster:");
		lblNewLabel_4.setForeground(new Color(255, 222, 173));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(26, 390, 123, 16);
		contentPane.add(lblNewLabel_4);
		
		//ADDING A DIRECTOR//
		JButton btnNewButton = new JButton("Add a Director");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				director d=new director();
				d.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(415, 335, 129, 25);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel();
		label.setBounds(315, 406, 118, 147);
		contentPane.add(label);
		
		
		//BROWSE IMAGE BUTTON//
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		             //label.setIcon(ResizeImage(path));
		             ImageIcon MyImage = new ImageIcon(path);
		             Image img = MyImage.getImage();
		             Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
		             ImageIcon image = new ImageIcon(newImage);
		             label.setIcon(image);
		             //s = path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("No Data");
		         }
			}
		});
		btnBrowse.setBounds(161, 388, 97, 25);
		contentPane.add(btnBrowse);
		
		
		
		
		
		//DISPLAY UPLOADED IMAGE//
		
		
		
		
		
		
		
		
		
		
		
		
	
	
		
		id = new JTextField();
		id.setBounds(199, 96, 103, 24);
		contentPane.add(id);
		id.setColumns(10);
		
		title = new JTextField();
		title.setBounds(199, 156, 315, 22);
		contentPane.add(title);
		title.setColumns(10);
		
		language = new JTextField();
		language.setBounds(199, 215, 116, 22);
		contentPane.add(language);
		language.setColumns(10);
		
		reldate = new JTextField();
		reldate.setBounds(187, 280, 116, 22);
		contentPane.add(reldate);
		reldate.setColumns(10);
		
		genre_txt = new JTextField();
		genre_txt.setBounds(445, 97, 116, 22);
		contentPane.add(genre_txt);
		genre_txt.setColumns(10);
		
		runtime_txt = new JTextField();
		runtime_txt.setBounds(462, 215, 116, 22);
		contentPane.add(runtime_txt);
		runtime_txt.setColumns(10);
		
		
		
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
					String a="INSERT INTO movies values(?,?,?,?,?,?,?)";
					
					String movieid=id.getText();
					String movietitle=title.getText();
					String movieyear=reldate.getText();
					String lang=language.getText();
					String genre=genre_txt.getText();
					Time runtime=new Time(Long.parseLong(runtime_txt.getText()));
					
					InputStream is = new FileInputStream(new File(s));
					
					
						
					PreparedStatement pstatement;
					pstatement=con.prepareStatement(a);
					pstatement.setInt(1, Integer.parseInt(movieid));
					pstatement.setString(2, movietitle);
					pstatement.setString(3,movieyear);
					pstatement.setString(4, lang);
					pstatement.setInt(5,(int) comboBox.getSelectedItem());
					pstatement.setString(6, genre);
					pstatement.setTime(7, runtime);
					pstatement.setBlob(8,is);
					
					
					
					pstatement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Image uploaded successfully");
					JOptionPane.showMessageDialog(contentPane, "MOVIE ADDED SUCCESSFULLY");
					
					
					 
					}
				catch(Exception e)
					{
						
						if(id.getText().trim().equals("")) 
						{
							JOptionPane.showMessageDialog(contentPane, "Movie ID cant be *EMPTY*");
						}
						
						if(title.getText().trim().equals("")) 
						{
							JOptionPane.showMessageDialog(contentPane, "Movie Title cant be *EMPTY*");
						}
							
						if(language.getText().trim().equals(""))
						{
							JOptionPane.showMessageDialog(contentPane, "Movie Language cant be *EMPTY*");
						}
							
						if(reldate.getText().trim().equals("")) 
						{
							JOptionPane.showMessageDialog(contentPane, "Movie Year cant be *EMPTY*");
						}
						if(genre_txt.getText().trim().equals("")) 
						{
							JOptionPane.showMessageDialog(contentPane, "Movie Genre cant be *EMPTY*");
						}
						if(runtime_txt.getText().trim().equals("")) 
						{
							JOptionPane.showMessageDialog(contentPane, "Runtime cant be *EMPTY*");
						}
							
					}
			}
		});
		btnSubmit.setBounds(645, 528, 97, 25);
		contentPane.add(btnSubmit);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Format(YYYY-MM-DD)");
		lblNewLabel_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(315, 279, 172, 24);
		contentPane.add(lblNewLabel_1);
		
		
		
		//BACKGROUND DROP//
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Sanjay Bhakta\\Desktop\\movie\\ba2.jpg"));
		lblNewLabel_2.setBounds(0, 0, 784, 566);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		
		//Connection//
	
	}
}
