import java.net.*;
import java.io.*;

public class ChatServerThread extends Thread
{  private ChatServer       server    = null;
   private Socket           socket    = null;
   private int              ID        = -1;
   private DataInputStream  streamIn  =  null;
   private DataOutputStream streamOut = null;
   private BufferedReader  console = null;

   public ChatServerThread(ChatServer _server, Socket _socket)
   {  super();
      server = _server;
      socket = _socket;
      ID     = socket.getPort();
   }
   
   public void send(String msg)
   {   try
       {  streamOut.writeUTF(msg);
          streamOut.flush();
       }
       catch(IOException ioe)
       {  System.out.println(ID + " ERROR sending: " + ioe.getMessage());
          server.remove(ID);
          stop();
       }
   }
   public int getID()
   {  return ID;
   }
   public void run()
   {  System.out.println("Server Thread " + ID + " running.");
   		System.out.println("IN CST run()");
      ChatHandlerThread cMSG = new ChatHandlerThread(server, ID, streamIn);
            Thread cThread = new Thread(cMSG);
      ChatServerMsg sMSG = new ChatServerMsg(server, 0, console);
            Thread sThread = new Thread(sMSG);
      //while (true)
      cThread.start();
      sThread.start();
      /*while(cThread.isAlive() && sThread.isAlive())
      {  
        try{ 
            System.out.println("IN CST run() try");          
            //server.handle(ID, streamIn.readUTF());
            
            //server.handle(0, console.readUTF());
         }
         catch(Exception ioe)
         {  System.out.println(ID + " ERROR reading: " + ioe.getMessage());
            server.remove(ID);
            stop();
         }
         
      }*/
   }
   public void open() throws IOException
   {  streamIn = new DataInputStream(new 
                        BufferedInputStream(socket.getInputStream()));
      streamOut = new DataOutputStream(new
                        BufferedOutputStream(socket.getOutputStream()));
      console = new BufferedReader(new InputStreamReader(System.in));
   }
   public void close() throws IOException
   {  if (socket != null)    socket.close();
      if (streamIn != null)  streamIn.close();
      if (streamOut != null) streamOut.close();
      if (console != null)    console.close();
   }
}
