package javachatserverprogramui;

import java.io.*;

class ChatHandlerThread implements Runnable{

	private ChatServer 	server = null;
	private String		ID	= null;
	private DataInputStream streamIn = null;
	private Thread 		thread = null;

	public ChatHandlerThread(ChatServer server, String ID, DataInputStream streamIn){
		this.server = server;
		this.ID = ID;
		this.streamIn = streamIn;
		startCHT();
	}

	public void run(){
		
	}

	public void startCHT()
   	{  if (thread == null)
      {  thread = new Thread(this); 
         thread.start();
      }
   	}

   	public void stop()
   	{  if (thread != null)
      {  thread.stop(); 
         thread = null;
      }
   	}

	public void close() throws IOException
   	{  
      if (streamIn != null)  streamIn.close();
   	}
}
