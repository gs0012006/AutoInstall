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
		JLabel jl = new JLabel("�ļ�������");
	
		
		public downprogressbar() {
			// TODO Auto-generated constructor stub
			jf.setLayout(new GridLayout(2,1));
			jf.setVisible(true);
			jf.setTitle("�ļ�����");
			jf.setResizable(false);
			jf.setDefaultCloseOperation(0);
			Container c = jf.getContentPane();
			c.add(jl);
			c.add(jpb);
			jf.setSize(600, 100);
			jf.setLocationRelativeTo(null);
			jpb.setMaximum(100);
			jpb.setMinimum(0);
			jpb.setStringPainted(true);//���ý�������ʾ��ʾ��Ϣ		
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

			to =Integer.toString(AutoInstall.filesnum)+"���ļ������أ��������ص�"+Integer.toString(AutoInstall.currentfileindex)+AutoInstall.currentfilename+"�ļ���СΪ"+AutoInstall.totalsize+"�Ѿ�������"+downallfiles.trans/1024+"kb";
			jl.setText(to);
			jpb.setValue(v);
			jpb.setString(Integer.toString(v)+"%");//������ʾ��Ϣ
			
			
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
