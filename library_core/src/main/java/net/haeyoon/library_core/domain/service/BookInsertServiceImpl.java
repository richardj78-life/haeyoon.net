package net.haeyoon.library_core.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haeyoon.library_core.common.exception.DataException;
import net.haeyoon.library_core.domain.dao.BookInsertDao;
import net.haeyoon.library_core.domain.entity.Books;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookInsertServiceImpl implements BookInsertService {

    private final BookInsertDao bookInsertDao;

    @Override
    public Books insertBooks(Books books) throws DataAccessException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String bookStatus = "USE";
        books.setBookCreateDate(timestamp);
        books.setBookStatus(bookStatus);

        try {
            log.info("API 리턴값을 DB에 저장합니다. books = {}", books);
            int bookSeq = bookInsertDao.insertBooks(books);
            if (bookSeq > 0){
                log.info("저장 완료 Book Seq = {}", books.getBookSeq());
                log.info("저장된 Book info {} ", books);
                return books;
            } else {
                throw new DataException("Book insert failed.");
            }
        } catch (DataAccessException e){
            log.error(e.getMessage());
            throw new DataException("Data Insert Exception - insertBooks", e);
        }
    }
}
