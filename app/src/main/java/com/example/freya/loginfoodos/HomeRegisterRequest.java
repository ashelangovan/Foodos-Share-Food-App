package com.example.freya.loginfoodos;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class HomeRegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://10.0.2.2/homeregister.php";
    private Map<String, String> params;

    public HomeRegisterRequest(String name, String username, int number, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("number", number + "");


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
