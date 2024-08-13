package net.haeyoon.library_core.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookOwner {
    private Long bookOwnerSeq;
    private String ownerName;
    private String ownerPhone;

    public BookOwner(Long bookOwnerSeq, String ownerName, String ownerPhone) {
        this.bookOwnerSeq = bookOwnerSeq;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
    }
}
