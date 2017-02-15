package com.example.freya.loginfoodos;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class HomeLoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://10.0.2.2/homelogin.php";
    private Map<String, String> params;

    public HomeLoginRequest(String username, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
