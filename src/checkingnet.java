import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class checkingnet extends JFrame {
	public static JProgressBar bar=new JProgressBar();
	public checkingnet() {
		// TODO Auto-generated constructor stub
		setTitle("����");
		setSize(200, 100);;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		bar.setIndeterminate(true);//���ý���������ʽΪ��ȷ���Ľ�������ʽ�����������ع�������falseΪȷ���Ľ�������ʽ������������ͷ��β��ʾ��
		bar.setStringPainted(true);//���ý�������ʾ��ʾ��Ϣ		
		bar.setString("���������");//������ʾ��Ϣ
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 1));
		c.add(bar);
		setVisible(true);
		setLocationRelativeTo(null); 

	}
	

	
	

}
