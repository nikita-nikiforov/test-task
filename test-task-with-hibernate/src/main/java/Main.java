import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UniversityDAO universityDAO = new UniversityDAO();
        ConsoleService consoleService = new ConsoleService(universityDAO);
        consoleService.start();
    }
}
