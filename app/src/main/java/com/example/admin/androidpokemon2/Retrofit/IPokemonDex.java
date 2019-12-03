package com.example.admin.androidpokemon2.Retrofit;

import com.example.admin.androidpokemon2.Model.Pokedex;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IPokemonDex {

    @GET("pokedex.json")
    Observable<Pokedex> getListPokemon();
}
