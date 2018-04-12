/**
 * Purpose : Implementation of CliniqueManagement Application
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 11-04-2018
 */
package com.bridgelabz.controllers;

import com.bridgelabz.utility.Utility;

public class CliniqueManagementApplication
{

   public static void main(String[] args)
   {
      CliniqueManager cliniqueManager = new CliniqueManager();
      Utility utility = Utility.getUtility();
      cliniqueManager.read();
      int choice;
      do {
         System.out.print("\n                 : 1.Add.");
         System.out.print("\n                 : 2.Search.");
         System.out.print("\n                 : 3.Print Report.");
         System.out.print("\n                 : 4.Most Famous Doctor.");
         System.out.print("\n                 : 5.Most Famous Specialization.");
         System.out.print("\n                 : 6.Quit.");
         System.out.print("\nEnter the choice : ");
         choice = Integer.parseInt(utility.readLine());
         
         switch(choice) {
         case 1:
            cliniqueManager.add();
            break;
         case 2:
            cliniqueManager.search();
            break;
         case 3:
            cliniqueManager.display();
            break;
         case 4:
            cliniqueManager.getFamousDoctor();
            break;
         case 5:
            cliniqueManager.getFamousSpecialization();
            break;
         case 6:break;
         default: System.out.print("\nInvalid Choice!!!");
         }
      }while(choice !=6);
      System.out.print("\nProgram Terminated.");
   }

}
