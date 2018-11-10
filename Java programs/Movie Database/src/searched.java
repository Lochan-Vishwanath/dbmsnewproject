import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class searched extends JFrame 
{

	private JPanel contentPane;
	private JTable table;

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
					searched frame = new searched(null);
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
	 * @throws SQLException 
	 */
	public searched(ResultSet rs) throws SQLException
	{
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("X:\\College Projects\\DBMS-Java Project\\movie\\objects-17-512.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 790, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchResults = new JLabel("SEARCH RESULTS");
		lblSearchResults.setForeground(new Color(205, 92, 92));
		lblSearchResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchResults.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSearchResults.setBounds(235, 27, 199, 51);
		contentPane.add(lblSearchResults);
		
		
		//CREATING DATA TO SEND TO TABLE//
		String[] heading= {"Movie ID","Movie Title"};
		String[][] results=new String[15][2];
		
        
        int i=0;
        int j=0;
        while(rs.next()) 
        {
        	
            results[i][j++]=rs.getString(1);  //GETTING MOVIE ID//
            results[i++][j--]=rs.getString(2); //GETTING MOVIE TITLE//

        }
        
        
        /*for( String[] x : results) {
            for(String y : x) {
                System.out.print(y);
            }
            System.out.println("");
        }*/
		
		table = new JTable(results,heading);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jps = new JScrollPane(table);
		jps.setBounds(45, 76, 589, 406);
		contentPane.add(jps);
		Dimension dim = new Dimension(20,1);
		table.setIntercellSpacing(new Dimension(dim));
		SetRowHight(table);
		
		
		//BUTTON USED TO RETRIEVE THE SELECTED MOVIE//
		JButton btnNkn = new JButton("RETRIEVE");
		btnNkn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int rowIndex = table.getSelectedRow();
				//System.out.println(rowIndex);// //USED TO DEMONSTRATE THE SELECTED ROW//
				display dobj=new display(results[rowIndex][0]);
				dobj.setVisible(true);
			}
		});
		btnNkn.setBounds(642, 156, 97, 25);
		contentPane.add(btnNkn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("X:\\College Projects\\DBMS-Java Project\\movie\\Plain-design-pattern-dark-background-image-HD-resolution-latest-pack.jpg"));
		lblNewLabel.setBounds(0, 0, 772, 495);
		contentPane.add(lblNewLabel);
		
	}
	public void SetRowHight(JTable table){
		  int height = table.getRowHeight();
		  table.setRowHeight(height+10);
		  }
}
