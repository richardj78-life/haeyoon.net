package net.haeyoon.library_core.domain.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haeyoon.library_core.common.exception.DataException;
import net.haeyoon.library_core.domain.entity.Books;
import net.haeyoon.library_core.mapper.BookInsertMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BookInsertDaoImpl implements BookInsertDao {

    private final BookInsertMapper bookInsertMapper;

    @Override
    public int insertBooks(Books books) throws DataAccessException {
        try {
            log.info("저장 합니다. : {}", books);
            return bookInsertMapper.insertBooks(books);
        } catch (DataAccessException e){
            log.error("Exception-insertBooks {}", e.getMessage(), e);
            throw new DataException("Exception-insertBooks", e);
        }
    }
}
