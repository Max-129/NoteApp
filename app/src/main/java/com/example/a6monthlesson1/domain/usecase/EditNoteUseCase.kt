package com.example.a6monthlesson1.domain.usecase

import com.example.a6monthlesson1.domain.model.Note
import com.example.a6monthlesson1.domain.repositories.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
    ) {

        fun removeNote(note: Note) = noteRepository.removeNote(note)

    }