package net.haeyoon.library_core.domain.service;

import net.haeyoon.library_core.domain.entity.Books;
import org.springframework.dao.DataAccessException;

public interface BookInsertService {
    Books insertBooks(Books books) throws DataAccessException;
}
