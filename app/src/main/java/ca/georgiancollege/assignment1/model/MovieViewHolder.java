package ca.georgiancollege.assignment1.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ca.georgiancollege.assignment1.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout row;
    public TextView title;
    public TextView year;
    public ImageView poster;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        row = itemView.findViewById(R.id.linerLayoutRow);
        title = itemView.findViewById(R.id.textViewTitle);
        year = itemView.findViewById(R.id.textViewYear);
        poster = itemView.findViewById(R.id.imageViewPoster);
    }
}

