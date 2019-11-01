package com.example.exerciciofilme.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.exerciciofilme.model.Result;
import com.example.exerciciofilme.repository.FilmeRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> listaResult = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private FilmeRepository filmeRepository =   new FilmeRepository();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getListaFilme(){
        return this.listaResult;
    }

    public void getAllFilmes(String apiKey){
        disposable.add(
                filmeRepository.getFilmes(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(filme ->  {
                    listaResult.setValue(filme.getResults());
                }, throwable -> {
                    Log.i("LOG", "erro " + throwable.getMessage());
                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
