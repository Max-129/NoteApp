package com.example.a6monthlesson1.data.local

import androidx.room.*
import com.example.a6monthlesson1.data.model.NoteEntity

@Dao
interface NoteDao {

//    CRUD

    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<NoteEntity>

    @Update
    suspend fun editNote(noteEntity: NoteEntity)

    @Delete
    suspend fun removeNote(noteEntity: NoteEntity)

}