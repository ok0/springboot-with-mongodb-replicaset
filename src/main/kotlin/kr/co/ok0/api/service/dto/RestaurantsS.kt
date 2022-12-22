package kr.co.ok0.api.service.dto

import org.bson.types.ObjectId
import java.util.*

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