package net.haeyoon.library_core.domain.dao;

import net.haeyoon.library_core.domain.entity.Books;
import org.springframework.dao.DataAccessException;

public interface BookInsertDao {

    int insertBooks(Books books) throws DataAccessException;
}
