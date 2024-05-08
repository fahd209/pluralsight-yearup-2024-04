package com.pluralsight;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private boolean isClockedIn;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay()
    {
        double totalPay = 0;
        double regularHoursWorked = getHoursWorked();
        double overTimePay = payRate * 1.5;
        totalPay = regularHoursWorked * payRate + (getOverTimeHours() * overTimePay);

        return totalPay;
    }

    public double getOverTimeHours()
    {
        return getHoursWorked() > 40 ? getHoursWorked() - 40 : 0;
    }

    public double getRegularHours()
    {
        return getHoursWorked() - getOverTimeHours();
    }

    public void punchTimeCard(double time)
    {
        if(!isClockedIn)
        {
            System.out.println("clocked in at " + time);
            this.isClockedIn = true;
        }
        else
        {
            System.out.println("Clocked out at " + time);
            this.isClockedIn = false;
        }
    }

    public void punchIn(double time)
    {
        System.out.println("Clocked in at " + time);
    }

    public void punchOut(double time)
    {
        System.out.println("Clocked out at: " + time);
    }

    public void punchIn()
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime currentTime = LocalTime.now();
        System.out.println("Clocked in at " + currentTime.format(format));

    }

    public void punchOut()
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime currentTime = LocalTime.now();
        System.out.println("Clocked out at " + currentTime.format(format));
    }
}
