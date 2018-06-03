package app.service;

import app.entity.Lector;
import app.exception.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@Component
public class ConsoleService {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    LectorService lectorService;

    private String welcomeMessage = "Welcome to the University Service. Please, choose the option:\n";
    private String options = " ---1. Who is the head of department?" +
            "\n ---2. Show department's statistic." +
            "\n ---3. Show the average salary for department." +
            "\n ---4. Show count of employees for department" +
            "\n ---5. Global search by keyword." +
            "\n ---6. Exit" +
            "\n \n Please, input the No of an option: ";
    private String breakline = "-----------------------------------------------------\n";

    // Start console interface
    public void start() {
        System.out.println(welcomeMessage);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println(breakline + options);
            try {
                String input = reader.readLine();
                switch (input) {
                    case "1":
                        System.out.println(getDepartmentHead(reader));
                        continue;
                    case "2":
                        System.out.println(getLectorsSortedByDegree(reader));
                        continue;
                    case "3":
                        System.out.println(getAverageSalary(reader));
                        continue;
                    case "4":
                        System.out.println(getAmountOfEmployees(reader));
                        continue;
                    case "5":
                        System.out.println(makeSearch(reader));
                        continue;
                    case "6":
                        reader.close();
                        return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // All methods take in BufferedReader in order to not open the new one every time
    public String getDepartmentHead(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder("### Answer: "); // String to return
        try {
            System.out.println("Enter department name: ");
            String departmentName = reader.readLine();              // Get user's input
            // Get department head using Service
            Lector departmentHead = departmentService.getDepartmentHead(departmentName);
            result.append(departmentHead.getName()).append(" ")     // Append to the result
                    .append(departmentHead.getSurname());
        } catch (DepartmentNotFoundException e) {           // If not found, append this message
            result.append("Department was not found");
        }
        return result.toString();
    }

    public String getLectorsSortedByDegree(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder("### Answer: ");
        try {
            System.out.println("Enter department name: ");
            String departmentName = reader.readLine();
            Map<String, List<Lector>> lectorsByDegree = departmentService
                    .getDepartmentLectorsSortedByDegree(departmentName);
            // Iterate over the map. The key is the name of a degree,
            // the value is a list of Lectors
            lectorsByDegree.forEach((k, v) -> result.append(k)
                    .append(": ").append(v.size()).append("\n"));
        } catch (DepartmentNotFoundException e) {
            result.append("Department was not found");
        }
        return result.toString();
    }

    public String getAverageSalary(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder("### Answer: ");
        try{
            System.out.println("Enter department name: ");
            String departmentName = reader.readLine();
            result.append(Integer.toString(departmentService
                    .getAverageSalary(departmentName)));
        } catch (DepartmentNotFoundException e) {
            result.append("Department was not found");
        }
        return result.toString();
    }

    public String getAmountOfEmployees(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder("### Answer: ");
        try{
            System.out.println("Enter department name: ");
            String departmentName = reader.readLine();
            result.append(Integer.toString(departmentService
                    .countDepartmentEmployees(departmentName)));
        } catch (DepartmentNotFoundException e) {
            result.append("Department was not found");
        }
        return result.toString();
    }

    public String makeSearch(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder("### Answer: ");
        System.out.println("Enter the keyword: ");
        String keyword = reader.readLine();
        List<Lector> lectors = lectorService.makeSearch(keyword);
        // Iterate over the list of found lectors and append them to the result
        lectors.forEach(l -> result.append(l.getName()).append(" ")
                .append(l.getSurname()).append(", "));
        // If empty, say this in the result. Otherwise, delete the last 2 characters
        // to get rid of the ending comma
        if (lectors.size() == 0) {
            result.append("Nobody was found");
        } else {
            result.delete(result.length() - 2, result.length() - 1);
        }
        return result.toString();
    }
}