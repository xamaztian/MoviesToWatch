package cl.xamaztian.moviestowatch.models;

import com.orm.SugarRecord;

/**
 * Created by Xamaztian on 10-04-2018.
 */

public class Movie extends SugarRecord {
    private String title;
    private boolean watched;

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
