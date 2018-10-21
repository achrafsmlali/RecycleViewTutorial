package com.example.achraf.recyvleviewtutorial;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    //Liste des film qui seront affiche
    private List<Movie> moviesList;

    public Context myContext ;


    //construceteur
    public MoviesAdapter(Context context,List<Movie> moviesList) {

        this.moviesList = moviesList;
        myContext = context;

    }

    //cette class permet de fournir une référence directe à chacune des vues dans un élément de données
    public class MyViewHolder extends RecyclerView.ViewHolder {

        // Votre holder doit contenir une variable membre
        // pour toute vue qui sera définie lors du rendu de l'item
        public TextView title, year, genre;
        // le layout  de l'item
        public RelativeLayout parentLayout;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            parentLayout = (RelativeLayout) view.findViewById(R.id.parent_layout);
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
        final Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        //on ajoute un OnClickListener sur le layout de l'item
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(myContext,movie.getTitle(),Toast.LENGTH_LONG).show();
                Log.d("TOAST","########################");

                
            }
        });
    }

    // Retourne le nombre total d'éléments dans la liste
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
