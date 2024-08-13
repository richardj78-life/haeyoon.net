package net.haeyoon.library_core.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookCategory {
    private Long categorySeq;
    private String categoryName;

    public BookCategory(Long categorySeq, String categoryName) {
        this.categorySeq = categorySeq;
        this.categoryName = categoryName;
    }
}
