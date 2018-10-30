import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;

public class display extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display frame = new display("200");
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
	public display(String Movie_id) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 841, 604);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String MovieTitle = null;
		String Director = null;
		String ReleaseDate = null;
		String Language = null;
		String Cast = null;
		String Rating = null;
		
		
		try
		{  //Connection//
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
			String q="Select m.Movie_title,m.Movie_language,m.Movie_year,d.Director_name from movies m,director d where Movie_id=? AND m.Director_id=d.Director_ID";
			
			
			//Getting movie id to display info about the movie//
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, Integer.parseInt(Movie_id));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				//MovieTitle//
				MovieTitle=rs.getString(1);
				System.out.println(MovieTitle);
				
				Language=rs.getString(2);
				System.out.println(Language);
				
				ReleaseDate=rs.getString(3);
				System.out.println(ReleaseDate);
				
				Director=rs.getString(4);
				System.out.println(Director);
				
				//Rating=rs.getString(5);
				//System.out.println(Rating);
				
			}
			
			String q2="Select Review_stars from movies m,rating r where m.Movie_id=? && m.Movie_id=r.Movie_id";
			PreparedStatement ps2=con.prepareStatement(q2);
			ps2.setInt(1, Integer.parseInt(Movie_id));
			ResultSet rs2=ps2.executeQuery();
			System.out.println("here");
			while(rs2.next()) 
			{
				System.out.println("here");
				Rating=rs2.getString(1)+ "/10";
				System.out.println(Rating);
			}
		}
		catch(Exception e) {
			
		}
		
		//LABEL//
		JLabel lblMovieReleaseDate = new JLabel("Movie Release Date:");
		lblMovieReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieReleaseDate.setBounds(12, 314, 167, 27);
		contentPane.add(lblMovieReleaseDate);
		
		JLabel lblMovieLanguage = new JLabel("Language:");
		lblMovieLanguage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieLanguage.setBounds(12, 354, 90, 27);
		contentPane.add(lblMovieLanguage);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDirector.setBounds(12, 272, 107, 29);
		contentPane.add(lblDirector);
		
		JLabel lblCast = new JLabel("Cast:");
		lblCast.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCast.setBounds(12, 394, 56, 28);
		contentPane.add(lblCast);
		
		JLabel lblMovieId = new JLabel("Movie ID:");
		lblMovieId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieId.setBounds(539, 13, 90, 27);
		contentPane.add(lblMovieId);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setBounds(12, 232, 56, 27);
		contentPane.add(lblTitle);
		
		
		
		JLabel title_lbl = new JLabel(MovieTitle);
		title_lbl.setFont(new Font("Papyrus", Font.BOLD, 18));
		title_lbl.setBounds(67, 232, 263, 27);
		contentPane.add(title_lbl);
		
		JLabel dir_lbl = new JLabel(Director);
		dir_lbl.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		dir_lbl.setBounds(96, 272, 186, 29);
		contentPane.add(dir_lbl);
		
		JLabel releasedate_lbl = new JLabel(ReleaseDate);
		releasedate_lbl.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		releasedate_lbl.setBounds(182, 314, 100, 27);
		contentPane.add(releasedate_lbl);
		
		JLabel language_lbl = new JLabel(Language);
		language_lbl.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
		language_lbl.setBounds(96, 354, 76, 27);
		contentPane.add(language_lbl);
		
		JLabel cast_lbl = new JLabel(Cast);
		cast_lbl.setBounds(96, 396, 56, 16);
		contentPane.add(cast_lbl);
		
		JLabel movieid_lbl = new JLabel(Movie_id);
		movieid_lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
		movieid_lbl.setBounds(622, 13, 84, 27);
		contentPane.add(movieid_lbl);
		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRating.setBounds(479, 314, 71, 27);
		contentPane.add(lblRating);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sanjay Bhakta\\Desktop\\movie\\imdbl.png"));
		lblNewLabel.setBounds(589, 314, 40, 27);
		contentPane.add(lblNewLabel);
		
		JLabel rating_lbl = new JLabel(Rating);
		rating_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rating_lbl.setBounds(550, 314, 40, 23);
		contentPane.add(rating_lbl);
	}
}