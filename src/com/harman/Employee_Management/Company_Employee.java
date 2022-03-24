package com.harman.Employee_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Company_Employee {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int option;
        while(true){
            System.out.println("add employee");
            System.out.println("view employee");
            System.out.println("exit");
            System.out.println("enter choice from above menu");
            option=in.nextInt();
            switch (option){
                case 1:
                    try{
                        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/companydbs?autoReconnect=true&useSSL=false","root","");
                        Scanner s = new Scanner(System.in);
                        String empCode, name, phone, email, designation,salary, company, address;
                        System.out.println("Emp_code :");
                        empCode=s.nextLine();
                        System.out.println("Name :");
                        name=s.nextLine();
                        System.out.println("Mobile Number :");
                        phone=s.nextLine();
                        System.out.println("Email :");
                        email=s.nextLine();
                        System.out.println("Designation :");
                        designation=s.nextLine();
                        System.out.println("Salary :");
                        salary=s.nextLine();
                        System.out.println("Company :");
                        company=s.nextLine();
                        System.out.println("Address :");
                        address=s.nextLine();
                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("INSERT INTO `employee`( `empcode`, `name`, `phone`, `email`, `designation`, `salary`, `company`, `address`) VALUES("+empCode+",'"+name+"',"+phone+",'"+email+"','"+designation+"',"+salary+",'"+company+"','"+address+"')");
                        System.out.println("inseted successfully");

                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try
                    {
                        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/companydbs?autoReconnect=true&useSSL=false","root","");
                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("SELECT `id`, `empcode`, `name`, `phone`, `email`, `designation`, `salary`, `company`, `address` FROM `employee`");
                        while(rs.next()){
                            System.out.println("ID:"+rs.getInt("ID"));
                            System.out.println("Employee Code :"+rs.getInt("empCode"));
                            System.out.println("Name :"+rs.getString("name"));
                            System.out.println("Phone :"+rs.getBigDecimal("phone"));
                            System.out.println("Email :"+rs.getString("email"));
                            System.out.println("Designation :"+rs.getString("designation"));
                            System.out.println("Salary :"+rs.getInt("salary"));
                            System.out.println("Company :"+rs.getString("company"));
                            System.out.println("Address :"+rs.getString("address"));
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.exit(0);

                default:
                    System.out.println("invalid option choose coorect option");
                    break;
            }
        }
    }
}
