package com.example.clientes.controller.handler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant moment, Integer status, String error, String message, String path) {
        super(moment, status, error, message, path);
    }

    public List<FieldMessage> getFieldMessages() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        FieldMessage fieldMessage = new FieldMessage(fieldName, message);
        errors.add(fieldMessage);
    }
}
