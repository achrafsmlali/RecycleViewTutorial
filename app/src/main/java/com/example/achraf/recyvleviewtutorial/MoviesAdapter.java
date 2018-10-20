package com.example.achraf.recyvleviewtutorial;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    //Liste des film qui seront affiche
    private List<Movie> moviesList;

    //construceteur
    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    //cette class permet de fournir une référence directe à chacune des vues dans un élément de données
    public class MyViewHolder extends RecyclerView.ViewHolder {

        // Votre holder doit contenir une variable membre
        // pour toute vue qui sera définie lors du rendu de l'item
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // la methode inflate  prend en entrée un fichier de layout XML et construit les objets View à partir de celui-ci.
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item_layout, parent, false);

        //retourne une instance du holder
        return new MyViewHolder(itemView);
    }

    // onBindViewHolder ç'est la méthode qui permet d'insérer les données dans chaque item
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    // Retourne le nombre total d'éléments dans la liste
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
