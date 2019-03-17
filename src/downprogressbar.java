import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;

import javax.management.openmbean.OpenMBeanOperationInfoSupport;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;



public class downprogressbar implements Runnable{
		JFrame jf = new JFrame();
		JProgressBar jpb = new JProgressBar();
		JLabel jl = new JLabel("文件下载中");
	
		
		public downprogressbar() {
			// TODO Auto-generated constructor stub
			jf.setLayout(new GridLayout(2,1));
			jf.setVisible(true);
			jf.setTitle("文件下载");
			jf.setResizable(false);
			jf.setDefaultCloseOperation(0);
			Container c = jf.getContentPane();
			c.add(jl);
			c.add(jpb);
			jf.setSize(600, 100);
			jf.setLocationRelativeTo(null);
			jpb.setMaximum(100);
			jpb.setMinimum(0);
			jpb.setStringPainted(true);//设置进度条显示提示信息		
			jf.setAlwaysOnTop(true);
		}
		
	@Override		

	public void run() {
		//System.out.println("third thread is start!"+AutoInstall.iscompletedown);
		String sizeString;
		String to;
		while (!AutoInstall.iscompletedown) {
			
		//	System.out.println("third tdddddffdfdfd");
			//System.out.println("haha"+downallfiles.trans);
			//System.out.println("haha"+AutoInstall.totalf);
			
			int v = (int) (downallfiles.trans*100/AutoInstall.totalf);
			//System.out.println(v);

			to =Integer.toString(AutoInstall.filesnum)+"个文件待下载，正在下载第"+Integer.toString(AutoInstall.currentfileindex)+AutoInstall.currentfilename+"文件大小为"+AutoInstall.totalsize+"已经下载了"+downallfiles.trans/1024+"kb";
			jl.setText(to);
			jpb.setValue(v);
			jpb.setString(Integer.toString(v)+"%");//设置提示信息
			
			
		}
	
		
		System.out.println("third thread is stop!");
		jf.dispose();
		
		
	}
	
	
	   public static long getFileSize1(File file) {
	        if (file.exists() && file.isFile()) {
	           return file.length();
	        }
			return 0;
			
	    }
	
	

}
