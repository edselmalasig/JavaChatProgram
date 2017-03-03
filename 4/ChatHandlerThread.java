import java.io.*;

class ChatHandlerThread implements Runnable{

	private ChatServer 	server = null;
	private int 		ID	= -1;
	private DataInputStream streamIn = null;
	private Thread 		thread = null;

	public ChatHandlerThread(ChatServer server, int ID, DataInputStream streamIn){
		this.server = server;
		this.ID = ID;
		this.streamIn = streamIn;
		startCHT();
	}

	public void run(){
		while(true){
			try{
				String line = streamIn.readUTF();

				server.handle(ID, line);
			} catch (IOException ioe){
				//try{close();} catch(IOException e){System.out.println(e.getMessage());}
				//stop();

				server.remove(ID);
	            break;
			}
		}
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