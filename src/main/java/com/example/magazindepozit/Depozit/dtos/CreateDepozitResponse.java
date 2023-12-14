package com.example.magazindepozit.Depozit.dtos;

import com.example.magazindepozit.Depozit.model.Depozit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDepozitResponse {
    private Depozit depozit;

    @Builder.Default
    private String message="Depozitul a fost creat cu succes";
}
