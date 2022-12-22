package kr.co.ok0.api.repository.restaunrants.collection

import kr.co.ok0.api.repository.restaunrants.collection.type.RestaurantsGradeType
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "restaurants")
class RestaurantsCollection(
  @Id
  @Field(name = "_id")
  var _id: ObjectId,

  @Field(name = "address")
  var address: RestaurantsAddressNestedObject,

  @Field(name = "borough")
  var borough: String,

  @Field(name = "cuisine")
  var cuisine: String,

  @Field(name = "grades")
  var grades: MutableList<RestaurantsGradesNestedObject>? = mutableListOf(),

  @Field(name = "name")
  var name: String,

  @Field(name = "restaurant_id")
  var restaurantId: String
) {
}