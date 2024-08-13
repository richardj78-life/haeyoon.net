package net.haeyoon.library_core.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haeyoon.library_core.common.exception.DataException;
import net.haeyoon.library_core.domain.dao.OpenApiDao;
import net.haeyoon.library_core.domain.dto.SearchObj;
import net.haeyoon.library_core.domain.entity.Books;
import org.json.JSONException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenApiServiceImpl implements OpenApiService {

    private final OpenApiDao openApiDao;

    @Override
    public Books getBooksByIsbn(SearchObj searchObj) throws JSONException {
        try {
            log.info("여기 찍음 - OpenApiBo getBooksByIsbn");
            return openApiDao.getBookByIsbn(searchObj);
        } catch (JSONException e) {
            log.error("json exception {}",e.getMessage(), e);
            throw new DataException("Api 호출도중 Json exception 발생 ", e);
        }
    }
}
