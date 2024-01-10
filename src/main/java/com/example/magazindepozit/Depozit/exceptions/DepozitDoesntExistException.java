package com.example.magazindepozit.Depozit.exceptions;

import static com.example.magazindepozit.System.Constants.DEPOZIT_DOESNT_EXIST;

public class DepozitDoesntExistException extends RuntimeException{
    public DepozitDoesntExistException() {
        super(DEPOZIT_DOESNT_EXIST);
    }
}
