package com.example.a6monthlesson1.presentation.ui.fragments.listofnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.a6monthlesson1.data.base.BaseFragment
import com.example.a6monthlesson1.databinding.FragmentListOfNoteBinding
import com.example.a6monthlesson1.domain.model.Note
import com.example.a6monthlesson1.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListOfNoteFragment : BaseFragment() {

    private lateinit var binding: FragmentListOfNoteBinding
    private val viewModel by viewModels<ListOfNoteViewModel>()
//    private val viewModel: ListOfNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListOfNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllNote()


    }

    private fun getAllNote() {
        viewModel.getAllNote()
        viewModel.getAllNoteState.collectState(
            state = { state ->
                binding.progressBar.isVisible = state is UIState.Loading
            },
            onSuccess = {data->
                //noteAdapter.addList(data)
            })
    }

    private fun removeNote(note: Note) {
        viewModel.removeNote(note)
        viewModel.removeNoteState.collectState(state = {state->
            binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->
            //remove
        })
    }
}










