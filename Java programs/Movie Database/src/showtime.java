import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.SystemColor;

public class showtime extends JFrame {

	private JPanel contentPane;
	Time timeobj;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showtime frame = new showtime("124");
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
	public showtime(String Movie_id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("X:\\College Projects\\DBMS-Java Project\\movie\\objects-17-512.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 695, 577);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] heading= {"Theater","Timing"};
		String[][] results=new String[20][2];
		
		try
		{  //Connection//
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
			String a="select * from showtime where Movie_id=?";
			PreparedStatement ps=con.prepareStatement(a);
			ps.setInt(1, Integer.parseInt(Movie_id));
			ResultSet rs=ps.executeQuery();
			int i=0,j=0;
			while(rs.next()) {
				results[i][j++]=rs.getString(2);  //GETTING THEATER NAME//
	            results[i++][j--]=rs.getString(3); //GETTING SHOWTIMING//
			}
			
			/*for( String[] x : results) {
	            for(String y : x) {
	                System.out.print(y);
	            }
	            System.out.println("");
			}*/
		}
		catch(Exception e) {
			
		}
		
		JLabel lblShowtimes = new JLabel("SHOWTIMES");
		lblShowtimes.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowtimes.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblShowtimes.setBounds(256, 13, 164, 44);
		contentPane.add(lblShowtimes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 60, 653, 457);
		contentPane.add(scrollPane_1);
		
		table = new JTable(results,heading);
		scrollPane_1.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Dimension dim = new Dimension(20,1);
		table.setIntercellSpacing(new Dimension(dim));
		SetRowHight(table);
	}
	public void SetRowHight(JTable table)
	{
		  int height = table.getRowHeight();
		  table.setRowHeight(height+10);
	}
}
