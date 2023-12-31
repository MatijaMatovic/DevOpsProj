package com.artificialncool.hostapp.model;

import com.artificialncool.hostapp.model.enums.StatusRezervacije;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("rezervacije")
public class Rezervacija {
    @Id
    private Long ID;

    private Integer brojOsoba;
    private LocalDate datumOd;
    private LocalDate datumDo;
    private StatusRezervacije statusRezervacije;

    @DocumentReference
    private Korisnik korisnik;

    @DocumentReference
    private Smestaj smestaj;
}
