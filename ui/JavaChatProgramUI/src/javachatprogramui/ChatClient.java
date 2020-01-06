package javachatprogramui;

import java.net.*;
import java.io.*;
import javax.swing.DefaultListModel;

public class ChatClient implements Runnable
{  private Socket socket              = null;
   private Thread thread              = null;
   private DataInputStream  console   = null;
   public DataOutputStream streamOut = null;
   private ChatClientThread client    = null;
   public String ID                  = null;
   public String msg;
   private JCUI mjf = null;
   public DefaultListModel model = new DefaultListModel();
   
   public ChatClient(String serverName, int serverPort, String ID, JCUI mjf)
   {  System.out.println("Establishing connection. Please wait ...");
      try
      {  socket = new Socket(serverName, serverPort);
         System.out.println("Connected: " + socket);
         this.ID = ID;
         this.mjf = mjf;
         startCC();
      }
      catch(UnknownHostException uhe)
      {  System.out.println("Host unknown: " + uhe.getMessage()); }
      catch(IOException ioe)
      {  System.out.println("Unexpected exception: " + ioe.getMessage()); }
   }

@Override
   public void run()
   {  
    if(mjf == null){
    while (thread != null)
      {  try
         {  
         	
            streamOut.writeUTF(console.readLine());               
            streamOut.flush();
         }
         catch(IOException ioe)
         {  System.out.println("Sending error: " + ioe.getMessage());
            stop();
         }
      }
    }
         
   }
   
   public String getID(){
       return this.ID;
   }

   public void handle(String msg)
   {  if (msg.equals(".bye"))
      {  System.out.println("Good bye. Press RETURN to exit ...");
         stop();
      }
      else{
       if(mjf == null)
          System.out.println(msg);
       else
          mjf.get_ta_server().append(msg + "\n");
      }
   }

   public void startCC() throws IOException
   {  console   = new DataInputStream(System.in);
      streamOut = new DataOutputStream(socket.getOutputStream());
      
      
      if (thread == null)
      {  client = new ChatClientThread(this, socket, model);
         thread = new Thread(this);                   
         thread.start(); //ChatClient run()
      }
      
      streamOut.writeUTF(ID);
      streamOut.flush();
      streamOut.writeUTF(ID);
      streamOut.flush();
   }

   public void stop()
   {  if (thread != null)
      {  thread.stop();  
         thread = null;
      }
      try
      {  if (console   != null)  console.close();
         if (streamOut != null)  streamOut.close();
         if (socket    != null)  socket.close();
      }
      catch(IOException ioe)
      {  System.out.println("Error closing ..."); }
      client.close();  
      client.stop();
   }
/*
   public static void main(String args[])
   {  ChatClient client = null;
      if (args.length != 3)
         System.out.println("Usage: java ChatClient host port nickname");
      else
          new ChatClient(args[0], Integer.parseInt(args[1]), args[2]);
   }
*/
}
