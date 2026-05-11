package Projects;
import java.util.Scanner;

class Employee {

    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: ₹" + salary);
    }
}

// Full Time Employee
class FullTimeEmployee extends Employee {

    private double bonus;

    public FullTimeEmployee(String name, int id, double salary, double bonus) {

        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Bonus: ₹" + bonus);
        System.out.println("Total Salary: ₹" + (salary + bonus));
    }
}

// Part Time Employee
class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id,
                             int hoursWorked, double hourlyRate) {

        super(name, id, 0);

        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void displayDetails() {

        double totalSalary = hoursWorked * hourlyRate;

        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: ₹" + hourlyRate);
        System.out.println("Total Salary: ₹" + totalSalary);
    }
}
public class Payroll {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE PAYROLL SYSTEM =====");
            System.out.println("1. Add Full Time Employee");
            System.out.println("2. Add Part Time Employee");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Enter Employee Name: ");
                    String ftName = sc.nextLine();

                    System.out.print("Enter Employee ID: ");
                    int ftId = sc.nextInt();

                    System.out.print("Enter Salary: ");
                    double ftSalary = sc.nextDouble();

                    System.out.print("Enter Bonus: ");
                    double bonus = sc.nextDouble();

                    FullTimeEmployee emp1 =
                        new FullTimeEmployee(ftName, ftId,
                                              ftSalary, bonus);

                    System.out.println("\n===== EMPLOYEE DETAILS =====");
                    emp1.displayDetails();

                    break;

                case 2:

                    System.out.print("Enter Employee Name: ");
                    String ptName = sc.nextLine();

                    System.out.print("Enter Employee ID: ");
                    int ptId = sc.nextInt();

                    System.out.print("Enter Hours Worked: ");
                    int hours = sc.nextInt();

                    System.out.print("Enter Hourly Rate: ");
                    double rate = sc.nextDouble();

                    PartTimeEmployee emp2 =
                        new PartTimeEmployee(ptName, ptId,
                                              hours, rate);

                    System.out.println("\n===== EMPLOYEE DETAILS =====");
                    emp2.displayDetails();

                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while(choice != 3);

        sc.close();
    }
}
