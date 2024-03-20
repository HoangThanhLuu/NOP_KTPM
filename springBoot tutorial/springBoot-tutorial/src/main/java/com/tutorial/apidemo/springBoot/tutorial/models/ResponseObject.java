package com.tutorial.apidemo.springBoot.tutorial.models;

public class ResponseObject {
    private String status;//Đây là một chuỗi dùng để biểu diễn trạng thái của phản hồi, ví dụ như "success" hoặc "error".
    private String message;//message: Một chuỗi chứa thông điệp hoặc mô tả liên quan đến trạng thái của phản hồi.
    private Object data;//data: Một đối tượng kiểu Object chứa dữ liệu cụ thể mà endpoint trả về.

    public ResponseObject(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
