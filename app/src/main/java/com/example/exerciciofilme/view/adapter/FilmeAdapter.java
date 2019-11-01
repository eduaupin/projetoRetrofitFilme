package com.example.exerciciofilme.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exerciciofilme.R;
import com.example.exerciciofilme.model.Filme;
import com.example.exerciciofilme.model.Result;
import com.example.exerciciofilme.view.interfaces.FilmeOnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.ViewHolder> {
    private List<Result> listaDeFilmes;
    private FilmeOnClick listener;

    public FilmeAdapter(List<Result> listaDeFilmes, FilmeOnClick listener) {
        this.listaDeFilmes = listaDeFilmes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = listaDeFilmes.get(position);
        holder.onBind(result);

        holder.itemView.setOnClickListener(view ->{
            listener.OnClick(result);
        });
    }

    @Override
    public int getItemCount() {
        return listaDeFilmes.size();
    }

    public void atualizaLista(List<Result> novaLista){
        this.listaDeFilmes.clear();
        this.listaDeFilmes = novaLista;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView posterFilme;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            posterFilme = itemView.findViewById(R.id.imagemPosterFilme);

        }

        public void onBind(Result result) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + result.getPosterPath()).into(posterFilme);
        }
    }
}
