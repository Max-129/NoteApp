package com.example.a6monthlesson1.data.local

import androidx.room.*
import com.example.a6monthlesson1.data.model.NoteEntity

@Dao
interface NoteDao {

//    CRUD

    fun createNote(noteEntity: NoteEntity)

    fun getAllNotes(): List<NoteEntity>

    fun editNote(noteEntity: NoteEntity)

    fun removeNote(noteEntity: NoteEntity)

}