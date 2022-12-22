package kr.co.ok0.api.service.dto

import org.bson.types.ObjectId
import java.util.*

data class RestaurantsSearchContextS(
  var cuisine: String,
  var borough: String,
  var grade: String,
  var name: String
)

data class RestaurantsResultS(
  var _id: ObjectId,
  var address: RestaurantsResultSAddress,
  var borough: String,
  var cuisine: String,
  var grades: List<RestaurantsResultSGrades>? = mutableListOf(),
  var name: String,
  var restaurantId: String
)

data class RestaurantsResultSAddress (
  var building: String,
  var coord: List<Double>? = mutableListOf(),
  var street: String,
  var zipCode: String
)

data class RestaurantsResultSGrades (
  var date: Date,
  var grade: String,
  var score: Int?
)

data class RestaurantsParamS(
  var address: RestaurantsParamSAddress,
  var borough: String,
  var cuisine: String,
  var grades: List<RestaurantsParamSGrades>? = mutableListOf(),
  var name: String,
  var restaurantId: String
)

data class RestaurantsParamSAddress (
  var building: String,
  var coord: List<Double>? = mutableListOf(),
  var street: String,
  var zipCode: String
)

data class RestaurantsParamSGrades (
  var date: Date,
  var grade: String,
  var score: Int?
)