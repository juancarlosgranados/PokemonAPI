package com.example.pokemonapi;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class pokemonapi {
    ArrayList<pokemon> getPokemons() {
        String url = "https://pokeapi.co/docs/v2";

        try {
            String result = httpUtils.get(url);

            JSONObject jsonResult = new JSONObject(result);
            JSONArray results = jsonResult.getJSONArray("results");

            ArrayList <pokemon> listapokemon = new ArrayList <pokemon> ();
            for (int i = 0; i < result.length(); i++) {
                JSONObject pokemonJson = results.getJSONObject(i);

                pokemon pokemon1 = new pokemon();

                pokemon1.setName(pokemonJson.getString("name"));
                pokemon1.setDtailsURL(pokemonJson.getString("url"));

                String resultDetails = httpUtils.get(pokemon1.getDtailsURL());
                JSONObject jsonDetails = new JSONObject(resultDetails);

                pokemon1.setHeight(jsonDetails.getInt("height"));
                pokemon1.setWeigth(jsonDetails.getInt("weight"));
                //pokemon1.setImage(jsonDetails.getString("image"));


                listapokemon.add(pokemon1);
            }


            Log.e("XXX Pokemons XXX", result);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    }
