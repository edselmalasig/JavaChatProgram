import java.io.*;

class ChatHandlerThread implements Runnable{

	private ChatServer 	server = null;
	private int 		ID	= -1;
	private DataInputStream streamIn = null;

	public ChatHandlerThread(ChatServer server, int ID, DataInputStream streamIn){
		this.server = server;
		this.ID = ID;
		this.streamIn = streamIn;
	}

	public void run(){
		while(true){
			try{
				String line = streamIn.readUTF();
				server.handle(ID, line);
			} catch (IOException ioe){
				server.remove(ID);
	            break;
			}
		}
	}
}