package com.example.exerciciofilme.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exerciciofilme.R;
import com.example.exerciciofilme.model.Filme;
import com.example.exerciciofilme.model.Result;
import com.squareup.picasso.Picasso;

public class DetalheFilmeActivity extends AppCompatActivity {
    private ImageView imagemFunndo;
    private ImageView imagemPoster;
    private TextView tituloFilme;
    private TextView dataFilme;
    private TextView linguagemFilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);

        initViews();
        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();

            Result result = bundle.getParcelable("filme");

            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + result.getPosterPath()).into(imagemFunndo);
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + result.getPosterPath()).into(imagemPoster);
            tituloFilme.setText(result.getTitle());
            dataFilme.setText(result.getReleaseDate());
            linguagemFilme.setText(result.getOriginalLanguage());


        }


    }

    public void initViews(){
        imagemFunndo = findViewById(R.id.img_fundo);
        imagemPoster = findViewById(R.id.img_filme);
        tituloFilme = findViewById(R.id.text_titulo);
        dataFilme = findViewById(R.id.text_data);
        linguagemFilme = findViewById(R.id.text_linguage);
    }
}
