import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Class with methods to provide console interface
public class ConsoleService {

    private static String welcomeMessage = "Welcome to the University Service. Please, choose the option:\n";
    private static String options = " ---1. Who is the head of department?" +
            "\n ---2. Show department's statistic." +
            "\n ---3. Show the average salary for department." +
            "\n ---4. Show count of employees for department" +
            "\n ---5. Global search by keyword." +
            "\n ---6. Exit" +
            "\n \n Please, input the No of option: ";


    // Method to start console interface
    public static void start() throws IOException {
        System.out.println(welcomeMessage);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println(options);
            String input = reader.readLine(); // Read the No of command to execute
            switch (input) {
                case "1":
                    System.out.println("Enter the name of the department: ");
                    String searchQuery = reader.readLine();
                    System.out.println("\n" + UniversityUtils.getDepartmentHead(searchQuery) + "\n");
                    break;
                case "2":
                    System.out.println("Enter the name of the department: ");
                    searchQuery = reader.readLine();
                    System.out.println("\n" + UniversityUtils.getDepartmentStatistic(searchQuery) + "\n");
                    break;
                case "3":
                    System.out.println("Enter the name of the department: ");
                    searchQuery = reader.readLine();
                    System.out.println("\n" + UniversityUtils.countDepartmentAverageSalary(searchQuery) + "\n");
                    break;
                case "4":
                    System.out.println("Enter the name of the department: ");
                    searchQuery = reader.readLine();
                    System.out.println("\n" + UniversityUtils.countDepartmentEmployees(searchQuery) + "\n");
                    break;
                case "5":
                    System.out.println("Enter the keyword: ");
                    searchQuery = reader.readLine();
                    System.out.println("\n" + UniversityUtils.doGlobalSearch(searchQuery) + "\n");
                    break;
                case "6":
                    reader.close();
                    return;
            }
        }
    }
}
