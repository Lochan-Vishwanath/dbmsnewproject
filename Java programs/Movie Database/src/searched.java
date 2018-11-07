import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class searched extends JFrame 
{

	private JPanel contentPane;
	private JTable table_1;
	private ScrollPane scrollPane;
	private JScrollPane scrollPane_1;

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
					//searched frame = new searched();
					//frame.setVisible(true);
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
	public searched(String[] received)
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("X:\\College Projects\\DBMS-Java Project\\movie\\objects-17-512.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchResults = new JLabel("SEARCH RESULTS");
		lblSearchResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchResults.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSearchResults.setBounds(286, 27, 199, 51);
		contentPane.add(lblSearchResults);
		
		
		
		
		String[] columns= {"Movie ID","Movie Name"};
		String[][] Data= {{},{}};
		
		table_1 = new JTable(received,columns);
		table_1.setBounds(44, 91, 699, 315);
		contentPane.add(table_1);
		
		scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(30, 77, 730, 293);
		contentPane.add(scrollPane_1);
		
		
		
	}
}
