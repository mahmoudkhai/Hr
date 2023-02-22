package com.example.hrresturant.data.dataSources.remote

import com.example.hrresturant.data.dataSources.BreakfastResponse
import retrofit2.Response
import retrofit2.http.GET


interface HrApi {

@GET ("breakfast")
suspend fun fetchBreakfast (): Response<BreakfastResponse>
}