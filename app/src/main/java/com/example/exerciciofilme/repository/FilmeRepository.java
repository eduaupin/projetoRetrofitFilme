package com.example.exerciciofilme.repository;

import com.example.exerciciofilme.model.Filme;

import io.reactivex.Observable;

import static com.example.exerciciofilme.data.remote.RetrofitService.getApiService;

public class FilmeRepository {

    public Observable<Filme> getFilmes(String apiKey){
        return getApiService().getAllFilmes(apiKey);
    }

}
