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
		setTitle("进度");
		setSize(200, 100);;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		bar.setIndeterminate(true);//设置进度条的样式为不确定的进度条样式（进度条来回滚动），false为确定的进度条样式（即进度条从头到尾显示）
		bar.setStringPainted(true);//设置进度条显示提示信息		
		bar.setString("检测网络中");//设置提示信息
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 1));
		c.add(bar);
		setVisible(true);
		setLocationRelativeTo(null); 

	}
	

	
	

}
