package com.example.a6monthlesson1.domain.repositories

import com.example.a6monthlesson1.domain.utils.Resource
import com.example.a6monthlesson1.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(noteEntity: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun editNote(noteEntity: Note): Flow<Resource<Unit>>

    fun removeNote(noteEntity: Note): Flow<Resource<Unit>>

}