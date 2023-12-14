package com.example.magazindepozit.Depozit.exceptions;

import static com.example.magazindepozit.System.Constants.DEPOZIT_EXIST;

public class DepozitExistException extends RuntimeException{
    public DepozitExistException() {
        super(DEPOZIT_EXIST);
    }
}
