package com.example.magazindepozit.Magazin.exceptions;


import static com.example.magazindepozit.System.Constants.MAGAZIN_LIST_EMPTY;

public class MagazinListEmpty extends RuntimeException{
    public MagazinListEmpty() {
        super(MAGAZIN_LIST_EMPTY);
    }
}
