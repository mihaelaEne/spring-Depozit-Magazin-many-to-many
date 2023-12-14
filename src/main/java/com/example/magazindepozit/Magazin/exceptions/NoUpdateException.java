package com.example.magazindepozit.Magazin.exceptions;

import static com.example.magazindepozit.System.Constants.NO_UPDATE;

public class NoUpdateException extends RuntimeException{
    public NoUpdateException() {
        super(NO_UPDATE);
    }
}
