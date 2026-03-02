package service;

import model.Note;
import persistence.NoteRepository;

import java.util.List;

public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = new NoteRepository();
    }

    public void saveNote(String title, String content) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("The title is mandatory and cannot be empty.");
        }
        Note note = new Note(title, content);
        noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
}
