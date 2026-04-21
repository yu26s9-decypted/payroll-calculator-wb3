package model;

public class Employee {
    int employeeId;
    String name;
    double hoursWorked;
    double payRate;

    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked(double hoursWorked) {
        return this.hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate(double payRate) {
        return this.payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;

    }

    public static double getGrossPay(double payRate, double hoursWorked) {
        double wage = payRate * hoursWorked;
        return wage;
    }


    public String toString() {
        return "Employee: " +
                "employee_id =" + this.employeeId +
                "employee_name = " + this.name +
                "hours_worked =" + this.hoursWorked +
                "payrate =" + this.payRate;
    }



}


