package com.siwft.cargo.service.util;

public class Util {
    public static boolean validarPassword(String pass, String passDto){
        if(pass.equals(passDto)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
