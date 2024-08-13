package net.haeyoon.library_core.mapper;

import net.haeyoon.library_core.domain.entity.Books;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookInsertMapper {
    int insertBooks(Books books);
}
