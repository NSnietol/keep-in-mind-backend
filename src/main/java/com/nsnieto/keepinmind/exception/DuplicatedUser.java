package com.nsnieto.keepinmind.exception;

public class DuplicatedUser extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicatedUser() {
        super("User is duplicated, you need to use a different account");
    }

}
