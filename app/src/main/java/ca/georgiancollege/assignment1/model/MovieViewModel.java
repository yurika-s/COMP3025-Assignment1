package ca.georgiancollege.assignment1.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.georgiancollege.assignment1.ApiClient;
import ca.georgiancollege.assignment1.MovieAdapter;
import ca.georgiancollege.assignment1.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieViewModel extends ViewModel {
    //Movie movieModel = new Movie();
    private final MutableLiveData<List<Movie>> movieList = new MutableLiveData<>();
    private final MutableLiveData<Movie> movieDetail = new MutableLiveData<>();

    private final String urlData = "https://www.omdbapi.com/?apikey=7a52e74b&type=movie&page=1&";
    private final String urlPoster = "https://img.omdbapi.com/?apikey=7a52e74b&";


    public MovieViewModel() {
    }

    public LiveData<List<Movie>> getMovieList(){
        return movieList;
    }
    public LiveData<Movie> getMovieDetail(){
        return movieDetail;
    }

    public void searchMovies(String keyword){
        String urlString = urlData + "s=" + keyword;
        ApiClient.get(urlString, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.i("error", "msg:"+ e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                assert response.body() != null;
                String responseData = response.body().string();

                JSONObject json = null;
                try {
                    json = new JSONObject(responseData);
                    JSONArray list = json.getJSONArray("Search");

                    List<Movie> movies = new ArrayList<>();
                    for(int i = 0; i<list.length(); i++){
                        JSONObject item = list.getJSONObject(i);
                        String title = item.getString("Title");
                        String year = item.getString("Year");
                        String poster = item.getString("Poster");
                        String imdbID = item.getString("imdbID");
                        Movie movie = new Movie(imdbID,title, year, poster,"","","","","");
                        movies.add(movie);
                    }
                    movieList.postValue(movies);

                } catch (JSONException e) {
                    Log.i("tag", "err: " + e);
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
