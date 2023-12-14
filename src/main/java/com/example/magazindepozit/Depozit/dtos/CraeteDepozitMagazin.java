package com.example.magazindepozit.Depozit.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CraeteDepozitMagazin {
    private int depozitId;
    private int magazinId;
}
