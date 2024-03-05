package org.spring.database;

import org.spring.entity.NoteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public  class NoteDatabase {
    private static Long id = 0L;
    private static final List<NoteEntity> DATABASE = new ArrayList<>();

    public NoteDatabase() {

    }

    public void save(NoteEntity noteEntity) {
        noteEntity.setId(id);
        id++;
        DATABASE.add(noteEntity);
    }

    public List<NoteEntity> findAll() {
        return new ArrayList<>(DATABASE);
    }

    public NoteEntity findById(Long id) {
        for (NoteEntity noteEntity : DATABASE) {
            if (noteEntity.getId().equals(id)) {
                return noteEntity;
            }
        }
        return null;
    }


    public void remove(Long id) {
        for (int i = 0; i < DATABASE.size(); i++) {
            NoteEntity noteEntity = DATABASE.get(i);
            if (noteEntity.getId().equals(id)) {
                DATABASE.remove(noteEntity);
            }
        }
    }

    public void update(NoteEntity noteEntity) {
        for (NoteEntity noteEntity1 : DATABASE) {
            if (Objects.equals(noteEntity.getId(), noteEntity1.getId())) {
                noteEntity1.setContent(noteEntity.getContent());
                noteEntity1.setTitle(noteEntity.getTitle());
            }
        }
    }
}