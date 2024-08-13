package net.haeyoon.library_web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haeyoon.library_core.common.constants.BASIC;
import net.haeyoon.library_core.common.constants.MESSAGE;
import net.haeyoon.library_core.common.constants.URI;
import net.haeyoon.library_core.domain.dto.SearchObj;
import net.haeyoon.library_core.domain.entity.Books;
import net.haeyoon.library_core.domain.service.BookInsertService;
import net.haeyoon.library_core.domain.service.BookSelectService;
import net.haeyoon.library_core.domain.service.OpenApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {

    private final OpenApiService openApiService;
    private final BookSelectService bookSelectService;
    private final BookInsertService bookInsertService;

    @GetMapping("/searchBook")
    public String searchBook(@ModelAttribute("searchObj") SearchObj searchObj) {
        log.info("로그 찍어요 Get searchBookForm ");
        return "/books/searchBook";
    }

    @GetMapping("/searchResult")
    public String searchResult(@Validated @ModelAttribute("searchObj") SearchObj searchObj,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.error("error: {}", bindingResult.getAllErrors());
            return URI.SEARCH_BOOK;
        }

        log.info("로그 찍어요 Post search result 들어왔음 eaIsbn {}" , searchObj.getEaIsbn());
        
        /*#1 DB select by eaIsbn*/
        Optional<Books> findBooksForDb = bookSelectService.findBooksByIsbn(searchObj);
        if (findBooksForDb.isPresent()) {
            model.addAttribute("books", findBooksForDb.get());
        } else {
            /*#2. Api response*/
            try {
                Books books = openApiService.getBooksByIsbn(searchObj);
                if (books != null){
                    /*ISBN 서지 정보가 있으면 DB에 저장*/
                    Books resultBooks = bookInsertService.insertBooks(books);
                    model.addAttribute("books", resultBooks);
                } else {
                    /*ISBN 서지 정보가 없으면 메시지 출력*/
                    model.addAttribute(BASIC.MSG, MESSAGE.RESULT_NULL);
                    model.addAttribute(BASIC.URI, URI.SEARCH_BOOK);
                    return URI.GET_URI;
                }

            } catch (Exception e) {
                bindingResult.reject("err", e.getMessage());
                return URI.SEARCH_BOOK;
            }
        }
        return URI.SEARCH_RESULT;
    }
}
