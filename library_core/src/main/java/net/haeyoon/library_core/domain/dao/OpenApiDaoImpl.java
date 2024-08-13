package net.haeyoon.library_core.domain.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haeyoon.library_core.common.constants.OpenApi;
import net.haeyoon.library_core.common.exception.DataException;
import net.haeyoon.library_core.domain.dto.SearchObj;
import net.haeyoon.library_core.domain.entity.Books;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OpenApiDaoImpl implements OpenApiDao {

    @Override
    public Books getBookByIsbn(SearchObj searchObj) throws JSONException {

        Books books = new Books();
        RestTemplate restTemplate = new RestTemplate();
        String isbn = searchObj.getEaIsbn();
        String url = OpenApi.BookUrl + isbn;
        log.info("create api url: {}",url);
        
        try {
            String response = restTemplate.getForObject(url, String.class);
            log.info("success api response {}",response);
            JSONObject jsonObject = new JSONObject(response);
            JSONArray docsArray = jsonObject.getJSONArray("docs");
            log.info("put the api date to docsArray {}", docsArray);

            if (!docsArray.isEmpty()) {
                JSONObject bookJson = docsArray.getJSONObject(0);
                books.setTitle(bookJson.getString("TITLE"));
                books.setTitleUrl(bookJson.getString("TITLE_URL"));
                books.setSeriesTitle(bookJson.getString("SERIES_TITLE"));
                books.setAuthor(bookJson.getString("AUTHOR"));
                books.setPublisher(bookJson.getString("PUBLISHER"));
                books.setPublisherUrl(bookJson.getString("PUBLISHER_URL"));
                books.setPublishPredate(bookJson.getString("PUBLISH_PREDATE"));
                books.setPrePrice(bookJson.getString("PRE_PRICE"));
                books.setRealPrice(bookJson.getString("REAL_PRICE"));
                books.setBookIntroduction(bookJson.getString("BOOK_INTRODUCTION"));
                books.setBookIntroductionUrl(bookJson.getString("BOOK_INTRODUCTION_URL"));
                books.setBookSummary(bookJson.getString("BOOK_SUMMARY"));
                books.setBookSummaryUrl(bookJson.getString("BOOK_SUMMARY_URL"));
                books.setEaIsbn(bookJson.getString("EA_ISBN"));
                books.setEaAddCode(bookJson.getString("EA_ADD_CODE"));
                books.setSetIsbn(bookJson.getString("SET_ISBN"));
                books.setSetAddCode(bookJson.getString("SET_ADD_CODE"));
                books.setInputDate(bookJson.getString("INPUT_DATE"));
            } else {
                return null;
            }
        }catch (JSONException e){
            log.error("JSon exception {}", e.getMessage());
            throw new DataException("Api 호출 오류 {}" + e.getMessage(), e);
        }
        
        log.info("return data {}", books);
        return books;
    }
}
