package com.example.demo_cat.demo;

import com.example.demo_cat.entity.Student;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapHandler {
     public static void main(String[] args) {
          generateMenu();
     }
     static HashMap<String, Student> listHash= new HashMap<>();
     public static void generateMenu(){
          Scanner scanner=new Scanner(System.in);
          while (true){
               System.out.println("Student Manager");
               System.out.println("---------------");
               System.out.println("1.Add student");
               System.out.println("2.Find student");
               System.out.println("3.Exit");
               System.out.println("---------------");
               System.out.println("Please enter the choice:");
               int choice = scanner.nextInt();
               scanner.nextLine();
               switch (choice){
                    case 1:
                         addStudent();
                         break;
                    case 2:
                         findStudent();
                         break;
                    case 3:
                         System.out.println("Quit program");
                         break;
                    default:
                         System.out.println("Invalid Choice");
                         break;
               }
               System.out.println("Enter to continue");
               scanner.nextLine();
               if (choice==3){
                    System.exit(1);
               }

          }
     }

     private static void findStudent() {
          System.out.println("Enter rollNumber to find:");
          Scanner scanner = new Scanner(System.in);
          String rollNumber = scanner.nextLine();
          if(!listHash.containsKey(rollNumber)){
               System.out.println("Student not found!");
               return;
          }
          Student st = listHash.get(rollNumber);
          System.out.println("Student info:");
          System.out.println(st.toString());

     }

     private static void addStudent() {
          Scanner scanner=new Scanner(System.in);
          System.out.println("Enter the rollNumber:");
          String rollNumber= scanner.nextLine();
           System.out.println("Enter the email:");
          String email= scanner.nextLine();
           System.out.println("Enter the name:");
          String name= scanner.nextLine();
          Student st = new Student(rollNumber,email,name);
          st.setStatus(1);
          listHash.put(rollNumber,st);
          System.out.println("Action success");
     }

}
