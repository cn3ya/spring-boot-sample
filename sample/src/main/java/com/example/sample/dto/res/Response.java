package com.example.sample.dto.res;

import lombok.Data;

@Data
public class Response {
    
    private boolean success;
    private String msg;
    private Object data;
    private String requestId = "";

    public Response(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public static Response ok(Object data) {
        return new Response(true, "ok", data);
    }

    public static Response ok(String msg) {
        return new Response(true, msg, null);
    }

    public static Response fail(String msg) {
        return new Response(false, msg, null);
    }
}
