import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class LoginPanel extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					LoginPanel frame = new LoginPanel();
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
	public LoginPanel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(232, 11, 100, 36);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(lblLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 544, 36);
		panel.add(panel_1);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsername.setBounds(72, 122, 124, 28);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(72, 182, 124, 28);
		panel.add(lblPassword);
		
		uname = new JTextField();
		uname.setBounds(206, 129, 200, 21);
		panel.add(uname);
		uname.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(206, 189, 200, 21);
		panel.add(pass);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "ADMIN", "USER"}));
		comboBox.setBounds(206, 238, 200, 20);
		panel.add(comboBox);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value=(String)comboBox.getSelectedItem();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/med","root","");
					Statement stmt=con.createStatement();
					String query="Select * from login where username='"+uname.getText()+"' and password='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(query);
					admin ad=new admin();
					user us=new user();
					LoginPanel lp=new LoginPanel();
					if(rs.next()&& value.equals("ADMIN")&& uname.getText().equalsIgnoreCase("admin"))
						{ad.setVisible(true);
						lp.setVisible(false);
						uname.setText("");
						pass.setText("");
						}
					else if(value.equals("USER"))
					{	lp.setVisible(false);
						us.setVisible(true);
						uname.setText("");
						pass.setText("");
					}
					else 
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
				}
				catch(Exception ex) {
					System.out.print(ex);
				}
			}
		}
		);
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogin.setBounds(206, 269, 89, 23);
		panel.add(btnLogin);
		
		JLabel lblLoginAs = new JLabel("LOGIN AS");
		lblLoginAs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLoginAs.setBounds(72, 235, 124, 28);
		panel.add(lblLoginAs);
		
		
	}
}
