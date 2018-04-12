package com.bridgelabz.controllers;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.utility.Utility;

public class Search
{

   private Utility utility;

   public Search()
   {
      utility = Utility.getUtility();
   }

   public void searchDoctor(Map<Integer, Doctor> doctorsList)
   {
      Set<Entry<Integer, Doctor>> doctorSet = doctorsList.entrySet();
      System.out.print("\n                  : 1.Search by Name.");
      System.out.print("\n                  : 2.Search by Id.");
      System.out.print("\n                  : 3.Search by Specialization.");
      System.out.print("\n                  : 4.Search by Availability.");
      System.out.print("\nEnter your choice : ");
      int searchChoice = Integer.parseInt(utility.readLine());
      switch(searchChoice) {
      case 1:
         System.out.print("\nEnter the Name of Doctor including Dr. : ");
         String name = utility.readLine();
         for(Entry<Integer, Doctor> entry : doctorSet) {
            Doctor doctor = entry.getValue();
            if(doctor.getName().equalsIgnoreCase(name)) {
               Display.getInstance().displayDoctor(doctor);
               break;
            }
         }
         break;
      case 2:
         System.out.print("\nEnter the ID of Doctor : ");
         int id = Integer.parseInt(utility.readLine());
         Doctor doctor = doctorsList.get(id);
         Display.getInstance().displayDoctor(doctor);
         break;
      case 3:
         System.out.print("\nEnter the SpecialiZation of Doctor : ");
         String specialization = utility.readLine();
         for(Entry<Integer, Doctor> entry : doctorSet) {
            Doctor doctor2 = entry.getValue();
            if(doctor2.getSpeciality().equalsIgnoreCase(specialization)) {
               Display.getInstance().displayDoctor(doctor2);
            }
         }
         break;
      case 4:
         System.out.print("\nEnter the Availabilty of Doctor : ");
         String availability = utility.readLine();
         for(Entry<Integer, Doctor> entry : doctorSet) {
            Doctor doctor2 = entry.getValue();
            if(doctor2.getAvailability().equalsIgnoreCase(availability)) {
               Display.getInstance().displayDoctor(doctor2);
            }
         }
         break;
      default: System.out.print("\nInvalid Choice!!!");
      }
   }

   public void searchPatient(Map<Integer, Patient> patientsList)
   {
      Set<Entry<Integer, Patient>> set = patientsList.entrySet();
      System.out.print("\n                  : 1.Search by Name.");
      System.out.print("\n                  : 2.Search by Mobile Number.");
      System.out.print("\n                  : 3.Search by Id.");
      System.out.print("\nEnter your choice : ");
      int searchChoice = Integer.parseInt(utility.readLine());
      switch(searchChoice) {
      case 1:
         System.out.print("\nEnter the name of Patient : ");
         String name = utility.readLine();
         for(Entry<Integer, Patient> entry : set) {
            Patient patient = entry.getValue();
            if(patient.getName().equalsIgnoreCase(name)) {
               Display.getInstance().displayPatient(patient);
            }
         }
         break;
      case 2:
         System.out.print("\nEnter the Mobile Number of Patient : ");
         String number = utility.readLine();
         for(Entry<Integer, Patient> entry : set) {
            Patient patient = entry.getValue();
            if(patient.getMobileNumber().equals(number)) {
               Display.getInstance().displayPatient(patient);
               break;
            }
         }
         break;
      case 3:
         System.out.print("\nEnter the ID of Patient : ");
         int id = Integer.parseInt(utility.readLine());
         Patient patient = patientsList.get(id);
         Display.getInstance().displayPatient(patient);
         break;
      default: System.out.print("\nInvalid Choice!!!");
      }
   }
}
