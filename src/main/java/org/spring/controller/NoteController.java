package org.spring.controller;

import jakarta.annotation.PostConstruct;
import org.spring.database.NoteDatabase;
import org.spring.entity.NoteEntity;
import org.spring.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
/*
*
* # Завдання №3 - створи на pure HTML UI для управління нотатками
@RequestMapping("/noteEntity")
Створи контролер NoteController. Створи на pure HTML UI для управління нотатками.

Обов'язково мають бути наступні сторінки:

    GET /noteEntity/list - отримати список нотаток. Виводиться список нотаток (title та content), кожну нотатку можна видалити або редагувати
    POST /noteEntity/delete - видалити нотатку по ID. Після видалення нотатки відбувається редирект на /noteEntity/list
    GET /noteEntity/edit?id=xxx - сторінка редагування нотатку (відкривається по натисненню на кнопку Редагувати на списку нотаток).
    POST /noteEntity/edit - сюди відправляється запит на редагування нотатки. Після збереження оновленого контенту нотатки відбувається редирект на /noteEntity/list

Необов'язкове завдання

Додай до проєкту бібліотеку bootstrap (за допомогою CDN посилання). Стилізуй програму за допомогою bootstrap компонентів.

*
* */

@Controller
@RequestMapping("/noteEntity")
public class NoteController {



    @Autowired
    private NoteService service;

    @GetMapping("/list")
    public ModelAndView getNoteList() {
        List<NoteEntity> all = service.findAll();
        ModelAndView modelAndView = new ModelAndView("note/noteList");
        modelAndView.addObject("notes", all);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam("id") Long id) {
        service.remove(id);
        return new ModelAndView("redirect:/noteEntity/list");
    }

    @GetMapping("/edit")
    public ModelAndView editNoteForm(@RequestParam("id") Long id) {
        NoteEntity byId = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("note/noteEdit");
        modelAndView.addObject("note", byId);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editNote(@ModelAttribute NoteEntity note) {
        service.save(note);
        return new ModelAndView("redirect:/noteEntity/list");
    }

    @PostConstruct
    private void addNotes() {
        NoteEntity noteEntity = NoteEntity.builder().content("Content").title("title").build();
        for (int i = 0; i < 20; i++) {
            noteEntity.setContent(noteEntity.getContent() + i/2);
            noteEntity.setTitle(noteEntity.getTitle() + i/2);
            service.save(noteEntity);
        }
    }
}
