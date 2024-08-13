package net.haeyoon.library_core.common.config;

import lombok.RequiredArgsConstructor;
import net.haeyoon.library_core.domain.dao.*;
import net.haeyoon.library_core.domain.service.*;
import net.haeyoon.library_core.mapper.BookInsertMapper;
import net.haeyoon.library_core.mapper.BookSelectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "net.haeyoon.library_core.mapper")
@RequiredArgsConstructor
public class AppConfig {

    private final BookInsertMapper bookInsertMapper;
    private final BookSelectMapper bookSelectMapper;

    @Bean
    public BookInsertDao bookInsertDao() {
        return new BookInsertDaoImpl(bookInsertMapper);
    }
    @Bean
    public BookInsertService bookInsertService() {
        return new BookInsertServiceImpl(bookInsertDao());
    }

    @Bean
    public OpenApiDao openApiDao() {
        return new OpenApiDaoImpl();
    }
    @Bean
    public OpenApiService openApiService() {
        return new OpenApiServiceImpl(openApiDao());
    }
    @Bean
    public BookSelectDao bookSelectDao() {
        return new BookSelectDaoImpl(bookSelectMapper);
    }
    @Bean
    public BookSelectService bookSelectService() {
        return new BookSelectServiceImpl(bookSelectDao());
    }

}
