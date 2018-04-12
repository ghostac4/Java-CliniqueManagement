package com.bridgelabz.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import com.bridgelabz.model.Appointments;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.utility.Utility;

public class CliniqueManager
{
   private Utility utility = Utility.getUtility();
   private Map<Integer, Patient> patientsList;
   private Map<Integer, Doctor> doctorsList;
   private List<Appointments> appointments;
   private int doctorId = 100;
   private int patientId = 1000;
   private String path = "/home/bridgeit/eclipse-workspace/Java CliniqueManagement/src/com/bridgelabz/utility/";

   /**
    * constructor from cliniqueManager
    */
   public CliniqueManager()
   {
      patientsList = new HashMap<>();
      doctorsList = new HashMap<>();
      appointments = new ArrayList<>();
   }

   /**
    * function to add doctor patient and take appointment
    */
   public void add()
   {
      Details details = Details.getInstance();
      System.out.print("\n                  : 1.Add Doctor.");
      System.out.print("\n                  : 2.Add Patient.");
      System.out.print("\n                  : 3.Take Appointment.");
      System.out.print("\nEnter your choice : ");
      int choice = Integer.parseInt(utility.readLine());
      if (choice == 1) {
         details.addDoctor(doctorsList, doctorId);
         save();
      } else if (choice == 2) {
         details.addPatient(patientsList, patientId);
         save();
      } else {
         details.addAppointment(doctorsList, patientsList, appointments);
         save();
      }

   }

   /**
    * function to search doctor and patient
    */
   public void search()
   {
      Search search = new Search();
      System.out.print("\n                  : 1.Search Doctor.");
      System.out.print("\n                  : 2.Search Patient.");
      System.out.print("\nEnter your choice : ");
      int choice = Integer.parseInt(utility.readLine());
      if (choice == 1) {
         search.searchDoctor(doctorsList);
      } else {
         search.searchPatient(patientsList);
      }
   }

   /**
    * function to display report
    */
   public void display()
   {
      Display.getInstance().displayAppointments(appointments);
   }

   /**
    * function to display famous doctor
    */
   public void getFamousDoctor()
   {
      int max = 0;
      String doctorName = "";
      Set<Entry<Integer, Doctor>> doctorSet = doctorsList.entrySet();
      for (Entry<Integer, Doctor> entry : doctorSet) {
         if (max == 0)
            doctorName = entry.getValue().getName();
         int max1 = entry.getValue().getNumberOfPatients();
         if (max1 > max) {
            max = max1;
            doctorName = entry.getValue().getName();
         }
      }
      System.out.print("\nFamous Doctor : " + doctorName);
   }

   /**
    * function to display famous specialization
    */
   public void getFamousSpecialization()
   {
      int max = 0;
      String speciality = "";
      Set<Entry<Integer, Doctor>> doctorSet = doctorsList.entrySet();
      for (Entry<Integer, Doctor> entry : doctorSet) {
         if (max == 0)
            speciality = entry.getValue().getSpeciality();
         int max1 = entry.getValue().getNumberOfPatients();
         if (max1 > max) {
            max = max1;
            speciality = entry.getValue().getSpeciality();
         }
      }
      System.out.print("\nFamous Speciality : " + speciality);
   }

   /**
    * function to save data
    */
   public void save()
   {
      ObjectMapper objectMapper = new ObjectMapper();

      String jsonString = "";
      List<Patient> patients = new ArrayList<>();
      List<Doctor> doctors = new ArrayList<>();
      try {
         Set<Entry<Integer, Patient>> patientSet = patientsList.entrySet();
         for (Entry<Integer, Patient> entry : patientSet) {
            patients.add(entry.getValue());
         }
         jsonString = objectMapper.writeValueAsString(patients);
      } catch (IOException e) {
         e.printStackTrace();
      }
      Utility.writeToFile(jsonString, path + "patients.json");

      try {
         Set<Entry<Integer, Doctor>> doctorSet = doctorsList.entrySet();
         for (Entry<Integer, Doctor> entry : doctorSet) {
            doctors.add(entry.getValue());
         }
         jsonString = objectMapper.writeValueAsString(doctors);
      } catch (IOException e) {
         e.printStackTrace();
      }
      Utility.writeToFile(jsonString, path + "doctors.json");

      try {
         jsonString = objectMapper.writeValueAsString(appointments);
      } catch (IOException e) {
         e.printStackTrace();
      }
      Utility.writeToFile(jsonString, path + "appointments.json");
   }

   /**
    * function to read the data from file
    */
   public void read()
   {
      String jsonString = Utility.readFromFile(path + "patients.json");

      ObjectMapper objectMapper = new ObjectMapper();
      List<Patient> patients = null;
      List<Doctor> doctors = null;
      try {
         patients = objectMapper.readValue(jsonString, new TypeReference<List<Patient>>() {
         });
      } catch (IOException e) {
         e.printStackTrace();
      }

      if (patients == null) {
         patients = new ArrayList<>();
      }
      if (!patients.isEmpty()) {
         for (Patient patient : patients) {
            patientId = patient.getId();
            patientsList.put(patient.getId(), patient);
         }
      }

      jsonString = Utility.readFromFile(path + "doctors.json");

      try {
         doctors = objectMapper.readValue(jsonString, new TypeReference<List<Doctor>>() {
         });
      } catch (IOException e) {
         e.printStackTrace();
      }

      if (doctors == null) {
         doctors = new ArrayList<>();
      }
      if (!doctors.isEmpty()) {
         for (Doctor doctor : doctors) {
            doctorId = doctor.getId();
            doctorsList.put(doctor.getId(), doctor);
         }
      }

      jsonString = Utility.readFromFile(path + "appointments.json");

      try {
         appointments = objectMapper.readValue(jsonString, new TypeReference<List<Appointments>>() {
         });
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
