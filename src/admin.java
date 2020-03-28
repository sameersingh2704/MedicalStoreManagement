import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField price;
	private JTextField cat;
	private JTextField box;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pst;
	private JTextField qty;
	public void Connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the frame.
	 */
	public admin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(10, 11, 378, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAdmin.setBounds(140, 11, 105, 31);
		panel.add(lblAdmin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 75, 378, 375);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setBounds(10, 11, 143, 28);
		panel_1.add(lblName);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setBounds(10, 50, 143, 28);
		panel_1.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrice.setBounds(10, 89, 143, 28);
		panel_1.add(lblPrice);
		
		JLabel lblCategory = new JLabel("CATEGORY");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCategory.setBounds(10, 128, 143, 28);
		panel_1.add(lblCategory);
		
		JLabel lblBox = new JLabel("BOX");
		lblBox.setHorizontalAlignment(SwingConstants.CENTER);
		lblBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBox.setBounds(10, 167, 143, 28);
		panel_1.add(lblBox);
		
		name = new JTextField();
		name.setBounds(142, 16, 180, 23);
		panel_1.add(name);
		name.setColumns(10);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(142, 94, 180, 23);
		panel_1.add(price);
		
		cat = new JTextField();
		cat.setColumns(10);
		cat.setBounds(142, 133, 180, 23);
		panel_1.add(cat);
		
		box = new JTextField();
		box.setColumns(10);
		box.setBounds(142, 172, 180, 23);
		panel_1.add(box);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/med","root","");
					String addQuery="INSERT INTO items(Name,Box,Price,Quantity,Category) VALUES(?,?,?,?,?)";
					pst=con.prepareStatement(addQuery);
					pst.setString(1, name.getText());
					pst.setString(2, box.getText());
					pst.setInt(3, Integer.valueOf(price.getText()));
					pst.setInt(4, Integer.valueOf(qty.getText()));
					pst.setString(5, cat.getText());
					pst.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAdd.setBackground(new Color(0, 100, 0));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.setBounds(61, 250, 109, 45);
		panel_1.add(btnAdd);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogout.setBounds(202, 250, 109, 45);
		panel_1.add(btnLogout);
		
		qty = new JTextField();
		qty.setColumns(10);
		qty.setBounds(142, 55, 180, 23);
		panel_1.add(qty);
		
		
	}
}
