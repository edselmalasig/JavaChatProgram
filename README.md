# JavaChatProgram
## Client Server peer to peer and group chat.
It includes the client and server program and source file and project files to be used with netbeans IDE. The repository also has the executable jar package to test and use the client and server program.

## Compilation and running the program
Compiling JavaChatProgram needs netbeans 10.0 or above so that you do not have to finagle with a build system and configure the directories and files needed to accomplish the task. A project file is already included that can be opened with netbeans and a simple build and run will generate a jar file that can be executed on the terminal or run through netbeans.

Compile the Java Chat Server Program
The project files at "ui/*/nbproject" can be opened with netbeans 10 and be compiled
or use the command line to run and compile.
<pre>
  cd ui/JavaChatServerProgramUI/src
  javac JavaChatServerProgramUI/*.java
  java javachatserverprogramui.JavaChatServerProgramUI
</pre>

Setup JavaChatServerProgramUI by setting the ports.
You might need to sudo to bind ports in macOS or Linux: sudo java javachatserverprogramui.JavaChatServerProgramUI
Best way to test is to run the server program through a local network by using "localhost" or "127.0.0.1" with any chosen port for example "404".

Note: There is a client and server code. The server program needs to be run through a local network or through the internet given that there are appropriate network permission given to the client and server program.
<pre>
  cd ui/JavaChatProgramUI/src
  javac javachatprogramui/*.java
  java javachatprogramui.JavaChatProgramUI
</pre>

Once the server program us up and running. Run a client program to connect to the server program by using the specified parameters used above and choosing any desired user name.
Once connected you can test the program's feature.

There is a commandline interface as well
<pre>
  cd src/
  javac *.java
</pre>
then run the Chat Server and Chat Client on a different process.
<pre>
  java ChatServer 404
</pre>
<pre>
  java ChatClient 127.0.0.1 404 username
</pre>
and start chatting with the server.


Have fun hacking.
