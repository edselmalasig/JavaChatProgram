/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatserverprogramui;

/**
 *
 * @author edsel
 */
public class JavaChatServerProgramUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      if (args.length != 1){
          JSUI mjf = new JSUI();
          mjf.show(true);
      }
         
      else{
          System.out.println("Usage: java ChatServer port");
            
          //new ChatServer(Integer.parseInt(args[0]),mjf);
    
      }
    }
   
    
}
