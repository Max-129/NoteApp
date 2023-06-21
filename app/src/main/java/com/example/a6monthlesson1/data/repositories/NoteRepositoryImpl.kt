package com.example.a6monthlesson1.data.repositories

import com.example.a6monthlesson1.data.local.NoteDao
import com.example.a6monthlesson1.data.mappers.toEntity
import com.example.a6monthlesson1.data.mappers.toNote
import com.example.a6monthlesson1.domain.utils.Resource
import com.example.a6monthlesson1.domain.model.Note
import com.example.a6monthlesson1.domain.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
):BaseRepository(), NoteRepository{

    override fun createNote(note: Note): Flow<Resource<Unit>> =doRequest {
        noteDao.createNote(note.toEntity())
    }

    override fun getAllNotes() = doRequest {
        noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) = doRequest {
        noteDao.editNote(note.toEntity())
    }

    override fun removeNote(note: Note) = doRequest {
        noteDao.removeNote(note.toEntity())
    }

}