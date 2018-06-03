import entity.Lector;
import exception.DepartmentNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

// Class with methods to provide console interface
public class ConsoleService {

    private UniversityDAO universityDAO;

    private String welcomeMessage = "Welcome to the University Service. Please, choose an option:\n";

    private String options = " ---1. Who is the head of department?" +
            "\n ---2. Show department statistic." +
            "\n ---3. Show the average salary for department." +
            "\n ---4. Show employees amount for department." +
            "\n ---5. Global search by keyword." +
            "\n ---6. Exit" +
            "\n \n Please, input the No of an option: ";

    private String breakline = "-----------------------------------------------------\n";

    public ConsoleService(UniversityDAO universityDAO) {
        this.universityDAO = universityDAO;
    }

    // Method to start the console interface
    public void start() throws IOException {
        System.out.println(welcomeMessage);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println(breakline + options);
            String input = reader.readLine(); // Read the No of command to execute
            switch (input) {
                case "1":
                    System.out.println("Enter the name of the department: ");
                    String searchQuery = reader.readLine();
                    System.out.println("\n" + getDepartmentHead(searchQuery) + "\n");
                    break;
                case "2":
                    System.out.println("Enter the name of the department: ");
                    searchQuery = reader.readLine();
                    System.out.println("\n" + getDepartmentStatistic(searchQuery) + "\n");
                    break;
                case "3":
                    System.out.println("Enter the name of the department: ");
                    searchQuery = reader.readLine();
                    System.out.println("\n" + getDepartmentAverageSalary(searchQuery) + "\n");
                    break;
                case "4":
                    System.out.println("Enter the name of the department: ");
                    searchQuery = reader.readLine();
                    System.out.println("\n" + getNumberOfDepartmentEmployees(searchQuery) + "\n");
                    break;
                case "5":
                    System.out.println("Enter the keyword: ");
                    searchQuery = reader.readLine();
                    System.out.println("\n" + doGlobalSearch(searchQuery) + "\n");
                    break;
                case "6":
                    reader.close();
                    return;
            }
        }
    }

    public String getDepartmentHead(String departmentName) {
        StringBuilder result = new StringBuilder("### Answer: ");           // String to return
        try {
            Lector head = universityDAO.getDepartmentHead(departmentName);      // Get Lector from DAO
            result.append("Head of ").append(departmentName).append(" department is ")
                    .append(head.getName()).append(" ").append(head.getSurname());
        } catch (DepartmentNotFoundException e) {
            result.append("Can't find a department with the given name.");
        }
        return result.toString();
    }

    public String getDepartmentStatistic(String departmentName) {
        StringBuilder result = new StringBuilder("### Answer: ");       // String to return
        try {
            // Get from DAO
            Map<String, Integer> statictic = universityDAO.getDepartmentStatistic(departmentName);
            statictic.forEach((s, i) -> result.append(s).append(" — ").append(i).append("\n"));
        } catch (DepartmentNotFoundException e) {
            result.append("Can't find a department with the given name.");
        }
        return result.toString();
    }

    public String getDepartmentAverageSalary(String departmentName) {
        StringBuilder result = new StringBuilder("### Answer: ");       // String to return
        try {
            // Get from DAO
            int averageSalary = universityDAO.countDepartmentAverageSalary(departmentName);
            result.append("The average salary of ").append(departmentName).append(" is ")
                    .append(averageSalary);
        } catch (DepartmentNotFoundException e) {
            result.append("Can't find a department with the given name.");
        }
        return result.toString();
    }

    public String getNumberOfDepartmentEmployees(String departmentName) {
        StringBuilder result = new StringBuilder("### Answer: ");       // String to return
        try {
            // Get from DAO
            int amountOfEmployees = universityDAO.countDepartmentEmployees(departmentName);
            result.append(amountOfEmployees).append(" employees work in the department ")
                    .append(departmentName);
        } catch (DepartmentNotFoundException e) {
            result.append("Can't find a department with the given name.");
        }
        return result.toString();
    }

    public String doGlobalSearch(String keyword) {
        StringBuilder result = new StringBuilder("### Answer: ");           // String to return

        List<Lector> searchResults = universityDAO.doGlobalSearch(keyword);     // Get from DAO

        if (!searchResults.isEmpty()) {
            searchResults.forEach(l -> result.append(l.getName()).append(" ")
                    .append(l.getSurname()).append(", "));

            // Delete the last trailing comma
            result.delete(result.length() - 2, result.length() - 1);

        } else {
            result.append("Nothing was found.");
        }
        return result.toString();
    }
}
