package ca.georgiancollege.assignment1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ca.georgiancollege.assignment1.model.Movie;
import ca.georgiancollege.assignment1.model.MovieViewHolder;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    Context context;
    List<Movie> items;

    public MovieAdapter(Context context, List<Movie> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie item = items.get(position);

        holder.title.setText(item.getTitle());
        holder.year.setText(item.getYear());
        Glide.with(context.getApplicationContext()).load(item.getPoster()).into(holder.poster);

        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), DetailsActivity.class);
                intent.putExtra("id", item.getImdbID());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
