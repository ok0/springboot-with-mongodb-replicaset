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
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as RestaurantsAddressNestedObject

    if (building != other.building) return false
    if (coord != other.coord) return false
    if (street != other.street) return false
    if (zipCode != other.zipCode) return false

    return true
  }

  override fun hashCode(): Int {
    var result = building.hashCode()
    result = 31 * result + (coord?.hashCode() ?: 0)
    result = 31 * result + street.hashCode()
    result = 31 * result + zipCode.hashCode()
    return result
  }

  override fun toString(): String {
    return "RestaurantsAddressNestedObject(building='$building', coord=$coord, street='$street', zipCode='$zipCode')"
  }
}