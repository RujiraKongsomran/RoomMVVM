package com.rujira.roommvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rujira.roommvvm.Model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.txt_view_title.setText(currentNote.getTitle());
        holder.txt_view_description.setText(currentNote.getDescription());
        holder.txt_view_priority.setText(String.valueOf(currentNote.getPriority()));

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView txt_view_title;
        private TextView txt_view_description;
        private TextView txt_view_priority;

        public NoteHolder(View itemView) {
            super(itemView);
            txt_view_title = itemView.findViewById(R.id.txt_view_title);
            txt_view_description = itemView.findViewById(R.id.txt_view_description);
            txt_view_priority = itemView.findViewById(R.id.txt_view_priority);

        }

    }
}
