package com.example.hrresturant.data.dataSources

import com.google.gson.annotations.SerializedName


data class BreakfastResponse(
    @SerializedName("General")
    val general : List<GeneralEntity>,
    @SerializedName("croissant")
    val croissant: List<CroissantEntity>,
    @SerializedName ("omelette")
    val omelette: List<OmeletteEntity>,
    @SerializedName ("panCake")
    val panCake: List<PanCakeEntity>,

    )
