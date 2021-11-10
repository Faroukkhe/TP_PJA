import java.io.*;
import java.io.RandomAccessFile;  
public class Class2

{
	static final String FILEPATH ="empdirect.dat";  

   public static void main(String [] args)
   {
      Employee e = new Employee();
            try
      {
         FileInputStream fileIn = new FileInputStream("emp.dat");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("classe Employee non trouvee");
         c.printStackTrace();
         return;
      }
      try
      {
    	  writeToFile(FILEPATH, e, 0);  
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }

      
    }

    private static void writeToFile(String filePath, Employee data, int position)  
            throws IOException {  
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");  
        file.seek(position);
        file.writeUTF(data.name); 
        file.writeUTF(data.address); 
        file.write(data.SSN); 
        file.write(data.number);  
        file.close();  
    }  
}
