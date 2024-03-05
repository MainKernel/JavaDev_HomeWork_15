package org.spring.service;

import lombok.RequiredArgsConstructor;
import org.spring.database.NoteDatabase;
import org.spring.entity.NoteEntity;
import org.spring.interfaces.Crud;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService implements Crud<NoteEntity, Long> {

    private final NoteDatabase noteDatabase;

    @Override
    public void save(NoteEntity noteEntity) {
        noteDatabase.save(noteEntity);
    }

    @Override
    public List<NoteEntity> findAll() {
        return noteDatabase.findAll();
    }

    @Override
    public NoteEntity findById(Long aLong) {
        return noteDatabase.findById(aLong);
    }

    @Override
    public void remove(Long aLong) {
        noteDatabase.remove(aLong);
    }

    @Override
    public void update(NoteEntity noteEntity) {
        noteDatabase.update(noteEntity);
    }
}
