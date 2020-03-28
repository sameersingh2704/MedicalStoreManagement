import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	private JTextField jname;
	private JTextField jprice;
	private JTextField jquantity;
	private JTextField jcategory;
	private JTextField jbox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	
	
	public AdminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 564, 439);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminPanel = new JLabel("ADMIN PANEL");
		lblAdminPanel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAdminPanel.setBounds(170, 11, 232, 36);
		panel.add(lblAdminPanel);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(139, 46, 415, 382);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 544, 36);
		panel.add(panel_1);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setForeground(Color.ORANGE);
		panel_2.setBounds(10, 46, 132, 382);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCategory = new JLabel("CATEGORY");
		lblCategory.setBounds(33, 254, 179, 26);
		panel_2.add(lblCategory);
		lblCategory.setForeground(Color.RED);
		lblCategory.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCategory.setBackground(Color.WHITE);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(33, 194, 179, 26);
		panel_2.add(lblQuantity);
		lblQuantity.setForeground(Color.RED);
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setBackground(Color.WHITE);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setBounds(33, 141, 179, 26);
		panel_2.add(lblPrice);
		lblPrice.setForeground(Color.RED);
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrice.setBackground(Color.WHITE);
		
		JLabel lblBox = new JLabel("BOX");
		lblBox.setBounds(33, 95, 179, 26);
		panel_2.add(lblBox);
		lblBox.setForeground(Color.RED);
		lblBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBox.setBackground(Color.WHITE);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(33, 48, 179, 26);
		panel_2.add(lblName);
		lblName.setForeground(Color.RED);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setBackground(Color.WHITE);
		
		
		
		jcategory = new JTextField();
		jcategory.setBounds(46, 254, 186, 20);
		panel_3.add(jcategory);
		jcategory.setColumns(10);
		
		jquantity = new JTextField();
		jquantity.setBounds(46, 194, 186, 20);
		panel_3.add(jquantity);
		jquantity.setColumns(10);
		
		jprice = new JTextField();
		jprice.setBounds(46, 141, 186, 20);
		panel_3.add(jprice);
		jprice.setColumns(10);
		
		jname = new JTextField();
		jname.setBounds(46, 48, 186, 20);
		panel_3.add(jname);
		jname.setColumns(10);
		
		JButton btnAddProduct = new JButton("ADD");
		btnAddProduct.setBounds(87, 307, 99, 23);
		panel_3.add(btnAddProduct);
		btnAddProduct.setBackground(Color.YELLOW);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name=jname.getText().toString();
					String box=jbox.getText().toString();
					String price=jprice.getText().toString();
					String quantity=jquantity.getText().toString();
					String category=jcategory.getText().toString();
					Connection con;
					PreparedStatement pst;
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/med","root","");
					pst=con.prepareStatement("insert into 'items' ('Name','Box','Price',Quantity','Category') values (?,?,?,?,?,)");
					pst.setString(1, name);
					pst.setString(2, box);
					pst.setString(3,price);
					pst.setString(4,quantity);
					pst.setString(5, category);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null," Med Added!!!");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAddProduct.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton button = new JButton("LogOut");
		button.setBounds(293, 11, 112, 23);
		panel_3.add(button);
		button.setBackground(Color.RED);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		jbox = new JTextField();
		jbox.setBounds(46, 97, 186, 20);
		panel_3.add(jbox);
		jbox.setColumns(10);
		
		
	}
}
