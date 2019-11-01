package com.example.exerciciofilme.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.exerciciofilme.R;
import com.example.exerciciofilme.model.Result;
import com.example.exerciciofilme.view.adapter.FilmeAdapter;
import com.example.exerciciofilme.view.interfaces.FilmeOnClick;
import com.example.exerciciofilme.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements FilmeOnClick {
    private RecyclerView recyclerView;
    private FilmeAdapter adapter;
    private List<Result> listaDeFilmes = new ArrayList<>();
    private HomeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        viewModel.getAllFilmes("bde8033d3274c91b292a5293c6349052");

        viewModel.getListaFilme().observe(this, results -> {
            adapter.atualizaLista(results);
        });


    }

    public void initViews(){
        recyclerView = findViewById(R.id.recyclerFilmes);
        adapter = new FilmeAdapter(listaDeFilmes, this);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @Override
    public void OnClick(Result result) {
        Intent intent = new Intent(this, DetalheFilmeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("filme", result);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
