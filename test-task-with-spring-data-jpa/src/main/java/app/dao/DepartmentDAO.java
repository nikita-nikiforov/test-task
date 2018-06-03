package app.dao;

import app.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentDAO extends JpaRepository<Department, Integer> {
    Department getByName(String departmentName);

    @Query("select avg(l.salary) from Lector l inner join l.departments d " +
            "where d.name = :department_name")
    int getAverageSalary(@Param("department_name") String departmentName);

}
