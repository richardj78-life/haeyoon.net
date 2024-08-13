package net.haeyoon.library_core.domain.dao;

import net.haeyoon.library_core.domain.dto.SearchObj;
import net.haeyoon.library_core.domain.entity.Books;
import org.json.JSONException;

public interface OpenApiDao {
    Books getBookByIsbn(SearchObj searchObj) throws JSONException;
}
