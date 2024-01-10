package com.example.magazindepozit.Magazin.dtos;

import com.example.magazindepozit.Magazin.model.Magazin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateMagazinResponse {

    private Magazin magazin;

    @Builder.Default
    private String message="Magazinul a fost creat cu succes";
}
