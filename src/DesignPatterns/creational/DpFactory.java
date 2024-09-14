package DesignPatterns.creational;

// https://medium.com/@s.shubhamjagatap/mastering-salesforce-design-pattern-factory-abstract-design-pattern-day-4-2d6328bbd8e2
public class DpFactory {

    public static void main(String [] args){
        // Generating a Sales Report
        ReportGenerator.generateReport(new SalesReportFactory());

        // Generating a Financial Report
        ReportGenerator.generateReport(new ExpenseReportFactory());
    }
}

// Report Interface
interface Report {
    void generate();
}

// Concrete Report implementations
class SalesReport implements Report {
    public void generate() {
        System.out.println("Generating Sales Report...");
        // Logic to generate sales report
    }
}

class ExpenseReport implements Report {
    public void generate() {
        System.out.println("Generating Expense Report...");
        // Logic to generate Expense report
    }
}

// Abstract Factory
abstract class ReportFactory {
    public abstract Report createReport();
}

// Concrete Factory implementations
class SalesReportFactory extends ReportFactory {
    public Report createReport() {
        return new SalesReport();
    }
}

class ExpenseReportFactory extends ReportFactory {
    public Report createReport() {
        return new ExpenseReport();
    }
}

// Report Generator
class ReportGenerator {
    public static void generateReport(ReportFactory factory) {
        Report report = factory.createReport();
        report.generate();
    }
}