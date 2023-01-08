package com.example.rickmortyv3.data.models

import com.example.rickmortyv3.data.models.Info

data class AllCharacters(
    val info : Info,
    val results : List<SingleCharacter>
) {
}