package net.haeyoon.library_core.domain.service;

import net.haeyoon.library_core.domain.dto.SearchObj;
import net.haeyoon.library_core.domain.entity.Books;
import org.springframework.dao.DataAccessException;

import java.util.Optional;

public interface BookSelectService {
    Optional<Books> findBooksByIsbn(SearchObj searchObj) throws DataAccessException;
}
