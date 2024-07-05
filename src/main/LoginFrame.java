package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.ConnectSql;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txttaikhoan;
	private JPasswordField txtmatkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setTitle("PIKACHU VÀ ĐẢO KHO BÁU");
					frame.setLocationRelativeTo(null);
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
	public LoginFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Đăng nhập\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				ConnectSql cns = new ConnectSql();
				
				String username = txttaikhoan.getText();
				String password = new String(txtmatkhau.getPassword());
				
				if(username.isEmpty()||password.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Không được bỏ trống tài khoản hoặc mật khẩu." );
				}
				else {
					conn = cns.getConnection();
					PreparedStatement pst = null;
					 
					 
					 try {
						 String sql = "SELECT * FROM dangnhap WHERE taikhoan=? and matkhau=?";
						pst = conn.prepareCall(sql);
						
						pst.setString(1,username);
						pst.setString(2, password);
						
						ResultSet rs = pst.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null,"Đăng nhập thành công." );
							Main m = new Main();
							m.show();
							dispose();
							
						}else {
							JOptionPane.showMessageDialog(null,"Đăng nhập thất bại." );
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
				} 
			}
		});
		btnNewButton.setBounds(486, 296, 125, 37);
		contentPane.add(btnNewButton);
		
		JButton btnngK = new JButton("Đăng Kí\r\n");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpFrame signUp = new SignUpFrame();
				signUp.show();
				dispose();
			}
		});
		btnngK.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnngK.setBounds(304, 296, 98, 37);
		contentPane.add(btnngK);
		
		JLabel lblNewLabel = new JLabel("Tài khoản:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(37, 84, 125, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu:\r\n");
		lblMtKhu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMtKhu.setBounds(37, 165, 125, 50);
		contentPane.add(lblMtKhu);
		
		txttaikhoan = new JTextField();
		txttaikhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttaikhoan.setBounds(209, 85, 303, 50);
		contentPane.add(txttaikhoan);
		txttaikhoan.setColumns(10);
		
		txtmatkhau = new JPasswordField();
		txtmatkhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtmatkhau.setBounds(209, 168, 303, 46);
		contentPane.add(txtmatkhau);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\đồ án java 2\\res\\attack2\\High_resolution_wallpaper_background_ID_77700116284.jpg"));
		lblNewLabel_1.setBounds(0, 0, 666, 344);
		contentPane.add(lblNewLabel_1);
	}
}
