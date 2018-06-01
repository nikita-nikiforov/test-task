import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Class with methods to provide console interface
public class ConsoleService {

    private static String welcomeMessage = "Welcome to the University Service. Please, choose the option: ";
    private static String options = "\n ---1. Who is the head of department?" +
            "\n ---2. Show department's statistic." +
            "\n ---3. Show the average salary for department." +
            "\n ---4. Show count of employees for department" +
            "\n ---5. Global search by keyword." +
            "\n ---6. Exit" +
            "\n Please, input the No of option: ";


    // Method to start console interface
    public static void start() throws IOException {
        System.out.println(welcomeMessage);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\n" + options);
            String input = reader.readLine();
            switch (input) {
                case "1":
                    System.out.println("Enter the name of the department: ");
                    String searchQuery = reader.readLine();
                    System.out.println(UniversityUtils.getDepartmentHead(searchQuery));
                    break;
                case "2":
                    System.out.println("Enter the name of the department: ");
                    searchQuery = reader.readLine();
                    System.out.println(UniversityUtils.getDepartmentStatistic(searchQuery));
                    break;
                case "3":
                    System.out.println("Enter the name of the department: ");
                    searchQuery = reader.readLine();
                    System.out.println(UniversityUtils.countDepartmentAverageSalary(searchQuery));
                    break;
                case "4":
                    System.out.println("Enter the name of the department: ");
                    searchQuery = reader.readLine();
                    System.out.println(UniversityUtils.countDepartmentEmployees(searchQuery));
                    break;
                case "5":
                    System.out.println("Enter the name of the department: ");
                    searchQuery = reader.readLine();
                    System.out.println(UniversityUtils.doGlobalSearch(searchQuery));
                    break;
                case "6":
                    return;
            }
        }
    }
}
