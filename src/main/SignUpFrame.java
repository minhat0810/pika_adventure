package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.ConnectSql;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SignUpFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txttk;
	private JPasswordField txtmk;
	private JPasswordField txtrmk;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUpFrame frame = new SignUpFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SignUpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("PIKACHU VÀ ĐẢO KHO BÁU");
		setLocationRelativeTo(null);
		txttk = new JTextField();
		txttk.setBounds(279, 31, 253, 28);
		contentPane.add(txttk);
		txttk.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên tài khoản:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(44, 32, 140, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu:");
		lblMtKhu.setForeground(new Color(255, 255, 255));
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMtKhu.setBounds(44, 85, 140, 43);
		contentPane.add(lblMtKhu);
		
		JLabel lblXcNhnLi = new JLabel("Xác nhận lại mật khẩu:");
		lblXcNhnLi.setForeground(new Color(255, 255, 255));
		lblXcNhnLi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblXcNhnLi.setBounds(44, 134, 205, 43);
		contentPane.add(lblXcNhnLi);
		
		JButton dkBtn = new JButton("Đăng kí ngay");
		dkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				ConnectSql cns = new ConnectSql();
				String username = txttk.getText();
				String password = new String(txtmk.getText());
				String repassword = new String(txtrmk.getText());
				
				if(username.isEmpty()||password.isEmpty() || repassword.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Không được bỏ trống tài khoản hoặc mật khẩu." );
				}
				else
				try {
					
					conn = cns.getConnection();
					String sql = "insert into dangnhap values(?,?)";
					String check_pk = "Select taikhoan from dangnhap where taikhoan = '"+username+"'";
					
					PreparedStatement pst = conn.prepareStatement(sql);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(check_pk);
					StringBuilder sb = new StringBuilder();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Tên tài khoản đã tồn tại." );
						//sb.append("Tên tài khoản đã tồn tại.");
					}
					
					if(!password.equals(repassword)) {
						JOptionPane.showMessageDialog(null,"Mật khẩu không trùng khớp" );
					}
//					
					else {
						pst.setString(1, txttk.getText());
						pst.setString(2, txtmk.getText());
						
						int n;
						n = pst.executeUpdate();
						if(n!=0) {
							JOptionPane.showMessageDialog(null, "Đăng kí thành công");
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
		  }     
		});
		dkBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		dkBtn.setBounds(315, 224, 220, 33);
		contentPane.add(dkBtn);
		
		JButton btnQuayLi = new JButton("Quay lại");
		btnQuayLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame login = new LoginFrame();
				login.show();
				dispose();
			}
		});
		btnQuayLi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnQuayLi.setBounds(44, 224, 163, 33);
		contentPane.add(btnQuayLi);
		
		txtmk = new JPasswordField();
		txtmk.setBounds(279, 85, 253, 33);
		contentPane.add(txtmk);
		
		txtrmk = new JPasswordField();
		txtrmk.setBounds(279, 141, 253, 33);
		contentPane.add(txtrmk);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\đồ án java 2\\res\\attack2\\24934.jpg"));
		lblNewLabel_1.setBounds(0, 0, 605, 310);
		contentPane.add(lblNewLabel_1);
	}
}
