package com.example.exerciciofilme.data.remote;

import com.example.exerciciofilme.model.Filme;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeAPI {

    @GET("movie/popular")
    Observable<Filme> getAllFilmes(@Query("api_key") String apiKey);

}
