package com.example.a6monthlesson1.data.mappers

import com.example.a6monthlesson1.data.model.NoteEntity
import com.example.a6monthlesson1.domain.model.Note

fun Note.toEntity() = NoteEntity(id, title, desc)

fun NoteEntity.toNote() = Note(id, title, desc)