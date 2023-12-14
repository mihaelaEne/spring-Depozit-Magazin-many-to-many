package com.example.magazindepozit.Magazin.exceptions;

import static com.example.magazindepozit.System.Constants.MAGAZIN_EXIST;

public class MagazinExist extends RuntimeException{
    public MagazinExist() {
        super(MAGAZIN_EXIST);
    }
}
