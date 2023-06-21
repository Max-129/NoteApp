package com.example.a6monthlesson1.presentation.ui.fragments.listofnotes

import androidx.lifecycle.viewModelScope
import com.example.a6monthlesson1.data.base.BaseViewModel
import com.example.a6monthlesson1.domain.model.Note
import com.example.a6monthlesson1.domain.usecase.GetAllNoteUseCase
import com.example.a6monthlesson1.domain.usecase.RemoveNoteUseCase
import com.example.a6monthlesson1.domain.utils.Resource
import com.example.a6monthlesson1.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListOfNoteViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNoteUseCase,
    private val removeNoteUseCase: RemoveNoteUseCase
) : BaseViewModel() {
    private val _getAllNoteState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNoteState = _getAllNoteState.asStateFlow()

    private val _removeNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val removeNoteState = _removeNoteState.asStateFlow()

    fun getAllNote() {
        val flow = getAllNotesUseCase.getAllNotes()
        flow.collectData(_getAllNoteState)
    }

    fun removeNote(note: Note) {
        removeNoteUseCase.removeNote(note).collectData(_removeNoteState)
    }
}






