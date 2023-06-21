package com.example.a6monthlesson1.presentation.ui.fragments.addeditnote

import androidx.lifecycle.ViewModel

@AndroidEntryPoint
class CreateEditFragment : Fragment() {

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
        binding.createEditBtn.setOnClickListener{
            createNote(Note(title = binding.titleEt.text.toString(), desc = binding.descEt.text.toString()))
            //editNote()
        }
    }

    private fun createNote(note: Note) {
        viewModel.createNote(note)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.createNoteState.collect { state ->
                    when (state) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                        is UIState.Loading -> {
                            //show progress bar
                        }

                        is UIState.Success -> {
                            //add note to list

                        }
                    }
                }
            }
        }
    }
    private fun editNote(note: Note) {
        viewModel.editNote(note)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.editNoteState.collect { state ->
                    when (state) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                        is UIState.Loading -> {
                            //show progress bar
                        }

                        is UIState.Success -> {
                            //edit note
                        }
                    }
                }
            }
        }
    }

}