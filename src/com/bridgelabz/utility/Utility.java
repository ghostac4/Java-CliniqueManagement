package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Utility
{
   private Scanner sc;
   private static Utility utility;
   
   private Utility()
   {
      sc = new Scanner(System.in);
   }
   /**
    * @return integer from console
    */
   public int readInt()
   {
      return sc.nextInt();
   }

   /**
    * @return string from console
    */
   public String readLine()
   {
      return sc.nextLine();
   }
   
   public static Utility getUtility() {
      if(utility == null) {
         utility = new Utility();
         return utility;
      }
      return utility;
   }
   
   public static void writeToFile(String string, String path)
   {
      try(OutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);) {
         bw.write(string);
         bw.flush();
      } catch (Exception e) {

         System.out.print(e.toString());
      }
   }
   
   public static String readFromFile(String path)
   {
      String line = "";
      StringBuilder output = new StringBuilder();
      try(InputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);) {
         while ((line = br.readLine()) != null) {
            output.append(line);
         }
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      return output.toString();
   }
}
