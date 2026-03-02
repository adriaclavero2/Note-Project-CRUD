package service;

import model.Note;
import persistence.NoteRepository;

import java.util.List;
import java.util.NoSuchElementException;

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

    public void deleteNote(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }

        long itemsDeleted = noteRepository.deleteByTitle(title);

        if (itemsDeleted == 0) {
            throw new NoSuchElementException("No se encontró ninguna nota con el título: " + title);
        }
    }

    public void updateNoteContent(String title, String newContent) {
        if(title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("The title is necessary to identify the note.");
        }
        long updateCount = noteRepository.update(title, newContent);

        if(updateCount == 0) {
            throw new NoSuchElementException("Could not update: There is no note with the title " + title + ".");
        }
    }
}
