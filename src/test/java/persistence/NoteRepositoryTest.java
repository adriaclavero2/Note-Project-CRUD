package persistence;

import model.Note;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NoteRepositoryTest {

    private NoteRepository repository;

    @BeforeEach
    void setUp() {
        repository = new NoteRepository();
    }

    @AfterEach
    void tearDown() {
        repository.deleteByTitle("Compras");
    }

    @Test
    void shouldSaveNoteSuccessfully() {
        Note note = new Note("Compras", "Pan, leche y mantequilla");

        repository.save(note);

        Note result = repository.findByTitle("Compras");

        assertNotNull(result, "The note should exist in the database");
        assertEquals("Pan, leche y mantequilla", result.getContent(), "The content should match");
        assertNotNull(result.getCreatedAt(), "The creation date should be automatically set");
    }

    @Test
    void shouldReturnNullWhenNoteDoesNotExist() {
        String nonExistentTitle = "Non Existent Note";

        Note result = repository.findByTitle(nonExistentTitle);

        assertNull(result, "The result should be null for a title that does not exist");
    }
}