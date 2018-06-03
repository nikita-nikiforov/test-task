package app.dao;

import app.entity.Degree;
import app.entity.Department;
import app.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectorDAO extends JpaRepository<Lector, Integer> {
    List<Lector> findAllByDepartmentsAndDegree(Department department, Degree degree);

    int countAllByDepartments(Department department);

    @Query("select l from Lector l where name like %:keyword% or surname like %:keyword%")
    List<Lector> findByNameOrSurnameContaining(@Param("keyword") String keyword);
}
