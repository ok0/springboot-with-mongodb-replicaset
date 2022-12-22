package kr.co.ok0.api.repository.restaunrants.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "restaurants")
class RestaurantsEntity(
  @Id
  @Field(name = "_id")
  var _id: ObjectId,

  @Field(name = "borough")
  var borough: String
) {

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as RestaurantsEntity

    if (_id != other._id) return false
    if (borough != other.borough) return false

    return true
  }

  override fun hashCode(): Int {
    var result = _id.hashCode()
    result = 31 * result + borough.hashCode()
    return result
  }

  override fun toString(): String {
    return "RestaurantsEntity(_id=$_id, borough='$borough')"
  }
}