import entity.Degree;
import entity.Department;
import entity.Lector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

// Class with methods which provide all command executions
public class UniversityUtils {

    public static String getDepartmentHead(String departmentName) {
        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Create query
        Query query = session.createQuery("from Department where name = :departmentName");
        query.setParameter("departmentName", departmentName);
        List resultList = query.getResultList(); // Get the result
        StringBuilder result = new StringBuilder(); // String to return

        // Check whether the result is present
        if(!resultList.isEmpty()){
            Department department = (Department) resultList.get(0);
            Lector head = department.getHead();
            result.append("Head of [").append(departmentName).append("] department is ")
                    .append(head.getName() + " " + head.getSurname());
        } else {
            result.append("Can't find a department with the given name.");
        }

        // Close session
        session.getTransaction().commit();
        session.close();
        return result.toString();
    }

    public static String getDepartmentStatistic(String departmentName) {
        StringBuilder result = new StringBuilder(); // String to return
        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Look for a department with given name
        List department = session.createQuery("from Department where name = :name")
                .setParameter("name", departmentName).getResultList();

        // If such a department is absent, return from the method
        if(department.isEmpty())
            return "Can't find a department with the given name.";

        // Get all degrees
        List<Degree> degreeList = session.createQuery("from Degree").getResultList();

        // Query to get lectors from given department
        Query<Integer> query = session.createNativeQuery("SELECT COUNT(*) FROM Lector L " +
                "INNER JOIN Department D ON D.id = L.department_id WHERE D.name = :departmentName " +
                "and L.degree_id = (SELECT id from Degree where name = :degree_name)");
        query.setParameter("departmentName", departmentName);

        // Iterate over all degrees and look for lectors with every degree. Every iteration,
        // the "degree_name" parameter in the query above is changed.
        for (Degree degree : degreeList) {
            query.setParameter("degree_name", degree.getName()); // change degree_name
            // execute query and append to result String
            result.append(degree.getName()).append(" — ").append(query.getSingleResult()).append("\n");
        }

        // Close session
        session.getTransaction().commit();
        session.close();

        return result.toString();
    }

    public static String countDepartmentAverageSalary(String departmentName) {
        StringBuilder result = new StringBuilder(); // String to return

        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Look for a department with the given name
        List department = session.createQuery("from Department where name = :name")
                .setParameter("name", departmentName).getResultList();

        // If such a department is absent, return from the method
        if(department.isEmpty())
            return "Can't find a department with the given name.";

        // Query to count average salary
        Query<Integer> query = session.createNativeQuery("SELECT avg(salary) FROM Lector L " +
                "INNER JOIN Department D ON D.id = L.department_id WHERE D.name = :departmentName");
        query.setParameter("departmentName", departmentName);

        // Execute query and append to the result String
        result.append("The average salary of ").append(departmentName).append(" is ")
                .append(query.getSingleResult());

        // Close session
        session.getTransaction().commit();
        session.close();

        return result.toString();
    }

    public static String countDepartmentEmployees(String departmentName) {
        StringBuilder result = new StringBuilder(); // String to return

        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Look for a department with the given name
        Department department = (Department) session.createQuery("from Department where name = :name")
                .setParameter("name", departmentName).getSingleResult();

        // If such a department is absent, return from the method
        if(department == null)
            return "Can't find a department with the given name.";

        // Query to count amount of lectors
        Query<Integer> query = session.createNativeQuery("SELECT COUNT(*) FROM Lector L " +
                "INNER JOIN Department D ON D.id = L.department_id WHERE D.name = :departmentName");
        query.setParameter("departmentName", departmentName);

        // Execute query and append to the result String
        result.append(query.getSingleResult());

        // Close session
        session.getTransaction().commit();
        session.close();

        return result.toString();
    }

    public static String doGlobalSearch(String keyword) {
        StringBuilder result = new StringBuilder(); // String to return

        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Query to find results
        Query<Lector> query = session.createQuery("from Lector " +
                "where name like :keyword or surname like :keyword");
        query.setParameter("keyword", "%" + keyword + "%");

        // Execute
        List<Lector> resultList = query.getResultList();
        for (Lector lector : resultList) {
            result.append(lector.getName()).append(" ").append(lector.getSurname()).append(", ");
        }

        // Delete the last trailing comma
        result.delete(result.length()-2, result.length()-1);

        // Close session
        session.getTransaction().commit();
        session.close();

        return result.toString();

    }
}