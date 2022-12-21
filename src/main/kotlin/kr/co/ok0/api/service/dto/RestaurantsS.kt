package kr.co.ok0.api.service.dto

import org.bson.types.ObjectId

data class RestaurantsResultS (
  var id: ObjectId,
  var borough: String
)