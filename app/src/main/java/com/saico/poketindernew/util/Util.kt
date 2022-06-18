package com.saico.poketindernew.util

fun formatNumberTo3Digits(number: Int): String = "#${"%03d".format(number)}"

fun getIdPokemonFromUrl(url: String) : String = url.split("/").toTypedArray()[6]

fun getUrlFromId(id: String) : String = "https://pokeapi.co/api/v2/pokemon/$id"