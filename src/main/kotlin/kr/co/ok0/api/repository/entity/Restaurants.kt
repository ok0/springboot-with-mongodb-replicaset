package kr.co.ok0.api.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "restaurants")
class Restaurants(
  @Id
  @Field(name = "_id")
  var id: String,

  @Field(name = "borough")
  var borough: String
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Restaurants

    if (id != other.id) return false
    if (borough != other.borough) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + borough.hashCode()
    return result
  }

  override fun toString(): String {
    return "Restaurants(id='$id', borough='$borough')"
  }
}