package com.example.myhealthblock.user.domain.model.security;

public interface PasswordManager {
    boolean changePw(String oldPw, String newPw);
}
