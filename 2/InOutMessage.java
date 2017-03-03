import java.io.*;

public class InOutMessage implements Runnable{
	String output, userString;
	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = null;

	public InOutMessage(PrintWriter out, String userString){
		this.out = out;
		this.userString = userString;
	}

	static void threadMessage(String message){
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

	public void run () {
		try {
			boolean typing = true;
			while(typing){		    
				this.output = stdIn.readLine();
				if(this.output.equals(".bye") && !userString.equals("Server"))
					break;
				if(this.output != null && this.output.length() > 0){
					threadMessage("from " + userString);
					out.write(userString + ": " + this.output + "\n");
					out.flush();
					continue;
				}
			}
			out.close();
			stdIn.close();
			return;
		}catch (IOException e){
			threadMessage(e.toString());
		}
	}
}

