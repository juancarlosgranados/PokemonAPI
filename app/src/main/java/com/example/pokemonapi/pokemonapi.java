package com.example.pokemonapi;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class pokemonapi {
    String url = "https://pokeapi.co/docs/v2";
    String result;

    {
        try {
            result = httpUtils.get(url);
JSONObject jsonResult = new JSONObject(result);
            JSONArray results = jsonResult.getJSONArray("result");
    ArrayList
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
