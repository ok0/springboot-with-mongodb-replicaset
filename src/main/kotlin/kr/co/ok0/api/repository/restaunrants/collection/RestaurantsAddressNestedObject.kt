package kr.co.ok0.api.repository.restaunrants.collection

import org.springframework.data.mongodb.core.mapping.Field

class RestaurantsAddressNestedObject(
  @Field(name = "building")
  var building: String,

  @Field(name = "coord")
  var coord: MutableList<Double>? = mutableListOf(),

  @Field(name = "street")
  var street: String,

  @Field(name = "zipcode")
  var zipCode: String
)