package com.bridgelabz.model;

public class Doctor
{
   private String name;
   private int id;
   private String speciality;
   private String availability;
   private int numberOfPatients=0;
   
   public String getName()
   {
      return name;
   }
   public void setName(String name)
   {
      this.name = name;
   }
   public int getId()
   {
      return id;
   }
   public void setId(int id)
   {
      this.id = id;
   }
   public String getSpeciality()
   {
      return speciality;
   }
   public void setSpeciality(String speciality)
   {
      this.speciality = speciality;
   }
   public String getAvailability()
   {
      return availability;
   }
   public void setAvailability(String availability)
   {
      this.availability = availability;
   }
   public int getNumberOfPatients()
   {
      return numberOfPatients;
   }
   public void setNumberOfPatients(int numberOfPatients)
   {
      this.numberOfPatients = numberOfPatients;
   }
   
}
