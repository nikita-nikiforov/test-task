import entity.Degree;
import entity.Department;
import entity.Lector;
import exception.DepartmentNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class with methods to get data from DB
public class UniversityDAO {

    public Lector getDepartmentHead(String departmentName) throws DepartmentNotFoundException {
        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            // Look for a department with the given name
            List<Department> resultList = session.createQuery("from Department where name = :departmentName")
                    .setParameter("departmentName", departmentName).getResultList();

            if (resultList.isEmpty()) {                     // If department is absent, throw exception
                throw new DepartmentNotFoundException();
            }

            Department department = resultList.get(0);      // Otherwise, get it from the list
            return department.getHead();                    // And return its head

        } finally {
            session.getTransaction().commit();              // Close session
            session.close();
        }
    }

    public Map<String, Integer> getDepartmentStatistic(String departmentName) throws DepartmentNotFoundException {
        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            // Look for a department with the given name
            List<Department> department = session.createQuery("from Department where name = :name")
                    .setParameter("name", departmentName).getResultList();

            if (department.isEmpty()) {                     // If department is absent, throw exception
                throw new DepartmentNotFoundException();
            }

            // Get all degrees
            List<Degree> degreeList = session.createQuery("from Degree").getResultList();

            // Query to get department lectors by degree
            Query<BigInteger> query = session.createNativeQuery("SELECT COUNT(*) FROM Lector L " +
                    "INNER JOIN lector_department LD ON LD.lector_id = L.id " +
                    "INNER JOIN Department D ON D.id = LD.department_id WHERE D.name = :departmentName " +
                    "AND L.degree_id = :degree_id");
            query.setParameter("departmentName", departmentName);

            // Map to be returned. Key is the name of degree, value is the amount of employees
            Map<String, Integer> result = new HashMap<>();

            // Iterate over all degrees and look for lectors with every degree. Every iteration,
            // the "degree_name" parameter in the query above is changed
            for (Degree degree : degreeList) {
                query.setParameter("degree_id", degree.getId());    // Change degree_id
                int amount = query.getSingleResult().intValue();       // Execute query and get int value of BigInteger
                result.put(degree.getName(), amount); // Put to map
            }

            return result;

        } finally {
            session.getTransaction().commit();              // Close session
            session.close();
        }
    }

    public int countDepartmentAverageSalary(String departmentName) throws DepartmentNotFoundException {
        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            // Look for a department with the given name
            List<Department> department = session.createQuery("from Department where name = :name")
                    .setParameter("name", departmentName).getResultList();

            if (department.isEmpty()) {                     // If department is absent, throw exception
                throw new DepartmentNotFoundException();
            }

            // Query to count the average salary
            Query<BigDecimal> query = session.createNativeQuery("SELECT avg(salary) FROM Lector L " +
                    "INNER JOIN lector_department LD ON LD.lector_id = L.id " +
                    "INNER JOIN Department D ON D.id = LD.department_id WHERE D.name = :departmentName");
            query.setParameter("departmentName", departmentName);

            return query.getSingleResult().intValue();      // Execute query and get int value of BigDecimal

        } finally {
            session.getTransaction().commit();              // Close session
            session.close();
        }
    }

    public int countDepartmentEmployees(String departmentName) throws DepartmentNotFoundException {
        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            // Look for a department with the given name
            List<Department> department = session.createQuery("from Department where name = :name")
                    .setParameter("name", departmentName).getResultList();

            if (department.isEmpty()) {                     // If department is absent, throw exception
                throw new DepartmentNotFoundException();
            }

            // Query to count amount of lectors
            Query<BigInteger> query = session.createNativeQuery("SELECT COUNT(*) FROM Lector L " +
                    "INNER JOIN lector_department LD ON LD.lector_id = L.id " +
                    "INNER JOIN Department D ON D.id = LD.department_id WHERE D.name = :departmentName");
            query.setParameter("departmentName", departmentName);

            return query.getSingleResult().intValue();      // Execute query and get int value of BigInteger

        } finally {
            session.getTransaction().commit();              // Close session
            session.close();
        }
    }

    public List<Lector> doGlobalSearch(String keyword) {
        // Open session and begin transaction
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            // Query to find matches
            Query<Lector> query = session.createQuery("from Lector " +
                    "where name like :keyword or surname like :keyword");
            query.setParameter("keyword", "%" + keyword + "%");

            return query.getResultList();                   // Execute query

        } finally {
            // Close session
            session.getTransaction().commit();
            session.close();
        }
    }
}