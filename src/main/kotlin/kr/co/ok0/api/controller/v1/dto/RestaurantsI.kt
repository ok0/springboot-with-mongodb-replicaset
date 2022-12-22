package kr.co.ok0.api.controller.v1.dto

import java.util.*

data class RestaurantsResultI (
  var _id: String,
  var address: RestaurantsResultIAddress,
  var borough: String,
  var cuisine: String,
  var grades: List<RestaurantsResultIGrades>? = mutableListOf(),
  var name: String,
  var restaurantId: String
)

data class RestaurantsResultIAddress(
  var building: String,
  var coord: List<Double>? = mutableListOf(),
  var street: String,
  var zipCode: String
)

data class RestaurantsResultIGrades(
  var date: Date,
  var grade: String,
  var score: Int?
)

data class RestaurantsParamI (
  var address: RestaurantsParamIAddress,
  var borough: String,
  var cuisine: String,
  var grades: List<RestaurantsParamIGrades>? = mutableListOf(),
  var name: String,
  var restaurantId: String
)
data class RestaurantsParamIAddress(
  var building: String,
  var coord: List<Double>? = mutableListOf(),
  var street: String,
  var zipCode: String
)

data class RestaurantsParamIGrades(
  var date: Date,
  var grade: String,
  var score: Int?
)