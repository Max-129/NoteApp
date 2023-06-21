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
): NoteRepository{
    override fun createNote(note: Note): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.createNote(note.toEntity())
                emit(Resource.Success(data))
            }catch (e: java.lang.Exception){
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
//                emit(Resource.Error(
//                    if (e.localizedMessage != null){
//                        e.localizedMessage
//                    }else{
//                        "unknow error"
//                    }
//                ))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getAllNotes(): Flow<Resource<List<Note>>> {
        //дз2
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.getAllNotes().map { it.toNote() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun editNote(note: Note): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.editNote(note.toEntity())
                emit(Resource.Success(data))
            }catch (e: java.lang.Exception){
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun removeNote(note: Note): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.removeNote(note.toEntity())
                emit(Resource.Success(data))
            }catch (e: java.lang.Exception){
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }


}