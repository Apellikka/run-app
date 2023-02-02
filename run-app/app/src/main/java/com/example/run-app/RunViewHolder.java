package com.example.harjoitus678;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RunViewHolder extends RecyclerView.ViewHolder {

    private final TextView dateTextView;
    private final TextView practiceTextView;
    private final TextView distanceTextView;
    private final TextView durationTextView;

    private RunViewHolder(View itemView) {
        super(itemView);
        dateTextView = itemView.findViewById(R.id.dateTextView);
        practiceTextView = itemView.findViewById(R.id.practiceTextView);
        distanceTextView = itemView.findViewById(R.id.distanceTextView);
        durationTextView = itemView.findViewById(R.id.durationTextView);
    }

    public void bind(Run run) {
        String date = run.getDate();
        String practice = run.getPractice();
        String duration = Integer.toString(run.getDuration());
        String distance = Double.toString(run.getDistance());

        dateTextView.setText(date);
        practiceTextView.setText(practice);
        distanceTextView.setText(distance + " km");
        durationTextView.setText(duration + " minutes");
    }

    static RunViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new RunViewHolder(view);
    }

}
