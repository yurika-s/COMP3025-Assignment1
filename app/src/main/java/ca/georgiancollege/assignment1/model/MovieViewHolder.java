package ca.georgiancollege.assignment1.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ca.georgiancollege.assignment1.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView title;
    public TextView year;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageview);
        title = itemView.findViewById(R.id.title_txt);
        year = itemView.findViewById(R.id.year_txt);
    }
}

