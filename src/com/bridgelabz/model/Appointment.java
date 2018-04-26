package com.bridgelabz.model;

public class Appointment
{
   private int doctorId;
   private String doctorName;
   private int patientId;
   private String patientName;
   private String time;
   
   public int getDoctorId()
   {
      return doctorId;
   }
   public void setDoctorId(int doctorId)
   {
      this.doctorId = doctorId;
   }
   public String getDoctorName()
   {
      return doctorName;
   }
   public void setDoctorName(String doctorName)
   {
      this.doctorName = doctorName;
   }
   public int getPatientId()
   {
      return patientId;
   }
   public void setPatientId(int patientId)
   {
      this.patientId = patientId;
   }
   public String getPatientName()
   {
      return patientName;
   }
   public void setPatientName(String patientName)
   {
      this.patientName = patientName;
   }
   public String getTime()
   {
      return time;
   }
   public void setTime(String time)
   {
      this.time = time;
   }
   
   
}
