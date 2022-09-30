package com.example.pokemonapi;

import android.os.Bundle;
import android.util.Log;
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

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    ArrayList<String> items = new ArrayList<>();

    ArrayList<String> pokemones = new ArrayList<>();

     //items.add("jinx");
    // items.add("zamazenta");
   // items.add("garbodor")

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        getContext(),
            R.layout.pokemon_row,
            R.id.idrow,
            items
    );


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

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
    void refresh() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            // Aquest codi s'executa en segon pla
            pokemonapi api = new pokemonapi();
            String result = api.getpokemons();

            Log.d("DEBUG", result);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}