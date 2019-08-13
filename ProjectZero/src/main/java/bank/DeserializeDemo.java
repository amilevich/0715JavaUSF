//package bank;
//import java.io.*;
//import bank.User;
//
//public class DeserializeDemo 
//{
//	   public static void main(String [] args) 
//	   {
//	      User u;
//	      try 
//	      {
//	         FileInputStream fileIn = new FileInputStream("C:\\Users\\minqi\\Desktop\\Revvie\\Spring\\ProjectZero\\src\\main\\resources\\Bank.txt");
//	         ObjectInputStream in = new ObjectInputStream(fileIn);
//	         u = (User) in.readObject();
//	         in.close();
//	         fileIn.close();
//	      } 
//	      catch (IOException i) 
//	      {
//	         i.printStackTrace();
//	         return;
//	      } catch (ClassNotFoundException c) {
//	         System.out.println("User not found");
//	         c.printStackTrace();
//	         return;
//	      }
//	      System.out.println("Deserialized Employee...");
//	      System.out.println("Name: " + u.userName);
//	      System.out.println("Password: " + u.password);
//	      System.out.println("Balance: " + u.balance);
//	      System.out.println("Approval Status: " + u.approved);
//	   }
//}