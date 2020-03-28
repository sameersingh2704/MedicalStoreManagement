import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class user extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField price1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user frame = new user();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	DefaultTableModel df;
	private JTextField qty;
	private JTextField qty1;
	private JTextField total;
	private JTextField block;
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
	public user() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 689, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setFont(new Font("Traditional Arabic", Font.BOLD, 30));
		lblUser.setBounds(298, 0, 121, 43);
		panel.add(lblUser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 54, 689, 297);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setBounds(10, 11, 124, 27);
		panel_1.add(lblName);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setBounds(10, 95, 124, 27);
		panel_1.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrice.setBounds(10, 133, 124, 27);
		panel_1.add(lblPrice);
		qty1 = new JTextField();
		qty1.setColumns(10);
		qty1.setBounds(144, 99, 184, 27);
		panel_1.add(qty1);
		
		price1 = new JTextField();
		price1.setEditable(false);
		price1.setBounds(144, 137, 184, 27);
		panel_1.add(price1);
		price1.setColumns(10);
		block = new JTextField();
		block.setEditable(false);
		block.setColumns(10);
		block.setBounds(144, 53, 184, 27);
		panel_1.add(block);
		
		total = new JTextField();
		total.setEditable(false);
		total.setColumns(10);
		total.setBounds(144, 171, 184, 27);
		panel_1.add(total);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/med","root","");
						pst=con.prepareStatement("select * from items where Name=?");
						pst.setString(1, textField.getText());
						rs=pst.executeQuery();
						if(rs.next()== false)
						{
							JOptionPane.showMessageDialog(null, "MED NOT FOUND");
						}
						else
						{	
							String name=rs.getString("Name");
							textField.setText(name.trim());
							
							String price=rs.getString("Price");
							price1.setText(price.trim());
							
							String box=rs.getString("Box");
							block.setText(box.trim());
							
							
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
		});
		textField.setBounds(144, 15, 184, 27);
		panel_1.add(textField);
		textField.setColumns(10);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(340, 11, 339, 187);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Block", "Quantity", "Cost"
			}
		));
		admin obj1=new admin();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/med","root","");
					pst=con.prepareStatement("select * from items where Name=?");
					pst.setString(1, textField.getText());
					rs=pst.executeQuery();
					if(rs.next())
					{
						int qtf=Integer.parseInt(rs.getString("Quantity"));
						qtf=qtf-Integer.parseInt(qty1.getText());
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				df=(DefaultTableModel)table.getModel();
				int tot=Integer.parseInt(price1.getText())*Integer.parseInt(qty1.getText());
				df.addRow(new Object[]
						{
								textField.getText(),
								block.getText(),
								qty1.getText(),
								tot
						}
						
						
						);
				int sum=0;
				
				total.setText(String.valueOf(sum));
				textField.setText("");
				price1.setText("");
				qty1.setText("");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(35, 248, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnPrint = new JButton("VIEW");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				items it=new items();
				it.setVisible(true);
			}
		});
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPrint.setBounds(144, 249, 89, 23);
		panel_1.add(btnPrint);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotal.setBounds(10, 167, 124, 27);
		panel_1.add(lblTotal);
		
		JLabel lblBlock = new JLabel("BLOCK");
		lblBlock.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlock.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBlock.setBounds(10, 49, 124, 27);
		panel_1.add(lblBlock);
		
		
		
	
		
		
	}
}
