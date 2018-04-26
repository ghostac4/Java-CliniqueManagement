package com.bridgelabz.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.utility.Utility;

public class CliniqueManager
{
   private Utility utility = Utility.getUtility();
   private Map<Integer, Patient> patientsList;
   private Map<Integer, Doctor> doctorsList;
   private List<Appointment> appointments;
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
      List<Patient> patients = new ArrayList<>();
      List<Doctor> doctors = new ArrayList<>();

      Set<Entry<Integer, Patient>> patientSet = patientsList.entrySet();
      for (Entry<Integer, Patient> entry : patientSet)
         patients.add(entry.getValue());

      Utility.writeToFile(writeList(patients), path + "patients.json");

      Set<Entry<Integer, Doctor>> doctorSet = doctorsList.entrySet();
      for (Entry<Integer, Doctor> entry : doctorSet)
         doctors.add(entry.getValue());

      Utility.writeToFile(writeList(doctors), path + "doctors.json");

      Utility.writeToFile(writeList(appointments), path + "appointments.json");
   }

   /**
    * function to read the data from file
    */
   public void read()
   {
      String jsonString = Utility.readFromFile(path + "patients.json");

      List<Patient> patients = new ArrayList<>();
      List<Doctor> doctors = new ArrayList<>();
      patients = readList(jsonString, Patient.class);

      if (!patients.isEmpty()) {
         for (Patient patient : patients) {
            patientId = patient.getId();
            patientsList.put(patient.getId(), patient);
         }
      }

      jsonString = Utility.readFromFile(path + "doctors.json");

      doctors = readList(jsonString, Doctor.class);

      if (!doctors.isEmpty()) {
         for (Doctor doctor : doctors) {
            doctorId = doctor.getId();
            doctorsList.put(doctor.getId(), doctor);
         }
      }

      jsonString = Utility.readFromFile(path + "appointments.json");

      appointments = readList(jsonString, Appointment.class);
   }

   @SuppressWarnings("rawtypes")
   public <T> List<T> readList(String jsonString, Class class1)
   {
      ObjectMapper objectMapper = new ObjectMapper();
      JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, class1);
      List<T> tempList = null;
      try {
         tempList = objectMapper.readValue(jsonString, javaType);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return tempList;
   }

   public <T> String writeList(List<T> list)
   {
      ObjectMapper objectMapper = new ObjectMapper();
      try {
         return objectMapper.writeValueAsString(list);
      } catch (IOException e) {
         e.printStackTrace();
         return null;
      }
   }
}
