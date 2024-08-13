package net.haeyoon.library_core.domain.service;

import net.haeyoon.library_core.domain.dto.SearchObj;
import net.haeyoon.library_core.domain.entity.Books;
import org.json.JSONException;

public interface OpenApiService {
    Books getBooksByIsbn(SearchObj searchObj) throws JSONException;
}
