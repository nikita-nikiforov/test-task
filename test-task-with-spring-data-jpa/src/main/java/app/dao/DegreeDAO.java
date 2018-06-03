package app.dao;

import app.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeDAO extends JpaRepository<Degree, Integer> {
}
