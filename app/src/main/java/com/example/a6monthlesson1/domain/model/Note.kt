package com.example.a6monthlesson1.domain.model

class Note(
    val id: Int = DEFAULT_ID,
    val title: String? = null,
    val desc: String? = null,
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}