import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicMenuBarUI;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;

import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;

import sun.net.TransferProtocolClient;
import sun.net.ftp.FtpClient;


public class AutoInstall {
	static ExecutorService executorService = Executors.newFixedThreadPool(1);
	static String S = getcorrentdir();
	public static String ip = "";
	public static String mask = "";
	public static String netgate = "";
	public static String dns1 = "";
	public static String dns2 = "";
	static boolean issubthreadover = false;
	static int filesnum = 0;//待下载文件总数
	static int currentfileindex = 1;//当前文件序号
	static String totalsize = "";//当前文件总大小
	static String currentsize ="";//文件当前已下载
	static String currentfilename="";//当前下载文件名
	static String currentfilepathString ="";//当前文件下载路径
	static boolean iscompletedown = false;//下载完成标志
	static long totalf = 0; ///pp
	static  FTPFile[] files1;
	public static void main(String[] args) throws Exception {
	
		String classPath = AutoInstall.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		String cmd1 = "cmd.exe /c mkdir " + S + "\\data";
		String cmd2 = "cmd.exe /c mkdir " + S + "\\pro";
		//String cmd5 = "cmd.exe /c jar -xvf " + classPath;
		//String cmd4 = "cmd.exe /c " + S + "\\UnRAR e " + S + "\\data.rar " + S + "\\data";
		excute(cmd1);
		excute(cmd2);
		//excute(cmd5);
		//excute(cmd4);
		String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 创建线程并提交线程，同时获取一个future对象
		Thread subThread = new Thread(new SubThread());
		Future future = executorService.submit(subThread);
		// 主线程处理其他工作，让子线程异步去执行
		future.get();
		Thread secondThread = new Thread(new SecondThread());
		Future future2 = executorService.submit(secondThread);
		JFrame frame = new checkingnet();
		future2.get();
		System.out.println("se ok");
		if (isConnect("127.0.0.1")) {
			
		}
		else {

		JOptionPane.showMessageDialog(null,"网络连接失败，请重试！","错误 ",0);
		System.exit(0);
		}
		
		frame.dispose();
	
		
		//downFile("127.0.0.1", 21, "pbcpl", "password", "/w", "plink.exe", AutoInstall.S);
		downallfiles fUp = new downallfiles("127.0.0.1", 21, "pbcpl", "password");
		FTPClient ftpc = new FTPClient();
		ftpc.connect("127.0.0.1");//192.3.191.159
		ftpc.login("pbcpl", "password");
		System.out.println("login ftpc ok ...");
		fUp.login();
		String remoteRoot = "/";
		fUp.sendCommand(remoteRoot);
		List fileList = fUp.fileNames(remoteRoot);
		filesnum = fileList.size();
		FTPListParseEngine engine = ftpc.initiateListParsing("/");
		System.out.println(engine);
		while(engine.hasNext()){  
             files1 = engine.getNext(50); 
             System.out.println(files1.length);
            for(int c=0;c<files1.length;c++){  
                //获取文件名  
              System.out.println(files1[c].getName());  
                //获取文件大小  
                long size = files1[c].getSize();
                System.out.println(size);
                System.out.println(size/1024+"kb");  
            }  
        } 
		Thread thirdThread  =  new Thread(new downprogressbar());
		Future future3 = executorService.submit(thirdThread);
		for (int i = 0; i < fileList.size(); i++) {
			downallfiles.trans=0;
			String fileName = fileList.get(i).toString();
			currentfilename = fileName;
			currentfileindex = i+1;
			 //获取文件大小  
            long size = files1[i].getSize();
            totalf = size;
            totalsize = size/1024 +"kb";
			System.out.println(fileName);
			String destinationFile = S+"//data/";
			String tempFile = destinationFile  + fileName;
			currentfilepathString = tempFile;
			fUp.downFile(fileName, tempFile);
			
		
		}
		fUp.logout();
		
		iscompletedown = true;
		future3.get();
		System.out.println(iscompletedown);
		JFrame insFrame = new installing();
		excute("cmd.exe /c "+S+"\\UnRAR.exe x -y "+S+"\\data\\PRO11.rar "+S+"\\data");
		excute("cmd.exe /c "+S+"\\UnRAR.exe x -y "+S+"\\data\\sepreader.rar "+S+"\\data");
		Thread.sleep(7000);
		System.out.println("wait over");
		Thread fourth = new Thread(new fourthThread());
		Future f = executorService.submit(fourth);
		
		f.get();
		insFrame.dispose();
		
		System.out.println("Main Thread work done!");
	


		// 关闭线程池
		executorService.shutdown();
		System.out.println("sss");
		System.exit(0);

	}

	public static String getcorrentdir() {

		String s = System.getProperty("user.dir");

		return s;

	}

	public static void excute(String cmd) {
		Runtime run = Runtime.getRuntime();
		try {
			Process process = run.exec(cmd);
			InputStream in = process.getInputStream();
			while (in.read() != -1) {
				System.out.println(in.read());
			}
			in.close();
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	private static class SubThread implements Runnable {
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Sub thread is starting!");
			new ipinfo();
			for (; true;) {
				//System.out.println("...");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (issubthreadover) {// 退出条件
					break;
				}
			}
			System.out.println("Sub thread is stopping!");
		}
	}
	
	public static class SecondThread implements Runnable
	{
		
		@Override
		public void run() {
			// TODO Auto-generated method stu

			//String cmd6 = S + "\\nircmd.exe /c /b elevate netsh interface ip set address name=\"WLAN\" static " + ip + " "
			//		+ mask + " " + netgate;
			//String cmd7 = S + "\\nircmd.exe /c /b elevate netsh interface ip set dns name=\"WLAN\" static " + dns1;
			
			String cmd6 = "cmd.exe /c "+ S + "\\nircmd.exe elevate netsh interface ip set address name=\"WLAN\" static " + ip + " "
					+ mask + " " + netgate;
			
			String cmd7 = "cmd.exe /c "+ S + "\\nircmd.exe elevate netsh interface ip set dns name=\"WLAN\" static " + dns1;
			excute(cmd6);
			excute(cmd7);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		
		
		
	}
	public static class fourthThread implements Runnable
	{
		
		@Override
		public void run() {
			// TODO Auto-generated method stu

			String cmd6 = "cmd.exe /C start /b "+ S + "\\data\\setup.cmd" ;
			excute(cmd6);
		
		}
		
		
		
		
		
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 * 判断网络是否正常
	 * 
	 * 
	 * 
	 * 
	 * @return
	 * 
	 * 
	 * 
	 * 
	 */

	public static boolean isConnect(String ipPath) {
		// 定义其返回的状态，默认为false，网络不正常
		boolean connect = false;
		/**
		 * 用Runtime.getRuntime().exec()来调用系统外部的某个程序，
		 * 
		 * 他会生成一个新的进程去运行调用的程序。
		 
		 * 此方法返回一个java.lang.Process对象，
	
		 * 该对象可以得到之前开启的进程的运行结果，
		 
		 * 还可以操作进程的输入输出流。
		 
		 */

		Runtime runtime = Runtime.getRuntime();

		Process process;

		try {

			process = runtime.exec("ping " + ipPath);
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "GBK");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println("返回值为:" + sb);
			is.close();
			isr.close();
			br.close();
			if (null != sb && !sb.toString().equals("")) {
				String logString = "";
				if (sb.toString().indexOf("TTL") > 0) {
					// 网络畅通
					connect = true;
				} else {
					// 网络不畅通
					connect = false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(connect);
		return connect;

	}
	
	public static boolean downFile(  
            String url, //FTP服务器hostname  
            int port,//FTP服务器端口  
            String username, //FTP登录账号  
            String password, //FTP登录密码  
            String remotePath,//FTP服务器上的相对路径   
            String fileName,//要下载的文件名  
            String localPath//下载后保存到本地的路径 

            ) {    
        boolean success = false;    
        FTPClient ftp = new FTPClient();    
        try {    
            int reply;    
            ftp.connect(url, port);    
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器     
            ftp.login(username, password);//登录     
            reply = ftp.getReplyCode();    
            if (!FTPReply.isPositiveCompletion(reply)) {    
                ftp.disconnect();    
                return success;    
            }   
            System.out.println("aaa");
            ftp.changeWorkingDirectory(remotePath);//转移到FTP服务器目录     
            FTPFile[] fs = ftp.listFiles();  
            
            for(FTPFile ff:fs){ 
             System.out.println("bb" + ff);
             
                if(ff.getName().equals(fileName)){  
                 System.out.println("dd");
                    File localFile = new File(localPath+"/"+ff.getName());    
                    OutputStream is = new FileOutputStream(localFile);     
                    ftp.retrieveFile(ff.getName(), is);  
                    System.out.println("ccc" +ff.getName()+fileName);
                    is.close();    
                }    
            }    
            ftp.logout();    
            success = true;    
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            if (ftp.isConnected()) {    
                try {    
                    ftp.disconnect();    
                } catch (IOException ioe) {    
                }    
            }    
        }    
        return success;    
    }
//haharr
}
