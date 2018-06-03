import entity.Degree;
import entity.Department;
import entity.Lector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

// Class with methods to provide all command executions
public class UniversityUtils {

    public static String getDepartmentHead(String departmentName) {
        StringBuilder result = new StringBuilder("### Answer: "); // String to return

        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Create query and get the result
        List<Department> resultList = session.createQuery("from Department where name = :departmentName")
                .setParameter("departmentName", departmentName).getResultList();

        // If the department is present, continue
        if(!resultList.isEmpty()){
            Department department = resultList.get(0);
            Lector head = department.getHead();
            result.append("Head of ").append(departmentName).append(" department is ")
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
        StringBuilder result = new StringBuilder("### Answer: "); // String to return
        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Look for a department with the given name
        List<Department> department = session.createQuery("from Department where name = :name")
                    .setParameter("name", departmentName).getResultList();

        // If such a department is present, continue
        if(!department.isEmpty()) {
            // Get all degrees
            List<Degree> degreeList = session.createQuery("from Degree").getResultList();

            // Query to get department lectors by degree
            Query<Integer> query = session.createNativeQuery("SELECT COUNT(*) FROM Lector L " +
                    "INNER JOIN lector_department LD ON LD.lector_id = L.id " +
                    "INNER JOIN Department D ON D.id = LD.department_id WHERE D.name = :departmentName " +
                    "AND L.degree_id = (SELECT id FROM Degree WHERE name = :degree_name)");
            query.setParameter("departmentName", departmentName);

            // Iterate over all degrees and look for lectors with every degree. Every iteration,
            // the "degree_name" parameter in the query above is changed.
            for (Degree degree : degreeList) {
                query.setParameter("degree_name", degree.getName()); // change degree_name
                // execute query and append to result String
                result.append(degree.getName()).append(" — ").append(query.getSingleResult()).append("\n");
            }
        } else {
            result.append("Can't find a department with the given name.");
        }

        // Close session
        session.getTransaction().commit();
        session.close();

        return result.toString();
    }

    public static String countDepartmentAverageSalary(String departmentName) {
        StringBuilder result = new StringBuilder("### Answer: "); // String to return

        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Look for a department with the given name
        List<Department> department = session.createQuery("from Department where name = :name")
                .setParameter("name", departmentName).getResultList();

        // If such a department is present, continue
        if(!department.isEmpty()) {
            // Query to count average salary
            Query<Integer> query = session.createNativeQuery("SELECT avg(salary) FROM Lector L " +
                    "INNER JOIN lector_department LD ON LD.lector_id = L.id " +
                    "INNER JOIN Department D ON D.id = LD.department_id WHERE D.name = :departmentName");
            query.setParameter("departmentName", departmentName);

            // Execute query and append to the result String
            result.append("The average salary of ").append(departmentName).append(" is ")
                    .append(query.getSingleResult());
        } else {
            result.append("Can't find a department with the given name.");
        }

        // Close session
        session.getTransaction().commit();
        session.close();

        return result.toString();
    }

    public static String countDepartmentEmployees(String departmentName) {
        StringBuilder result = new StringBuilder("### Answer: "); // String to return

        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Look for a department with the given name
        List<Department> department = session.createQuery("from Department where name = :name")
                .setParameter("name", departmentName).getResultList();

        // If such a department is present, continue
        if(!department.isEmpty()) {
            // Query to count amount of lectors
            Query<Integer> query = session.createNativeQuery("SELECT COUNT(*) FROM Lector L " +
                    "INNER JOIN lector_department LD ON LD.lector_id = L.id " +
                    "INNER JOIN Department D ON D.id = LD.department_id WHERE D.name = :departmentName");
            query.setParameter("departmentName", departmentName);

            // Execute query and append to the result String
            result.append(query.getSingleResult());
        } else {
            result.append("Can't find a department with the given name.");
        }

        // Close session
        session.getTransaction().commit();
        session.close();

        return result.toString();
    }

    public static String doGlobalSearch(String keyword) {
        StringBuilder result = new StringBuilder("### Answer: "); // String to return

        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Query to find matches
        Query<Lector> query = session.createQuery("from Lector " +
                "where name like :keyword or surname like :keyword");
        query.setParameter("keyword", "%" + keyword + "%");

        // Execute query
        List<Lector> resultList = query.getResultList();

        // If the result isn't empty, iterate over all the lectors and append them to the result String
        if(!resultList.isEmpty()){
            for (Lector lector : resultList) {
                result.append(lector.getName()).append(" ").append(lector.getSurname()).append(", ");
            }

            // Delete the last trailing comma
            result.delete(result.length() - 2, result.length() - 1);
        } else {
            result.append("Nothing was found.");
        }

        // Close session
        session.getTransaction().commit();
        session.close();

        return result.toString();
    }
}