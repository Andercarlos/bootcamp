package com.santander.demo.exceptions;

import com.santander.demo.util.MessageUtils;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
