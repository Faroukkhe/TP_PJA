package devoir2;
import java.util.Scanner;

import java.net.*;
import java.io.*;

public class server {

    public static void treatClient(Socket c){
        PrintWriter out = null;
        String clientInput = null;
        BufferedReader input = null;
        try {
            out = new PrintWriter(c.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(c.getInputStream()));
            Scanner sc = new Scanner(System.in);
            out.println("Server Listening on Port 9090 ");

            clientInput = input.readLine();
            while (!clientInput.equals("quit")){
                System.out.println("Client input :"+ clientInput);
                if(clientInput.startsWith("list")) {
                	String FileName= clientInput.substring(4);
                	File currentDir = new File(FileName) ;
                	
					if (!currentDir.exists()) {
                        out.println("ERROR : File/"+FileName+" does not exist");
                        
                        
                    }else {

                    if (!currentDir.isDirectory()) {
                        out.println(FileName + " n'est pas un repertoire");
                        
                    }
                    else {
                        File[] files = currentDir.listFiles();
                        for (int i = 0; i < files.length; i++)
                            if (files[i].isDirectory()) {
                                String packageStatment = "package " + files[i].getName() + ";\r\n";
                                out.println(packageStatment);
                              
                            }
                    }
                    }
                    clientInput = input.readLine();
                };
                if(clientInput.startsWith("get")) {
                	String fishiesName= clientInput.substring(3);
                	File fishier = new File(fishiesName) ;
                	
					if (!fishier.exists()) {
                        out.println("ERROR : File/"+fishiesName+" does not exist");
                        clientInput = input.readLine();
                    }else {
                    	 Scanner myReader = new Scanner(fishier);
                         while (myReader.hasNextLine()) {
                           String data = myReader.nextLine();
                           out.println(data);
                          
                         }
                         myReader.close();
                         clientInput = input.readLine();
                    }
                }
          
            }
            System.out.println("Client disconnected...");
            out.println("quit");
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
                try {
                    input.close();
                    out.close();
                    c.close();
                    System.out.println("Client Socket is closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static void main(String[] args)
    {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("waiting for clients...");

            while (true) {

                Socket socket = serverSocket.accept();
                treatClient(socket);
            }
        } catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }



}

