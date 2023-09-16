package tuan2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DemoCheckBox_VoTanDat_15 extends JFrame implements ActionListener{
	
	private JTextField txtInput;
	private JCheckBox chkB;
	private JCheckBox chkI;

	DemoCheckBox_VoTanDat_15(){
		setTitle("Demo JCheckBox");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel pntext = new JPanel();
		txtInput = new JTextField(15);
		txtInput.setText("Lap trinh java swing");
		
		JPanel pnselect = new JPanel();
		chkB = new JCheckBox("Bold");
		chkI = new JCheckBox("Italic");
		pnselect.add(chkB);
		pnselect.add(chkI);
		pntext.add(txtInput);
		
		JPanel pnMain = new JPanel();
		pnMain.add(pntext);
		pnMain.add(pnselect);
		add(pnMain);
		
		chkI.addActionListener(this);
		chkB.addActionListener(this);
	}
	public static void main(String[] args) {
		new DemoCheckBox_VoTanDat_15().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oj = e.getSource();
		Font f= txtInput.getFont();
		
		if (oj.equals(chkB)) {
			txtInput.setFont(new Font(f.getName(), f.getStyle() ^ Font.BOLD, f.getSize()));
		}else {
			txtInput.setFont(new Font(f.getName(), f.getStyle() ^ Font.ITALIC, f.getSize()));
		}
		
	}
}
