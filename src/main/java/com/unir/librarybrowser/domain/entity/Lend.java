package com.unir.librarybrowser.domain.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Table(name = "lend")
@Entity
public class Lend {

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false, foreignKey = @ForeignKey(name = "FK_BOOK_LEND"))
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PERSON_LEND"))
    private Person person;
}
