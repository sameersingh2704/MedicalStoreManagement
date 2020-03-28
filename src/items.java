import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class items extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					items frame = new items();
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
	public items() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 611, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblListOfAll = new JLabel("LIST OF ALL MEDICINES");
		lblListOfAll.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblListOfAll.setBounds(118, 0, 388, 33);
		panel.add(lblListOfAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 591, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Box", "Price", "Quantity", "Category"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		
		Connection con;
		PreparedStatement pst;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/med","root","");
			String addQuery="SELECT * FROM items";
			pst=con.prepareStatement(addQuery);
			ResultSet rs=pst.executeQuery();
			DefaultTableModel tm=(DefaultTableModel)table.getModel();
			tm.setRowCount(0);
			
			while(rs.next())
			{
				Object o[]= {rs.getString("Name"),rs.getString("Box"),rs.getInt("Price"),rs.getInt("Quantity"),rs.getString("Category")};
				tm.addRow(o);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
