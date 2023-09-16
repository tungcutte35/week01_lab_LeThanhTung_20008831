package tuan1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class CongTruNhanChia extends JFrame implements ActionListener{
	private JLabel lblTieuDe;
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JLabel lblNhapA;
	private JLabel lblNhapB;
	private JTextField txtNhapA;
	private JTextField txtNhapB;
	private JRadioButton radCong;
	private JRadioButton radTru;
	private JRadioButton radNhan;
	private JRadioButton radChia;
	private JLabel lblKetQuan;
	private JLabel lblKetQua;
	private JLabel lblHienThiKetQua;
	private ButtonGroup bG;
	private JButton btnXanhD;
	private JButton btnXanh;
	private JButton btnDo;
	private JPanel pnFooter;

	CongTruNhanChia() {
		
		//JFrame
		setTitle("Cộng- trừ - nhân - chia");
		setSize(500, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		// JLable tiêu đề
		lblTieuDe = new JLabel(
				"<html><span style='font-size:20px;color: red';>" + "Cộng Trừ Nhân Chia" + "</span></html>");
		lblTieuDe.setBounds(125, 0, 400, 50);

		// Panel tác vụ để chứa các componet tác vụ
		JPanel pnTacVu = new JPanel();
		// tạo viền 
		Border bdrTacVu = BorderFactory.createLineBorder(Color.lightGray);
		TitledBorder tbdr = new TitledBorder(bdrTacVu, "Chọn tác vụ");
		pnTacVu.setBorder(tbdr);
		pnTacVu.setBackground(Color.gray);
		btnGiai = new JButton("Giải");
		btnGiai.setBounds(15, 20, 90, 30);
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(15, 60, 90, 30);
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(15, 100, 90, 30);
		pnTacVu.setBounds(10, 60, 120, 300);
		pnTacVu.setLayout(null);
		pnTacVu.add(btnGiai);
		pnTacVu.add(btnXoa);
		pnTacVu.add(btnThoat);
		
		// Panel tính toán
		Border bdrTinhToan = BorderFactory.createLineBorder(Color.gray);
		TitledBorder tbdrTinhToan = new TitledBorder(bdrTinhToan, "Tính toán");
		JPanel pnTinhToan = new JPanel();
		pnTinhToan.setBorder(tbdrTinhToan);
		pnTinhToan.setBounds(130, 60, 345, 300);
		lblNhapA = new JLabel("Nhập a: ");
		lblNhapA.setBounds(20, 20, 50, 30);
		txtNhapA = new JTextField(50);
		txtNhapA.setBounds(80, 20, 200, 30);
		lblNhapB = new JLabel("Nhập b: ");
		lblNhapB.setBounds(20, 60, 50, 30);
		txtNhapB = new JTextField(50);
		txtNhapB.setBounds(80, 60, 200, 30);
		pnTinhToan.setLayout(null);
		pnTinhToan.add(lblNhapA);
		pnTinhToan.add(txtNhapA);
		pnTinhToan.add(txtNhapB);
		pnTinhToan.add(lblNhapB);
		
		// Panel phép tính
		JPanel pnPhepTinh = new JPanel();
		Border bdrPhepTinh = BorderFactory.createLineBorder(Color.gray);
		TitledBorder tbdrPhepTinh = new TitledBorder(bdrTinhToan, "Phép toán");
		pnPhepTinh.setBorder(tbdrPhepTinh);
		pnPhepTinh.setBounds(80, 100, 200, 100);
		radCong = new JRadioButton("Cộng");
		radCong.setBounds(10, 20, 80, 30);
		radTru = new JRadioButton("Trừ");
		radTru.setBounds(110, 20, 80, 30);
		radNhan = new JRadioButton("Nhân");
		radNhan.setBounds(10, 60, 80, 30);
		radChia = new JRadioButton("Chia");
		radChia.setBounds(110, 60, 80, 30);
		
		// tạo group chứa các radiobuton
		bG = new ButtonGroup();
		bG.add(radCong);
		bG.add(radTru);
		bG.add(radNhan);
		bG.add(radChia);

		lblKetQua = new JLabel("Kết quả:");
		lblKetQua.setBounds(20, 220, 50, 30);
		lblHienThiKetQua = new JLabel();
		Border bdrKetQua = BorderFactory.createLineBorder(Color.gray);
		TitledBorder tlbdrKetQua = new TitledBorder(bdrKetQua);
		lblHienThiKetQua.setBorder(tlbdrKetQua);
		lblHienThiKetQua.setBounds(80, 220, 200, 30);
		// lblHienThiKetQua.setOpaque(true);
		pnPhepTinh.setLayout(null);
		pnPhepTinh.add(radCong);
		pnPhepTinh.add(radTru);
		pnPhepTinh.add(radNhan);
		pnPhepTinh.add(radChia);
		pnTinhToan.add(pnPhepTinh);
		pnTinhToan.add(lblKetQua);
		pnTinhToan.add(lblHienThiKetQua);
		add(lblTieuDe);
		add(pnTacVu);
		add(pnTinhToan);
		
		pnFooter = new JPanel();
		pnFooter.setBounds(10, 360, 465, 40);
		pnFooter.setBackground(Color.pink);
		
		btnDo = new JButton();
		btnDo.setBackground(Color.red);
		btnXanh = new JButton();
		btnXanh.setBackground(Color.green);
		btnXanhD = new JButton();
		btnXanhD.setBackground(Color.blue);
		pnFooter.add(btnDo);
		pnFooter.add(btnXanh);
		pnFooter.add(btnXanhD);
		add(pnFooter);
		// đăng kí sự kiện
		btnXoa.addActionListener(this);
		btnGiai.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXanh.addActionListener(this);
		btnXanhD.addActionListener(this);
		btnDo.addActionListener(this);
	}

	
	//main
	public static void main(String[] args) {
		new CongTruNhanChia().setVisible(true);
	}
	
	// lớp tính toán thực hiện chức năng 
	public class TinhToan {
		private int a;
		private int b;
		private String phepToan;
		
		// contructor
		TinhToan(int a, int b, String phepToan) {
			this.a = a;
			this.b = b;
			this.phepToan = phepToan;
		}
		
		// hàm thực hiện tính toán
		public String ThucHienTinhToan() {
			if(phepToan.equals("+")) {
				return ""+ (a+ b);
			}else if (phepToan.equals("-")) {
				return ""+ (a - b);
			}else if (phepToan.equals("*")) {
				return ""+ (a * b);
			}else {
				return Double.toString((double)(a*1.0 / b));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oj = e.getSource();
		if(oj.equals(btnXoa)) {
			txtNhapA.setText("");
			txtNhapB.setText("");
			txtNhapA.requestFocus();
			
		}else if (oj.equals(btnGiai)) {
			// khởi tạo các giá trị
			int a = 0;
			int b = 0;
			String getPhepToan = "#";
			
			// kiểm tra dữ liệu đầu vào của a
			try {
				a = Integer.parseInt(txtNhapA.getText().trim());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Dữ liệu sai");
				txtNhapA.setText("");
				txtNhapA.requestFocus();
			}
			// kiểm tra dữ liệu đầu vào của b
			try {
				b = Integer.parseInt(txtNhapB.getText().trim());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Dữ liệu sai");
				txtNhapB.setText("");
				txtNhapB.requestFocus();
			}
			
			// lấy phép toán
		  	if(radCong.isSelected()) {
		  		getPhepToan = "+";
		  	}else if (radTru.isSelected()) {
		  		getPhepToan = "-";
			}else if (radNhan.isSelected()) {
				getPhepToan = "*";
			}else if(radChia.isSelected()){
				getPhepToan = "/";
			}
		  	
		  	// kiểm tra xem người dùng chọn phép toán chưa
		  	if (getPhepToan.equals("#")) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn phép toán");
			}else {
				TinhToan giai = new TinhToan(a, b, getPhepToan);
			  	String ketQua = giai.ThucHienTinhToan();
			  	lblHienThiKetQua.setText(ketQua);
			}
		  	
		 // nút thoát 	
		}else if(oj.equals(btnThoat)) {
			int ret = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn thoát không", "Thoát chương trình",JOptionPane.YES_NO_OPTION);
			if(ret == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}else if (oj.equals(btnXanh)) {
			pnFooter.setBackground(Color.green);
		}else if (oj.equals(btnDo)) {
			pnFooter.setBackground(Color.red);
		}else if (oj.equals(btnXanhD)) {
			pnFooter.setBackground(Color.blue);
		}
		
	}

}
