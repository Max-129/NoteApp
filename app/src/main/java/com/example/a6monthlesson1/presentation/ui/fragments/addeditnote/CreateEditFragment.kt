package com.example.a6monthlesson1.presentation.ui.fragments.addeditnote

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a6monthlesson1.R
import com.example.a6monthlesson1.data.base.BaseFragment

@AndroidEntryPoint
class CreateEditFragment : BaseFragment() {

    private lateinit var binding: FragmentCreateEditBinding
    private val viewModel by viewModels<CreateEditViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()

    }

    private fun initClickers() {
        binding.createEditBtn.setOnClickListener {
            createNote(
                Note(
                    title = binding.titleEt.text.toString(),
                    desc = binding.descEt.text.toString()
                )
            )
            //editNote()
        }
    }

    private fun createNote(note: Note) {
        viewModel.createNote(note)
        viewModel.createNoteState.collectState(
            state = { state ->
                // binding.progressBar.isVisible = state is UIState.Loading
            },
            onSuccess = { data ->
                //adapter.addList(data)
            })

    }

    private fun editNote(note: Note) {
        viewModel.editNote(note)
        viewModel.editNoteState.collectState(
            state = { state ->
                // binding.progressBar.isVisible = state is UIState.Loading
            }, onSuccess = { data ->
                //adapter.addList(data)
            }
    }

}