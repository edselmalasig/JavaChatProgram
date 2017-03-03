import java.io.*;

class ChatServerMsg implements Runnable{

	private ChatServer 	server = null;
	private int 		ID	= -1;
	private BufferedReader streamIn = null;

	public ChatServerMsg(ChatServer server, int ID, BufferedReader streamIn){
		this.server = server;
		this.ID = ID;
		this.streamIn = streamIn;
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
}