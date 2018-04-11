package cl.xamaztian.moviestowatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.xamaztian.moviestowatch.models.Movie;

public class MainActivity extends AppCompatActivity {

    List<Movie> movieList;
    public static final String MOVIE_ID = "cl.xamaztian.moviestowatch.KEY.MOVIE_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.movieTitle);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnLastMovie = findViewById(R.id.btnLastMovie);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().trim().length() <= 0)
                    Toast.makeText(MainActivity.this, "Debe ingresar un" +
                            "nombre antes de guardar", Toast.LENGTH_SHORT).show();
                else {
                    Movie movie = new Movie();
                    movie.setTitle(editText.getText().toString());
                    movie.setWatched(false);
                    movie.save();
                    editText.setText("");
                    Toast.makeText(MainActivity.this, "Película guardada exitosamente"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLastMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int moviesSize = getMovies().size();

                if (moviesSize < 1)
                    Toast.makeText(MainActivity.this, "No hay películas"
                            , Toast.LENGTH_SHORT).show();
                else {
                    Intent intentNext = new Intent(MainActivity.this, LastMovieActivity.class);
                    intentNext.putExtra("TITLE", getMovies().get(getMovies().size() - 1).getId());
                    startActivity(intentNext);
                }
            }
        });
    }

    private List<Movie> getMovies() {
        return Movie.find(Movie.class, "watched = 0");
    }

    @Override
    protected void onResume() {
        super.onResume();
        movieList = getMovies();
    }
}
