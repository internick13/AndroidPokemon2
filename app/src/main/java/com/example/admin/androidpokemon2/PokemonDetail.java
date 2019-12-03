package com.example.admin.androidpokemon2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.androidpokemon2.Adapter.PokemonEvolutionAdapter;
import com.example.admin.androidpokemon2.Adapter.PokemonTypeAdapter;
import com.example.admin.androidpokemon2.Common.Common;
import com.example.admin.androidpokemon2.Model.Pokemon;


/**
 * A simple {@link Fragment} subclass.
 */
public class PokemonDetail extends Fragment {

    ImageView pokemon_img;
    TextView pokemon_name, pokemon_height, pokemon_weight;
    RecyclerView recycler_type, recycler_weakness, recycler_prev_evoultion, recycler_next_evolution;


    static PokemonDetail insance;

    public static PokemonDetail getInstance(){
        if (insance == null)
            return new PokemonDetail();
        return insance;
    }


    public PokemonDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView =  inflater.inflate(R.layout.fragment_pokemon_detail, container, false);

        Pokemon pokemon = Common.findPokemonByNum(getArguments().getString("num"));

        pokemon_img = itemView.findViewById(R.id.pokemon_image);
        pokemon_name = itemView.findViewById(R.id.name);
        pokemon_height = itemView.findViewById(R.id.height);
        pokemon_weight = itemView.findViewById(R.id.weight);

        recycler_type = itemView.findViewById(R.id.recycler_type);
        recycler_type.setHasFixedSize(true);
        recycler_type.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        recycler_weakness = itemView.findViewById(R.id.recycler_weakness);
        recycler_weakness.setHasFixedSize(true);
        recycler_weakness.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        recycler_prev_evoultion = itemView.findViewById(R.id.recycler_pre_evolution);
        recycler_prev_evoultion.setHasFixedSize(true);
        recycler_prev_evoultion.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        recycler_next_evolution = itemView.findViewById(R.id.recycler_next_evolution);
        recycler_next_evolution.setHasFixedSize(true);
        recycler_next_evolution.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        setDeatilPokemon(pokemon);


        return itemView;
    }

    private void setDeatilPokemon(Pokemon pokemon) {

        Glide.with(getActivity()).load(pokemon.getImg()).into(pokemon_img);
        pokemon_name.setText(pokemon.getName());
        pokemon_weight.setText("Weight:  " + pokemon.getWeight());
        pokemon_height.setText("Height:  " + pokemon.getHeight());

        //Set type
        PokemonTypeAdapter typeAdapter = new PokemonTypeAdapter(getActivity(), pokemon.getType());
        recycler_type.setAdapter(typeAdapter);

        //Set weakness
        PokemonTypeAdapter weaknessAdapter = new PokemonTypeAdapter(getActivity(), pokemon.getWeaknesses());
        recycler_weakness.setAdapter(weaknessAdapter);

        //Set prev evolution
        PokemonEvolutionAdapter prevEvolutionAdapter = new PokemonEvolutionAdapter(getActivity(), pokemon.getPrev_evolution());
        recycler_prev_evoultion.setAdapter(prevEvolutionAdapter);

        //Set next evolution
        PokemonEvolutionAdapter nextEvolutionAdapter = new PokemonEvolutionAdapter(getActivity(), pokemon.getNext_evolution());
        recycler_next_evolution.setAdapter(nextEvolutionAdapter);
    }

}
