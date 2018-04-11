package cl.xamaztian.moviestowatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import cl.xamaztian.moviestowatch.models.Movie;

public class LastMovieActivity extends AppCompatActivity {

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_movie);

        long id = getIntent().getExtras().getLong("TITLE");
        movie = Movie.findById(Movie.class, id);
        getSupportActionBar().setTitle(movie.getTitle());
    }

    @Override
    protected void onPause() {
        super.onPause();
        CheckBox chk = findViewById(R.id.chWatched);
        movie.setWatched(chk.isChecked());
        movie.save();
    }
}
