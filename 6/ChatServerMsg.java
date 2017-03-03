import java.io.*;

class ChatServerMsg implements Runnable{

	private ChatServer 	server = null;
	private int 		ID	= -1;
	private BufferedReader streamIn = null;
	private Thread 		thread = null;

	public ChatServerMsg(ChatServer _server, int _ID, BufferedReader _streamIn){
		this.server = _server;
		this.ID = _ID;
		this.streamIn = _streamIn;
		startCSM();
	}

	public void run(){
		while(true){
			try{
				String line = streamIn.readLine();
				//streamIn.flush();
				server.handle(ID, line);

			} catch (IOException ioe){
				server.remove(ID);
	            break;
			}
		}
	}

	public void startCSM()
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
}