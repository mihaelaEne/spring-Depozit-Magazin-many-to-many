package com.example.magazindepozit.Magazin.exceptions;

import static com.example.magazindepozit.System.Constants.MAGAZIN_DOESNT_EXIST;

public class MagazinDoesntExist extends RuntimeException{

    public MagazinDoesntExist() {
        super(MAGAZIN_DOESNT_EXIST);
    }
}
