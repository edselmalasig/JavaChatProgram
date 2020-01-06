package javachatserverprogramui;

import java.net.*;
import java.io.*;
import java.util.Vector;
import javax.swing.DefaultListModel;

public class ChatServer implements Runnable
{  private ChatServerThread clients[] = new ChatServerThread[50];
   private ServerSocket server = null;
   private Thread       thread = null;
   public int clientCount = 0;
   private BufferedReader  console = null;
   public Vector<String> clientVect = null;
   public JSUI mjf = null;
   public DefaultListModel model = new DefaultListModel();
   
   public ChatServer(int port, JSUI mjf)
   {  
      try
      {  System.out.println("Binding to port " + port + ", please wait  ...");
         server = new ServerSocket(port);
         this.mjf = mjf;
         System.out.println("Server started: " + server);
         startCS(); }
      catch(IOException ioe)
      {  System.out.println("Can not bind to port " + port + ": " + ioe.getMessage()); }
   }
   
   public ChatServer(int port)
   {  
      try
      {  System.out.println("Binding to port " + port + ", please wait  ...");
         server = new ServerSocket(port);

         System.out.println("Server started: " + server);
         startCS(); }
      catch(IOException ioe)
      {  System.out.println("Can not bind to port " + port + ": " + ioe.getMessage()); }
   }
   
   public void run()
   {  while (thread != null)
      {  try
         {  System.out.println("Waiting for a client ..."); 
            addThread(server.accept()); }
         catch(IOException ioe)
         {  System.out.println("Server accept error: " + ioe); stop(); }
      }
   }
   
   public void startCS()
   {  if (thread == null)
      {  thread = new Thread(this); 
         thread.start();
      }
      
      console = new BufferedReader(new InputStreamReader(System.in));
      ChatServerMsg sMSG = new ChatServerMsg(this, "Server", console);
   }

   public void stop()
   {  if (thread != null)
      {  thread.stop(); 
         thread = null;
      }
   }
   private int findClient(String ID)
   {  for (int i = 0; i < clientCount; i++)
         if (clients[i].getID().equals(ID))
            return i;
      return -1;
   }


   public synchronized void handle(String ID, String input)
   {  String sMsg = "";
   		if(input.equals(".bye") && ID.equals("Server")){
   			if(clientCount > 0)
   				remove(ID);
   			this.stop();
   			System.exit(0);	
   		}
   		if (input.equals(".bye"))
        {  clients[findClient(ID)].send(".bye");
         	remove(ID); }
      else
         for (int i = 0; i < clientCount; i++){
			
			   clients[i].send(ID + ": " + input);
			   
         }
         if(input != null && input.length() > 0)
         System.out.println(ID + ": " + input);
         mjf.get_ta_server().append(ID + ": " +input + "\n");
                 
   }
  
      public synchronized void updateClientList(DefaultListModel vecclients){
          System.out.println("updating client list.");
       for(int i=0; i < clientCount; i++){
           for(int ii=0; ii < vecclients.size(); ii++){
               clients[i].send(".nick add " + vecclients.elementAt(ii));
               System.out.println(i + " " + ii + " " + vecclients.elementAt(ii) + " " + vecclients.size());
           }
       }
   }
   
   public synchronized void remove(String ID)
   {  int pos = findClient(ID);
      if (pos >= 0)
      {  ChatServerThread toTerminate = clients[pos];
         model.removeElementAt(pos);
         System.out.println("Removing client thread " + ID + " at " + pos);
         if (pos < clientCount-1)
            for (int i = pos+1; i < clientCount; i++)
               clients[i-1] = clients[i];
         clientCount--;
         try
         {  toTerminate.close(); }
         catch(IOException ioe)
         {  System.out.println("Error closing thread: " + ioe); }
         toTerminate.stop(); }
   }

   private void addThread(Socket socket)
   {  if (clientCount < clients.length)
      {  
       System.out.println("Client accepted: " + socket);
         clients[clientCount] = new ChatServerThread(this, socket, model, clients, clientCount);
         try
         {  clients[clientCount].open();
            clients[clientCount].start();  
            clientCount++; //}
         }catch(IOException ioe)
         {  System.out.println("Error opening thread: " + ioe); } 
      }
      else
         System.out.println("Client refused: maximum " + clients.length + " reached.");
   }
   /*
   public static void main(String args[])
   {  ChatServer server = null;
      zz
   }
   */
   
   public ChatServerThread[] get_cht(){
       return clients;
   }
}

