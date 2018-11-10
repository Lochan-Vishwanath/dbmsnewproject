import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("X:\\College Projects\\DBMS-Java Project\\movie\\objects-17-512.png"));
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
		String Cast1=null;
		String Cast2=null;
		String Role1=null;
		String Role2=null;
		
		JLabel poster_lbl = new JLabel();
		poster_lbl.setBounds(12, 13, 344, 531);
		contentPane.add(poster_lbl);
		
		
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
			
			//RATING//
			
			String q2="Select Review_stars from movies m,rating r where m.Movie_id=? && m.Movie_id=r.Movie_id";
			PreparedStatement ps2=con.prepareStatement(q2);
			ps2.setInt(1, Integer.parseInt(Movie_id));
			ResultSet rs2=ps2.executeQuery();
			
			while(rs2.next()) 
			{
				Rating=rs2.getString(1)+ "/10";
				System.out.println(Rating);
			}
			
			//POSTER//
			String q3="Select poster from movies where Movie_id=?";
			PreparedStatement ps3=con.prepareStatement(q3);
			ps3.setInt(1, Integer.parseInt(Movie_id));
			ResultSet rs3=ps3.executeQuery();
						
			while(rs3.next()) 
			{
				byte[] img = rs3.getBytes("poster");



                //Resize The ImageIcon
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(poster_lbl.getWidth(), poster_lbl.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                poster_lbl.setIcon(newImage);
			}
			//CAST//
			String q4="Select a.Actor_name,mc.Role from actor a,movie_cast mc where Movie_id=? && a.Actor_ID=mc.Actor_id";
			PreparedStatement ps4=con.prepareStatement(q4);
			ps4.setInt(1, Integer.parseInt(Movie_id));
			ResultSet rs4=ps4.executeQuery();
			rs4.absolute(1);
			Cast1=rs4.getString(1);
			Role1=rs4.getString(2);
			rs4.absolute(2);
			Cast2=rs4.getString(1);
			Role2=rs4.getString(2);
					
			
			/*while(rs4.next())
			{
				System.out.println(rs.getString(1));
				Cast1=rs.getString(1);
				Role1=rs.getString(2);
				Cast2=rs.getString(1);
				Role2=rs.getString(2);
				
			}*/
		}
		catch(Exception e) 
		{
			
		}
		
		//LABEL//
		JLabel lblMovieReleaseDate = new JLabel("Movie Release Date:");
		lblMovieReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieReleaseDate.setBounds(454, 223, 167, 27);
		contentPane.add(lblMovieReleaseDate);
		
		JLabel lblMovieLanguage = new JLabel("Language:");
		lblMovieLanguage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieLanguage.setBounds(454, 263, 90, 27);
		contentPane.add(lblMovieLanguage);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDirector.setBounds(454, 181, 107, 29);
		contentPane.add(lblDirector);
		
		JLabel lblCast = new JLabel("Cast:");
		lblCast.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCast.setBounds(565, 293, 56, 28);
		contentPane.add(lblCast);
		
		JLabel lblMovieId = new JLabel("Movie ID:");
		lblMovieId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMovieId.setBounds(509, 61, 90, 27);
		contentPane.add(lblMovieId);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setBounds(454, 141, 56, 27);
		contentPane.add(lblTitle);
		
		
		//DISPLAYING BASIC DETAILS OF THE MOVIE FROM THE DATABASE//
		JLabel title_lbl = new JLabel(MovieTitle);
		title_lbl.setFont(new Font("Papyrus", Font.BOLD, 18));
		title_lbl.setBounds(509, 141, 263, 27);
		contentPane.add(title_lbl);
		
		JLabel dir_lbl = new JLabel(Director);
		dir_lbl.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		dir_lbl.setBounds(538, 181, 186, 29);
		contentPane.add(dir_lbl);
		
		JLabel releasedate_lbl = new JLabel(ReleaseDate);
		releasedate_lbl.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		releasedate_lbl.setBounds(624, 223, 100, 27);
		contentPane.add(releasedate_lbl);
		
		JLabel language_lbl = new JLabel(Language);
		language_lbl.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
		language_lbl.setBounds(538, 263, 76, 27);
		contentPane.add(language_lbl);
		
		JLabel cast_lbl = new JLabel(Cast);
		cast_lbl.setBounds(538, 305, 56, 16);
		contentPane.add(cast_lbl);
		
		JLabel movieid_lbl = new JLabel(Movie_id);
		movieid_lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
		movieid_lbl.setBounds(591, 60, 84, 27);
		contentPane.add(movieid_lbl);
		
		//DISPLAYING RATING//
		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRating.setBounds(661, 517, 71, 27);
		contentPane.add(lblRating);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sanjay Bhakta\\Desktop\\movie\\imdbl.png"));
		lblNewLabel.setBounds(771, 517, 40, 27);
		contentPane.add(lblNewLabel);
		
		JLabel rating_lbl = new JLabel(Rating);
		rating_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rating_lbl.setBounds(732, 517, 40, 23);
		contentPane.add(rating_lbl);
		
		//DISPLAYING CAST//
		
		JLabel lblNewLabel_1 = new JLabel(Cast1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(454, 334, 120, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Cast2);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(454, 374, 103, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(Role1);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(614, 334, 197, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(Role2);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(611, 374, 149, 27);
		contentPane.add(lblNewLabel_4);
		
		
	}
}
