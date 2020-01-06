import java.io.*;

class ChatServerMsg implements Runnable{

	private ChatServer 	server = null;
	private String		ID	= null;
	private BufferedReader streamIn = null;
	private Thread 		thread = null;

	public ChatServerMsg(ChatServer _server, String _ID, BufferedReader _streamIn){
		this.server = _server;
		this.ID = _ID;
		this.streamIn = _streamIn;
		startCSM();
	}

	public void run(){
		boolean bool = true;
		while(bool){
			try{
				System.out.println("()()()");
				String line = streamIn.readLine();
				if(line.equals(".bye")){
				System.out.println("bye");
					bool = false;
				} 
				server.handle(ID, line);

			} catch (IOException ioe){
				server.remove(ID);
	            break;
	        }
		}
		try{
			streamIn.close();
		} catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		//server.stop();
		stop();
		return;
		
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
