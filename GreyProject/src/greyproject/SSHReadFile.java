package greyproject;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.*;
import java.io.InputStream;
import java.util.Properties;
 
import com.jcraft.jsch.ChannelExec;
import java.sql.SQLException;

/**
 *
 * @author World
 */
public class SSHReadFile
    {
    public static void main(String[] args) {

    
        try{
        Connexion con = new Connexion("Thomas", "25041962", "root", "");
        
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace(); 
        }
      }
    }