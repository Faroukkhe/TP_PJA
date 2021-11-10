import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Class1
{
   public static Scanner a;
   public static Scanner m;
   public static int n;
   public static Scanner b;
   public static Scanner c;
   public static Scanner d;

public static void main(String [] args)
   {
	 System.out.printf("how many empoyee you will put ");
	 m = new Scanner(System.in);
	 n = m.nextInt();
	 
	ArrayList<Employee> employee = new ArrayList<Employee>();
	  
	for (int i=0;i<n;i++) {
		Employee e = new Employee();
      a = new Scanner(System.in);
      b = new Scanner(System.in);
      c = new Scanner(System.in);
      d = new Scanner(System.in);
      System.out.printf("name :  ");
	e.name = a.next();
	System.out.printf("address :  ");
    e.address = b.next();
    System.out.printf("ssn :  ");
    e.SSN = c.nextInt();
    System.out.printf("number :  ");
    e.number = d.nextInt();
    employee.add(e);
	}
      
      try
      {
         FileOutputStream fileOut =
         new FileOutputStream("emp.dat");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(employee);
        
         out.close();
         fileOut.close();
         System.out.printf("donnees serialisees sauvegardees dans emp.dat \n");
         for (Employee model :employee) {
             System.out.println(model.name);
         }
      }catch(IOException i)
      {
          i.printStackTrace();
      }
   }
}
