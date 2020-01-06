import java.net.*;
import java.io.*;

public class ChatServerThread extends Thread
{  private ChatServer       server    = null;
   private Socket           socket    = null;
   private String              ID     = null;
   private DataInputStream  streamIn  =  null;
   private DataOutputStream streamOut = null;
   private Boolean handshake = false;

   public ChatServerThread(ChatServer _server, Socket _socket)
   {  super();
      server = _server;
      socket = _socket;
   }
   
   public void send(String msg)
   {   try
       {  streamOut.writeUTF(msg);
          streamOut.flush();
       }
       catch(IOException ioe)
       {  System.out.println(ID + " ERROR sending: " + ioe.getMessage());
          server.remove(ID);
       }
   }private BufferedReader  console = null;
   public String getID()
   {  return ID;
   }
   public void run()
   {
      ChatHandlerThread cMSG = new ChatHandlerThread(server, ID, streamIn);

   }
   public void open() throws IOException
   {  streamIn = new DataInputStream(new 
                        BufferedInputStream(socket.getInputStream()));
      streamOut = new DataOutputStream(new
                        BufferedOutputStream(socket.getOutputStream()));
      //console = new BufferedReader(new InputStreamReader(System.in));
      try{
        if(!handshake){
          this.ID = streamIn.readUTF();

          handshake = true;
        }
      } catch(IOException ioe){
          System.out.println(ioe.getMessage());
      }
   }
   public void close() throws IOException
   {  if (socket != null)    socket.close();
      if (streamIn != null)  streamIn.close();
      if (streamOut != null) streamOut.close();
   }
}
