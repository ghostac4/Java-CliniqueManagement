package com.bridgelabz.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;

public class Display
{
   private static Display display;
   
   private Display(){}
   
   public static Display getInstance() {
      if(display == null) {
         display = new Display();
         return display;
      }
      return display;
   }
   
   public void displayDoctor(Doctor doctor) {
      System.out.print("\n_______________________Doctor___________________________");
      System.out.print("\n"+doctor.getId()+". "+doctor.getName());
      System.out.print("\n                                               Speciality :"+doctor.getSpeciality());
      System.out.print("\n                                               Availablity :"+doctor.getAvailability());
      System.out.print("\n________________________________________________________");
   }
   
   public void displayPatient(Patient patient) {
      System.out.print("\n_______________________Patient__________________________");
      System.out.print("\n"+patient.getId()+". "+patient.getName());
      System.out.print("\n                                               Mobile Number :"+patient.getMobileNumber());
      System.out.print("\n                                                         Age :"+patient.getAge());
      System.out.print("\n________________________________________________________");
   }
   
   public void displayDoctors(Map<Integer, Doctor> doctorsList) {
      Set<Entry<Integer, Doctor>> entries = doctorsList.entrySet();
      System.out.print("\n_______________________Doctors__________________________");
      for(Entry<Integer, Doctor> entry : entries) {
         Doctor doctor = entry.getValue();
         System.out.print("\n"+entry.getKey()+". "+doctor.getName());
         System.out.print("\n                                               Speciality :"+doctor.getSpeciality());
         System.out.print("\n                                               Availablity :"+doctor.getAvailability());
      }
      System.out.print("\n________________________________________________________");
   }
   
   public void displayPatients(Map<Integer, Patient> patientsList) {
      Set<Entry<Integer, Patient>> entries = patientsList.entrySet();
      System.out.print("\n_______________________Patients_________________________");
      for(Entry<Integer, Patient> entry : entries) {
         Patient patient = entry.getValue();
         System.out.print("\n"+entry.getKey()+". "+patient.getName());
         System.out.print("\n                                               Mobile Number :"+patient.getMobileNumber());
         System.out.print("\n                                                         Age :"+patient.getAge());
      }
      System.out.print("\n________________________________________________________");
   }
   
   public void displayAppointments(List<Appointment> appointments) {
      System.out.print("\n_______________________Appointments_____________________");
      for(Appointment appointment : appointments) {
         System.out.print("\n"+appointment.getDoctorId()+" "+appointment.getDoctorName()
         +"  "+appointment.getPatientId()+" "+appointment.getPatientName()+" "+appointment.getTime());
      }
      System.out.print("\n________________________________________________________");
   }
}
