/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greyproject;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 *
 * @author farag
 */
public class SSHDemoBean {
    private JSch mJschSSH = null;
    private Session mSessionSSH = null;
    private Channel mSSHChannel = null;
    
    public boolean openConnection(String strhost, int iport, String strusername, String strpassword, int itimeout){
        boolean blresult = false;
        this.mJschSSH = new JSch();
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        this.mJschSSH.setConfig(config);
        try {
        this.mSessionSSH = this.mJschSSH.getSession(strusername, strhost, iport);
        this.mSessionSSH.setPassword(strpassword);
        this.mSessionSSH.connect(itimeout);
        
        this.mSSHChannel = this.mSessionSSH.openChannel("shell");
        this.mSSHChannel.connect();
        blresult = true;
        }
        catch (Exception exp){
            exp.printStackTrace();
        }
        return blresult;
    }
    
    public boolean sendCommand(String strCommand){
        boolean blresult = false;
        
        try{
            if(this.mSSHChannel != null){
                this.mSSHChannel.getOutputStream().write(strCommand.getBytes());
                this.mSSHChannel.getOutputStream().flush();
            }
        }
        catch(Exception exp){
            exp.printStackTrace();
        }
        return blresult;
    }
    
    public String recvData(){
        String strData ="";
        
        
        try{
            if(this.mSSHChannel != null && this.mSSHChannel.getInputStream().available() > 0){
                int iAvailable = this.mSSHChannel.getExtInputStream().available();
                while(iAvailable > 0){
                    byte[] btBuffer = new byte[iAvailable];
                    
                    int iByteRead = this.mSSHChannel.getInputStream().read(btBuffer);
                    
                    iAvailable = iAvailable - iByteRead;
                    strData += String.valueOf(btBuffer);
                }
            }
        }
        catch(Exception exp){
            exp.printStackTrace();
        }
        return strData;
    }
    
    public void close(){
        if (this.mSessionSSH != null){
        this.mSessionSSH.disconnect();
        }
        if (this.mSSHChannel != null){
        this.mSSHChannel.isClosed();
        }
        this.mJschSSH =null;
    }
}
