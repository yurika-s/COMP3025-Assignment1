package ca.georgiancollege.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import ca.georgiancollege.assignment1.databinding.ActivityDetailsBinding;
import ca.georgiancollege.assignment1.model.MovieViewModel;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding binding;
    MovieViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        Intent intent = getIntent();
        // String title = intent.getStringExtra("title");
        String id = intent.getStringExtra("id");
        Log.i("tag", "id: "+ id);

        viewModel.getMovieProperties(id);

        viewModel.getMovieDetail().observe(this, movie -> {
            Glide.with(this).load(movie.getPoster()).into(binding.imageViewPoster);
            binding.textViewTitle.setText(movie.getTitle());
            binding.textViewYear.setText(movie.getYear());
            binding.textViewRating.setText(movie.getRating());
            binding.textViewDirector.setText(movie.getDirector());
            binding.textViewLanguage.setText(movie.getLanguage());
            binding.textViewCountry.setText(movie.getCountry());
            binding.textViewPlot.setText(movie.getPlot());
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
