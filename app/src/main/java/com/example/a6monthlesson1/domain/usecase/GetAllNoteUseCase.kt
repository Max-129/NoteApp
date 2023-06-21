package com.example.a6monthlesson1.domain.usecase

import com.example.a6monthlesson1.domain.repositories.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
){
    fun getAllNotes()= noteRepository.getAllNotes()
}