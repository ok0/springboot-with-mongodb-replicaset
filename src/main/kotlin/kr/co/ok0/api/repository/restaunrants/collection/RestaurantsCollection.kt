package kr.co.ok0.api.repository.restaunrants.collection

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "restaurants")
class RestaurantsCollection(
  @Field(name = "address")
  var address: RestaurantsAddressNestedObject,

  @Field(name = "borough")
  var borough: String,

  @Field(name = "cuisine")
  var cuisine: String,

  @Field(name = "grades")
  var grades: List<RestaurantsGradesNestedObject>? = mutableListOf(),

  @Field(name = "name")
  var name: String,

  @Field(name = "restaurant_id")
  var restaurantId: String
): BaseCollection() {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as RestaurantsCollection

    if (address != other.address) return false
    if (borough != other.borough) return false
    if (cuisine != other.cuisine) return false
    if (grades != other.grades) return false
    if (name != other.name) return false
    if (restaurantId != other.restaurantId) return false

    return true
  }

  override fun hashCode(): Int {
    var result = address.hashCode()
    result = 31 * result + borough.hashCode()
    result = 31 * result + cuisine.hashCode()
    result = 31 * result + (grades?.hashCode() ?: 0)
    result = 31 * result + name.hashCode()
    result = 31 * result + restaurantId.hashCode()
    return result
  }

  override fun toString(): String {
    return "RestaurantsCollection(address=$address, borough='$borough', cuisine='$cuisine', grades=$grades, name='$name', restaurantId='$restaurantId')"
  }
}