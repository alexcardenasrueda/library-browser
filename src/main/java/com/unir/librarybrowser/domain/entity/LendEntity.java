package com.unir.librarybrowser.domain.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Table(name = "lend")
@Entity
public class LendEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "lend_id")
    private long lendId;

    @Column(name = "lend_date")
    private LocalDate lendDate;

    @Column(name = "estimated_return_date")
    private LocalDate estimatedReturnDate;

    @Column(name = "real_return_date")
    private LocalDate realReturnDate;

    @JsonBackReference
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false, foreignKey = @ForeignKey(name = "FK_BOOK_LEND"))
    private BookEntity book;

    @JsonBackReference
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PERSON_LEND"))
    private PersonEntity person;
}
