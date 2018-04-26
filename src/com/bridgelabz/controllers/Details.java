package com.bridgelabz.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.utility.Utility;

public class Details
{

   private static Details details;
   private Utility utility;

   private Details()
   {
      utility = Utility.getUtility();
   }

   public static Details getInstance()
   {
      if (details == null) {
         details = new Details();
         return details;
      }
      return details;
   }

   public void addDoctor(Map<Integer, Doctor> doctorsList, int doctorId)
   {
      Doctor doctor = new Doctor();
      doctor.setId(doctorId + 1);
      System.out.print("\nEnter the name : ");
      doctor.setName(utility.readLine());
      System.out.print("\nEnter Speciality : ");
      doctor.setSpeciality(utility.readLine());
      System.out.print("\nEnter Availability : ");
      doctor.setAvailability(utility.readLine());
      doctorsList.put(doctor.getId(), doctor);
   }

   public void addPatient(Map<Integer, Patient> patientsList, int patientId)
   {
      Patient patient = new Patient();
      patient.setId(patientId + 1);
      System.out.print("\nEnter the name of Patient : ");
      patient.setName(utility.readLine());
      System.out.print("\nEnter the Mobile Number : ");
      patient.setMobileNumber(utility.readLine());
      System.out.print("\nEnter the age : ");
      patient.setAge(Integer.parseInt(utility.readLine()));
      patientsList.put(patient.getId(), patient);
   }

   public void addAppointment(Map<Integer, Doctor> doctorsList, Map<Integer, Patient> patientsList,
         List<Appointment> appointments)
   {
      Display display = Display.getInstance();
      Appointment appointment = new Appointment();
      display.displayDoctors(doctorsList);
      System.out.print("\nEnter the id of Doctor : ");
      Doctor doctor = doctorsList.get(Integer.parseInt(utility.readLine()));
      display.displayPatients(patientsList);
      System.out.print("\nEnter the id of Patient : ");
      Patient patient = patientsList.get(Integer.parseInt(utility.readLine()));
      appointment.setDoctorId(doctor.getId());
      appointment.setDoctorName(doctor.getName());
      appointment.setPatientId(patient.getId());
      appointment.setPatientName(patient.getName());
      appointment.setTime(new Date().toString());
      appointments.add(appointment);
      if (doctor.getNumberOfPatients() == 5) {
         System.out.print("\nAppointment Slot Full. Take appointment tomorrow.");
      } else
         doctor.setNumberOfPatients(doctor.getNumberOfPatients() + 1);
   }
}
