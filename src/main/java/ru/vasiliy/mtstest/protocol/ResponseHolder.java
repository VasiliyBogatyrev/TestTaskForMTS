package ru.vasiliy.mtstest.protocol;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Vasiliy Bogatyrev on 12/01/2018.
 *
 * Holds response and has special serializer
 *
 * If it is necessary to store String, use default no-arg constructor,
 * than use setter methods
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHolder<T> {
    private T data;

    private String errorMessage;

    public ResponseHolder(T data) {
        this.data = data;
    }

    public ResponseHolder(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ResponseHolder() {
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
