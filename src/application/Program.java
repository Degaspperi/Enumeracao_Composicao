package application;

import entities.HourContract;
import entities.enums.WorkerLevel;
import entities.Department;
import entities.Worker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        System.out.print("Enter department's name:");
        String departmentName = read.next();
        System.out.println("Enter worker data:");
        System.out.print("Name:");
        String workerName = read.next();
        System.out.print("Level: ");
        String workerLevel = read.next();
        System.out.print("Base salary:");
        double workerBaseSalary = read.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName));



        System.out.print("How many contacts to this worker: ");
        int numberContracts = read.nextInt();

        for (int i=0; i<numberContracts; i++){

            System.out.println("Enter contract #"+(i+1)+" data:");
            System.out.print("Date (DD/MM/YYYY): ");
            String dateContract = read.next();
            LocalDate contractDate = LocalDate.parse(dateContract, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Value per hour: ");
            double valuePerHour = read.nextDouble();
            System.out.print("Duration (hour): ");
            int durationHour = read.nextInt();

            HourContract hourContract = new HourContract(contractDate,valuePerHour,durationHour);
            worker.addContract(hourContract);

        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = read.next();

        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Nome: "+worker.getName());
        System.out.println("Department: "+worker.getDepartment().getName());
        System.out.println("Income for "+monthAndYear+": $"+String.format("%.2f", worker.income(year,month)));


    }
}
