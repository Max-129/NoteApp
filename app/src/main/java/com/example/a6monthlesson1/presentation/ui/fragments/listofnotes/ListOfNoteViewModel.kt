package com.example.a6monthlesson1.presentation.ui.fragments.listofnotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a6monthlesson1.domain.model.Note
import com.example.a6monthlesson1.domain.usecase.GetAllNotesUseCase
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
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val removeNoteUseCase: RemoveNoteUseCase
) : ViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _removeNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val removeNoteState = _removeNoteState.asStateFlow()

    fun getAllNote() {
        viewModelScope.launch {
            getAllNotesUseCase.getAllNotes().collect() { res ->
                when (res) {
                    is Resource.Error -> {
                        _getAllNotesState.value = UIState.Error(res.message!!)
                    }
                    is Resource.Loading -> {
                        _getAllNotesState.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (res.data != null)
                        _getAllNotesState.value = UIState.Success()
                    }
                }
            }
        }
    }

    fun removeNote(note: Note) {
        viewModelScope.launch {
            removeNoteUseCase.removeNote(note).collect() { res ->
                when (res) {
                    is Resource.Error -> {
                        _removeNoteState.value = UIState.Error(res.message!!)
                    }

                    is Resource.Loading -> {
                        _removeNoteState.value = UIState.Loading()
                    }

                    is Resource.Success -> {
                        if (res.data != null)
                            _removeNoteState.value = UIState.Success(Unit)
                    }
                }

            }
        }
    }
}






