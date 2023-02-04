package com.example.run_app;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class RunListAdapter extends ListAdapter<Run, RunViewHolder> {

    private Run run;

    public RunListAdapter(@NonNull DiffUtil.ItemCallback<Run> diffCallBack) {
        super(diffCallBack);
        run = null;
    }

    @Override
    public RunViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RunViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(RunViewHolder holder, int position) {
        Run current = getItem(position);
        holder.bind(current);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                run = current;
            }
        });
    }

    public Run getRun() {
        return run;
    }


    static class RunDiff extends DiffUtil.ItemCallback<Run> {

        @Override
        public boolean areItemsTheSame(@NonNull Run oldItem, @NonNull Run newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Run oldItem, @NonNull Run newItem) {
            return oldItem.getDate().equals(newItem.getDate());
        }
    }
}
