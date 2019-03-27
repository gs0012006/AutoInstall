import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.stream.events.StartDocument;

public class g {

    public String ge() {
        String cmd = "@echo \"============================\"\r\n" + 
        		"@echo \" 写入hosts\"\r\n" + 
        		"@echo \" \"\r\n" + 
        		"echo 11.82.177.4  weboayw-pld.lzh.pbc.gov >>C:\\Windows\\System32\\drivers\\etc\\hosts\r\n" + 
        		"echo 11.82.177.47	gslzhlandserv >>C:\\Windows\\System32\\drivers\\etc\\hosts\r\n" + 
        		"echo 11.129.130.116	mail4.pbc.gov >>C:\\Windows\\System32\\drivers\\etc\\hosts\r\n" + 
        		"echo 11.82.17.100    gslzhnavserv>>C:\\Windows\\System32\\drivers\\etc\\hosts\r\n" + 
        		"@echo \"============================\"\r\n" + 
        		"@echo \" 安装软件\"\r\n" + 
        		"@echo \" \"\r\n" + 
        		"data\\sepreader\\Setup.exe -s [-sms]\r\n" + 
        		"data\\AcdSee3.1.1.94.exe /S\r\n" + 
        		"data\\AdbeRdr920_zh_CN.exe /sALL /msi /passive /qb\r\n" + 
        		"data\\ChromeStandaloneSetup.exe\r\n" + 
        		"data\\flashplayer_22_ax_debug_22.0.0.210.exe /install\r\n" + 
        		"data\\Nero_8.exe /SILENT /SUPPRESSMSGBOXES /NORESTART /SP-\r\n" + 
        		"data\\office2007.exe /quiet /NORESTART\r\n" + 
        		"data\\setup_CN_2052_9.1.0.4337_Professional_VBA_yhpt.exe /S\r\n" + 
        		"data\\sogou_pinyin_3f1b.exe /S\r\n" + 
        		"data\\USB-KEY-2d.exe /SILENT /SUPPRESSMSGBOXES /NORESTART /SP-\r\n" + 
        		"data\\USB-KEY-3d.exe /S\r\n" + 
        		"data\\wrar.exe /s /d\"C:\\Program Files (x86)\\wrar.exe 0.0.0.0\\\"\r\n" + 
        		"data\\wubi.exe /S\r\n" + 
        		"data\\PRO11\\SETUP.EXE /qb\r\n" + 
        		"start data\\FeiQ2013.exe  \r\n" + 
        		"@echo \"============================\"\r\n" + 
        		"@echo \" 设置可信站点\"\r\n" + 
        		"@echo \" \"\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range100\" /v \"http\" /t REG_DWORD /d \"00000002\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range100\" /v \":Range\" /t REG_SZ /d \"*.pbc.gov\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range101\" /v \"http\" /t REG_DWORD /d \"00000002\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range101\" /v \":Range\" /t REG_SZ /d \"11.82.177.1\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range102\" /v \"http\" /t REG_DWORD /d \"00000002\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range102\" /v \":Range\" /t REG_SZ /d \"11.82.177.7\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range103\" /v \"http\" /t REG_DWORD /d \"00000002\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range103\" /v \":Range\" /t REG_SZ /d \"11.82.177.4\" /f\r\n" + 
        		"\r\n" + 
        		"@echo \"============================\"\r\n" + 
        		"@echo \" 设置zhuye\"\r\n" + 
        		"@echo \" \"\r\n" + 
        		"@echo off\r\n" + 
        		"reg add \"HKEY_LOCAL_MACHINE\\Software\\Microsoft\\Internet Explorer\\Main\" /v \"Start Page\" /t reg_sz /d \"11.82.177.1\" /f\r\n" + 
        		"reg add \"HKEY_LOCAL_MACHINE\\Software\\Microsoft\\Internet Explorer\\Main\" /v \"Default_Page_URL\" /t reg_sz /d \"11.82.177。1\" /f\r\n" + 
        		"reg add \"HKEY_LOCAL_MACHINE\\Software\\Microsoft\\Internet Explorer\\Main\" /v \"First Home Page\" /t reg_sz /d \"11.82.177.1\" /f\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"@echo \"============================\"\r\n" + 
        		"@echo \" 修改ActiveX 策略\"\r\n" + 
        		"@echo \" \"\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"2001\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"2004\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1400\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1001\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1004\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1200\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1201\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1206\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1208\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1209\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1402\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1405\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"2000\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"2201\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"2300\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"120B\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"2702\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"120A\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"120B\" /t REG_DWORD /d \"00000003\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"2000\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1409\" /t REG_DWORD /d \"00000003\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1806\" /t REG_DWORD /d \"00000000\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"2301\" /t REG_DWORD /d \"00000003\" /f\r\n" + 
        		"reg add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"1809\" /t REG_DWORD /d \"00000003\" /f\r\n" + 
        		"@echo \"============================\"\r\n" + 
        		"@echo \" 注册控件\"\r\n" + 
        		"@echo \" \"\r\n" + 
        		"cd /d \"%~dp0\r\n" + 
        		"regsvr32 /s data\\dsoframer.ocx\r\n" + 
        		"regsvr32 /s data\\TransferCtrl.ocx\r\n"
        		;
        String url = AutoInstall.S+"//data/setup.bat";
        FileWriter fw = null;
        try {
            //生成bat文件
            fw = new FileWriter(url);
            fw.write(cmd);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        return url;
    }
}
