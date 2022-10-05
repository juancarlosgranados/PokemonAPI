package com.example.pokemonapi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pokemonapi.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class  FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayAdapter adapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ArrayList<String> items = new ArrayList<>();


        adapter = new ArrayAdapter<String>(
                getContext(),
                R.layout.pokemon_row,
                R.id.textid,
                items

        );

        binding.lvPokemons.setAdapter(adapter);

        refresh();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void refresh(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(()->{
            pokemonapi api = new pokemonapi();
            ArrayList<pokemon> pokemons = api.getPokemons();

            handler.post(() -> {
                // Aquest codi s'executa en primer pla.
                adapter.clear();
                adapter.addAll(pokemons);



            });
        });


    }}