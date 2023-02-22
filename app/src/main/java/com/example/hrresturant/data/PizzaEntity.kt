package com.example.hrresturant.data

data class PizzaEntity(
    override val title: String,
    override val description: String,
    override val price: Double,
    override val estimatedTime: Int
): CommonInterface(title, description, price , estimatedTime)
