package net.haeyoon.library_core.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Books {
    private Long bookSeq;
    private String title;
    private String titleUrl;
    private String seriesTitle;
    private String author;
    private String publisher;
    private String publisherUrl;
    private String publishPredate;
    private String prePrice;
    private String realPrice;
    private String bookIntroduction;
    private String bookIntroductionUrl;
    private String bookSummary;
    private String bookSummaryUrl;
    private String eaIsbn;
    private String eaAddCode;
    private String setIsbn;
    private String setAddCode;
    private String inputDate;
    private Timestamp bookCreateDate;
    private Timestamp bookModifyDate;
    private String bookStatus;
    private Long bookOwnerSeq;
    private Long categorySeq;

    public Books(Long bookSeq, String title, String titleUrl, String seriesTitle, String author, String publisher, String publisherUrl, String publishPredate, String prePrice, String realPrice, String bookIntroduction, String bookIntroductionUrl, String bookSummary, String bookSummaryUrl, String eaIsbn, String eaAddCode, String setIsbn, String setAddCode, String inputDate, Timestamp bookCreateDate, Timestamp bookModifyDate, String bookStatus, Long bookOwnerSeq, Long categorySeq) {
        this.bookSeq = bookSeq;
        this.title = title;
        this.titleUrl = titleUrl;
        this.seriesTitle = seriesTitle;
        this.author = author;
        this.publisher = publisher;
        this.publisherUrl = publisherUrl;
        this.publishPredate = publishPredate;
        this.prePrice = prePrice;
        this.realPrice = realPrice;
        this.bookIntroduction = bookIntroduction;
        this.bookIntroductionUrl = bookIntroductionUrl;
        this.bookSummary = bookSummary;
        this.bookSummaryUrl = bookSummaryUrl;
        this.eaIsbn = eaIsbn;
        this.eaAddCode = eaAddCode;
        this.setIsbn = setIsbn;
        this.setAddCode = setAddCode;
        this.inputDate = inputDate;
        this.bookCreateDate = bookCreateDate;
        this.bookModifyDate = bookModifyDate;
        this.bookStatus = bookStatus;
        this.bookOwnerSeq = bookOwnerSeq;
        this.categorySeq = categorySeq;
    }
}
