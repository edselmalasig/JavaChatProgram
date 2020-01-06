package javachatprogramui;

import java.net.*;
import java.io.*;
import javax.swing.DefaultListModel;

public class ChatClientThread extends Thread
{  private Socket           socket   = null;
   private ChatClient       client   = null;
   private DataInputStream  streamIn = null;
   private DefaultListModel model   = null;
   
   
   public ChatClientThread(ChatClient _client, Socket _socket, DefaultListModel _model)
   {  client   = _client;
      socket   = _socket;
      model    = _model;
      open(); 
      start(); //ChatClientThread run()
   }
   public void open()
   {  try
      {  streamIn  = new DataInputStream(socket.getInputStream());
      }
      catch(IOException ioe)
      {  System.out.println("Error getting input stream: " + ioe);
         client.stop();
      }
   }
   public void close()
   {  try
      {  if (streamIn != null) streamIn.close();
      }
      catch(IOException ioe)
      {  System.out.println("Error closing input stream: " + ioe);
      }
   }
   public void run()
   { 
   while (true)
      {  try
         {  
             String line = streamIn.readUTF();
             if(line.indexOf(".nick") == 0){
                 if(line.indexOf("add") == 6){
                     if(!model.contains(line.substring(10)))
                         model.addElement(line.substring(10));
                 }
                 if(line.indexOf("remove") == 6){
                     if(!model.contains(line.substring(10)))
                         model.removeElement(line.substring(10));
                 }
                 continue;
             }
             client.handle(line);
         }
         catch(IOException ioe)
         {  System.out.println("Listening error: " + ioe.getMessage());
            client.stop();
         }
      }
   }
}
