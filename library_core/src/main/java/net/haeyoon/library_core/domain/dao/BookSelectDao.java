package net.haeyoon.library_core.domain.dao;

import net.haeyoon.library_core.common.exception.DataException;
import net.haeyoon.library_core.domain.dto.SearchObj;
import net.haeyoon.library_core.domain.entity.Books;

import java.util.Optional;

public interface BookSelectDao {
    Optional<Books> findBooksByIsbn(SearchObj searchObj) throws DataException;
}
