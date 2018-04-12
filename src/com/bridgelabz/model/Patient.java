package com.bridgelabz.model;

public class Patient
{
   private String name;
   private int id;
   private String mobileNumber;
   private int age;

   /**
    * function to get name
    * 
    * @return name is a string
    */
   public String getName()
   {
      return name;
   }

   /**
    * function to set name
    * 
    * @param name is a string
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * function to get id
    * 
    * @return id is number
    */
   public int getId()
   {
      return id;
   }

   /**
    * function to set id
    * 
    * @param id is number
    */
   public void setId(int id)
   {
      this.id = id;
   }

   /**
    * function to get mobile number
    * 
    * @return mobileNumber id a String
    */
   public String getMobileNumber()
   {
      return mobileNumber;
   }

   /**
    * function to set mobile number
    * 
    * @param mobileNumber
    */
   public void setMobileNumber(String mobileNumber)
   {
      this.mobileNumber = mobileNumber;
   }

   public int getAge()
   {
      return age;
   }

   public void setAge(int age)
   {
      this.age = age;
   }
}
