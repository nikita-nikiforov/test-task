package app.service;

import app.dao.DegreeDAO;
import app.dao.DepartmentDAO;
import app.dao.LectorDAO;
import app.entity.Degree;
import app.entity.Department;
import app.entity.Lector;
import app.exception.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDAO departmentDAO;

    @Autowired
    LectorDAO lectorDAO;

    @Autowired
    DegreeDAO degreeDAO;

    // Get department head
    public Lector getDepartmentHead(String departmentName) throws DepartmentNotFoundException {
        Department department = departmentDAO.getByName(departmentName);    // Get from DAO
        if (department == null) {                       // If not found, throw Exception
            throw new DepartmentNotFoundException();
        }
        return department.getHead();
    }

    // Get lectors sorted by degree. Return Map, where the key is a String of Degree name
    // and the value is a List of the lectors with such a degree
    public Map<String, List<Lector>> getDepartmentLectorsSortedByDegree(String departmentName)
            throws DepartmentNotFoundException {
        Department department = departmentDAO.getByName(departmentName);
        if (department == null) {
            throw new DepartmentNotFoundException();
        }
        Map<String, List<Lector>> result = new HashMap<>();         // Map to return
        List<Degree> degrees = degreeDAO.findAll();                 // Find all degrees
        // Iterate over degrees and load lectors from DAO
        degrees.forEach(d -> result.put(d.getName(),
                lectorDAO.findAllByDepartmentsAndDegree(department, d)));
        return result;
    }

    public int getAverageSalary(String departmentName) throws DepartmentNotFoundException {
        Department department = departmentDAO.getByName(departmentName);
        if (department == null) {
            throw new DepartmentNotFoundException();
        }
        return departmentDAO.getAverageSalary(departmentName);
    }

    public int countDepartmentEmployees(String departmentName) throws DepartmentNotFoundException {
        Department department = departmentDAO.getByName(departmentName);
        if (department == null) {
            throw new DepartmentNotFoundException();
        }
        return lectorDAO.countAllByDepartments(department);
    }
}