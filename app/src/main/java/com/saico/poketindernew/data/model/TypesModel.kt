package com.saico.poketindernew.data.model

import com.google.gson.annotations.SerializedName

data class TypesModel(
    @SerializedName("type") val type: TypeModel
) {
}