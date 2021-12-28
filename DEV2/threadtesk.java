package devoir2;

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class threadtesk {
private static final String SERVER_IP = "127.0.0.1";
    private static int SERVER_PORT = 9090;
public class clinent implements Runnable{
public void run() {
for (int i=0; i<10; i++) {
System.out.println("bonjour" + i);
try {
Thread.sleep(1000);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}


public void main(String [] args)
   {
       Socket socket = null;
       PrintWriter out = null;
       BufferedReader in = null;
       Scanner sc;
       String serverResponse = null;
       try {
           socket = new Socket(SERVER_IP, SERVER_PORT);
           out = new PrintWriter(socket.getOutputStream(), true);
           in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           serverResponse = in.readLine(); // reading server reply
           System.out.println(serverResponse);

           sc = new Scanner(System.in);
           do {
               out.println(sc.nextLine()); // sending message to server
               serverResponse = in.readLine(); // reading server reply
               System.out.println("Server response: "+ serverResponse);
           } while (!serverResponse.equals("quit"));
           System.out.println("Server ended connexion ");
           out.println("quit");
       } catch(Exception e){
               System.out.println("Exception occured " + e.getMessage());
       }
       finally {
           try {
               out.close();
               socket.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
}


}


