import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ipinfo extends JFrame {

	ipinfo() {
		setTitle("设置本机ip");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new jp());
		setVisible(true);
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
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// AutoInstall.issubthreadover = true;
				// System.out.println("dddddd");
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});

	}

	public class jp extends JPanel {
		JTextField ip1 = new JTextField();
		JTextField mask1 = new JTextField();
		JTextField dns11 = new JTextField();
		JTextField dns22 = new JTextField();
		JLabel ip2 = new JLabel("ip地址");
		JLabel mask2 = new JLabel("子网掩码");
		JLabel dns111 = new JLabel("DNS1");
		JLabel dns222 = new JLabel("DNS2");
		JButton submit = new JButton("确定");
		JTextField netgate1 = new JTextField();
		JLabel netgate11 = new JLabel("默认网关");
		JLabel zzq = new JLabel("by 张正琪| zhangzq.pl@gs.pbc.gov");

		public jp() {
			// TODO Auto-generated constructor stub
			
			setLocationRelativeTo(null);
			submit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					int res = JOptionPane.showConfirmDialog(null,
							"确认信息：\n ip=" + ip1.getText() + "\n mask=" + mask1.getText() + "\n netgate="
									+ netgate1.getText() + "\n dns1=" + dns11.getText() + " \n dns2=" + dns22.getText(),
							"确认", JOptionPane.YES_NO_OPTION);
					if (res == JOptionPane.YES_OPTION) {

						AutoInstall.ip = ip1.getText();
						AutoInstall.mask = mask1.getText();
						AutoInstall.netgate = netgate1.getText();
						AutoInstall.dns1 = dns11.getText();
						AutoInstall.dns2 = dns22.getText();
						dispose();
						AutoInstall.issubthreadover = true;
					}

				}
			});
			setBackground(Color.white);
			setLayout(new GridLayout(12, 1, 5, 5));
			add(ip2);
			add(ip1);
			add(mask2);
			add(mask1);
			add(netgate11);
			add(netgate1);
			add(dns111);
			add(dns11);
			add(dns222);
			add(dns22);
			add(submit);
			add(zzq);
		}

	}

}
