package org.spring.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class NoteEntity {
    private Long id;
    private String title;
    private String content;
}
