package app.service;

import app.dao.LectorDAO;
import app.entity.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LectorService {

    @Autowired
    LectorDAO lectorDAO;

    public List<Lector> makeSearch(String keyword) {
        return lectorDAO.findByNameOrSurnameContaining(keyword);
    }
}