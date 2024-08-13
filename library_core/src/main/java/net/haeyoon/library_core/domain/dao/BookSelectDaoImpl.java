package net.haeyoon.library_core.domain.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haeyoon.library_core.common.exception.DataException;
import net.haeyoon.library_core.domain.dto.SearchObj;
import net.haeyoon.library_core.domain.entity.Books;
import net.haeyoon.library_core.mapper.BookSelectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BookSelectDaoImpl implements BookSelectDao {
    private final BookSelectMapper bookSelectMapper;

    @Override
    public Optional<Books> findBooksByIsbn(SearchObj searchObj) throws DataException {
        try {
            return bookSelectMapper.findBooksByIsbn(searchObj);
        } catch (DataException e) {
            log.error(e.getMessage(), e);
            throw new DataException(e.getMessage());
        }
    }
}
