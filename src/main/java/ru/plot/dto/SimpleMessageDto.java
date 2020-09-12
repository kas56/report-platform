package ru.plot.dto;

public class SimpleMessageDto {

    private String message;

    private int id;

    public SimpleMessageDto() {
    }

    public SimpleMessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
