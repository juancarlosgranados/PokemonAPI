package com.example.pokemonapi;

import android.util.Log;

import org.json.JSONObject;

public class pokemonapi {
    void get pokemons (){
        String url="";
       String result;
        result = httpUtils.get(url);
        JSONObject jsonresult = new JSONObject(result);
        jsonresult.getJSONArray("results");
        Log.e("  POKEMON ");

        for (int i = 0; i < ; i++) {
            JSONObject pokemonJson = result.getJASONObject(i);
        pokemon Pokemon = new pokemon();
        Pokemon.setName(pokemonJson.getString("name"));
        Pokemon.setDtailsURL(pokemonJson.getString("url"));

        pokemons.add(Pokemon)
        }
    }
}
