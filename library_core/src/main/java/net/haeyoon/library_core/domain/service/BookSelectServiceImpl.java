package net.haeyoon.library_core.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haeyoon.library_core.common.exception.DataException;
import net.haeyoon.library_core.domain.dao.BookSelectDao;
import net.haeyoon.library_core.domain.dto.SearchObj;
import net.haeyoon.library_core.domain.entity.Books;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookSelectServiceImpl implements BookSelectService {
    private final BookSelectDao bookSelectDao;

    @Override
    public Optional<Books> findBooksByIsbn(SearchObj searchObj) throws DataAccessException {
        try {
            return bookSelectDao.findBooksByIsbn(searchObj);
        } catch (DataAccessException e){
            log.error("아잉 Exception {}", e.getMessage());
            throw new DataException("FindBookSelect Exception : " + e.getMessage(),e);
        }
    }
}
