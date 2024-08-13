package net.haeyoon.library_core.domain.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SearchObj {

    @Size(min = 4 , message = "ISBN을 정확히 입력해주세요.")
    private String eaIsbn;

    public SearchObj(String eaIsbn) {
        this.eaIsbn = eaIsbn;
    }
}
