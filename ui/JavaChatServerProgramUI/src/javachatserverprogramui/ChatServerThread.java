package javachatserverprogramui;
import java.net.*;
import java.io.*;
import java.util.Vector;
import javax.swing.DefaultListModel;

public class ChatServerThread extends Thread
{  private ChatServer       server    = null;
   private Socket           socket    = null;
   private String              ID     = null;
   private DataInputStream  streamIn  =  null;
   private DataOutputStream streamOut = null;
   private DefaultListModel model = null;
   private ChatServerThread [] clients = null;
   private Boolean handshake = false;
   private int clientCount;
   
   boolean bool;
   public ChatServerThread(ChatServer _server, Socket _socket, DefaultListModel _model, ChatServerThread [] _clients, int _clientCount)
   {  super();
      server = _server;
      socket = _socket;
      model = _model;
      clients = _clients;
      clientCount = _clientCount;
      bool = true;

   }

    ChatServerThread(ChatServer aThis, Socket socket, DefaultListModel model, ChatServerThread[] clients) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
   }
   
   private BufferedReader  console = null;
   
   public String getID()
   {  return ID;
   }
   public void run()
   {
      //ChatHandlerThread cMSG = new ChatHandlerThread(server, ID, streamIn);
      
      if(bool){
          try{
              String cID = streamIn.readUTF();
              //if(!model.contains(cID)){
                  model.addElement(cID);
                  server.updateClientList(model);
              //}
              bool = false;
          }catch (IOException e){
              System.out.println(e.getMessage());
          }
      }
      while(true){
			try{
				String line = streamIn.readUTF();
				if(line.indexOf(".debug") == 0){
                                    for(int i=0; i<model.size(); i++){
                                        System.out.println(i + " " + model.elementAt(i) + " " + clientCount);
                                    }
                                }
				server.handle(ID, line);
			} catch (IOException ioe){
				//try{close();} catch(IOException e){System.out.println(e.getMessage());}
				//stop();

				server.remove(ID);
                                break;
			}
		}

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
