package net.haeyoon.library_core.mapper;

import net.haeyoon.library_core.domain.dto.SearchObj;
import net.haeyoon.library_core.domain.entity.Books;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface BookSelectMapper {
    Optional<Books> findBooksByIsbn(SearchObj searchObj);
}
