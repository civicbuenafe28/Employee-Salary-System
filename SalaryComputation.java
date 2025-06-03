/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalActivity2;

/**
 *
 * @author Civic
 */

import java.util.ArrayList;
import java.util.List;

// Base Deduction Interface
interface Deduction {
    double compute(double grossSalary);
}

// SSS Deduction Class
class SSSDeduction implements Deduction {
    @Override
    public double compute(double grossSalary) {
        return grossSalary * 0.11;
    }
}

// PagIbig Deduction Class
class PagIbigDeduction implements Deduction {
    @Override
    public double compute(double grossSalary) {
        return grossSalary * 0.02;
    }
}

// PhilHealth Deduction Class
class PhilHealthDeduction implements Deduction {
    @Override
    public double compute(double grossSalary) {
        return grossSalary * 0.035;
    }
}

// Main SalaryComputation Class
public class SalaryComputation {
    private final List<Deduction> deductions;

    // Constructor to initialize available deductions
    public SalaryComputation() {
        deductions = new ArrayList<>();
        deductions.add(new SSSDeduction());
        deductions.add(new PagIbigDeduction());
        deductions.add(new PhilHealthDeduction());
    }

    // Overloaded method to calculate gross salary
    public double calculateGrossSalary(double hoursWorked, double amountPerHour) {
        return hoursWorked * amountPerHour;
    }

    public double calculateGrossSalary(double hourlyRate, double hoursWorked, double bonuses) {
        return (hourlyRate * hoursWorked) + bonuses;
    }

    // Overloaded method to calculate total deductions
    public double calculateTotalDeductions(double grossSalary) {
        double totalDeductions = 0;
        for (Deduction deduction : deductions) {
            totalDeductions += deduction.compute(grossSalary);
        }
        return totalDeductions;
    }

    public double calculateTotalDeductions(double grossSalary, List<Deduction> specificDeductions) {
        double totalDeductions = 0;
        for (Deduction deduction : specificDeductions) {
            totalDeductions += deduction.compute(grossSalary);
        }
        return totalDeductions;
    }

    // Method to calculate net salary
    public double calculateNetSalary(double grossSalary, double totalDeductions) {
        return grossSalary - totalDeductions;
    }

    // Example method to add custom deductions
    public void addCustomDeduction(Deduction deduction) {
        deductions.add(deduction);
    }
}


