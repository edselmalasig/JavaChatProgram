/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatprogramui;
import javachatprogramui.ChatClient;
/**
 *
 * @author edsel
 */
public class JavaChatProgramUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      ChatClient client = null;
      JCUI  mjf = null;
      
      if(args.length == 0){
         mjf = new JCUI();
         mjf.setVisible(true);
         //init cc with dialog
         //pass mjf to init cc
         //repaint mjf when handle is done.
         
      }else{
        if (args.length > 1)
           System.out.println("Usage: java ChatClient host port nickname");
        else
            //client = new ChatClient("localhost", 46, "edsel", null);
            client = new ChatClient(args[0], Integer.parseInt(args[1]), args[2], null);
      }
      
    }
    
}
