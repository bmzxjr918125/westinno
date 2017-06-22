package test;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Presence;

public class Test {
   public static void main(String[] args) {
	     ConnectionConfiguration config = new ConnectionConfiguration("127.0.0.1",5222);
		 XMPPConnection connection = new XMPPConnection(config);
		               try {
							 connection.connect();
							 AccountManager amgr = connection.getAccountManager();

							 amgr.createAccount("aaaa1","111111");
							  // Load the user's roster object
							 connection.login("aaaa1","111111"); 
							 Presence presence = connection.getRoster().getPresence("aaaa1");
					           if(presence.isAvailable()){
					                   System.out.println("1");
					           } else {
					        	       System.out.println("2");
					           }
					         
							 Roster roster=connection.getRoster();
				             roster.createEntry("10001@192.168.2.101","",new String[]{});
				            //amgr.deleteAccount();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
    } 
}
