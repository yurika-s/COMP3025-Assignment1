package ca.georgiancollege.assignment1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;

import ca.georgiancollege.assignment1.databinding.ActivityMainBinding;
import ca.georgiancollege.assignment1.model.Movie;
import ca.georgiancollege.assignment1.model.MovieViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MovieViewModel viewModel;
    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        binding.searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // get keyword from the text field
                String keyword = binding.keywordText.getText().toString();
                viewModel.searchMovies(keyword);
            }
        });

        viewModel.getMovieList().observe(this, Movies -> {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            binding.recyclerView.setLayoutManager(layoutManager);

            movieAdapter = new MovieAdapter(getApplicationContext(), Movies);
            binding.recyclerView.setAdapter(movieAdapter);
        });

        binding.recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}