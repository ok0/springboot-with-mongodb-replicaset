package kr.co.ok0.api.controller.v1.restaurants

import kr.co.ok0.api.controller.v1.dto.RestaurantsParamI
import kr.co.ok0.api.controller.v1.dto.RestaurantsResultI
import kr.co.ok0.api.controller.v1.dto.RestaurantsResultIAddress
import kr.co.ok0.api.controller.v1.dto.RestaurantsResultIGrades
import kr.co.ok0.api.repository.restaunrants.collection.RestaurantsAddressNestedObject
import kr.co.ok0.api.repository.restaunrants.collection.RestaurantsGradesNestedObject
import kr.co.ok0.api.service.RestaurantsService
import kr.co.ok0.api.service.dto.*
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/restaurants")
class RestaurantsController(
  private val restaurantsService: RestaurantsService
) {
  @GetMapping("")
  fun getRestaurants(
    @RequestParam(defaultValue = 0.toString()) pageNo: Int,
    @RequestParam(defaultValue = 10.toString()) pageSize: Int
  ) = restaurantsService.findAll(PageRequest.of(pageNo, pageSize)).toI()

  @GetMapping("/{id}")
  fun getRestaurantById(
    @PathVariable(name = "id") id: ObjectId
  ) = restaurantsService.findById(id)?.toI()

  @PostMapping("")
  fun postRestaurant(
    @RequestBody body: RestaurantsParamI
  ) = restaurantsService.insertOne(body.toS()).toI()

  fun Page<RestaurantsResultS>.toI() = this.map { it.toI() }
  fun RestaurantsResultS.toI() = RestaurantsResultI(
    _id = this._id.toHexString(),
    address = RestaurantsResultIAddress(
      building = this.address.building,
      coord = this.address.coord,
      street = this.address.street,
      zipCode = this.address.zipCode
    ),
    borough = this.borough,
    cuisine = this.cuisine,
    grades = this.grades?.map {
      RestaurantsResultIGrades(
        date = it.date,
        grade = it.grade,
        score = it.score
      )
    },
    name = this.name,
    restaurantId = this.restaurantId
  )

  fun RestaurantsParamI.toS() = RestaurantsParamS(
    address = RestaurantsParamSAddress(
      building = this.address.building,
      coord = this.address.coord,
      street = this.address.street,
      zipCode = this.address.zipCode
    ),
    borough = this.borough,
    cuisine = this.cuisine,
    grades = this.grades?.map {
      RestaurantsParamSGrades(
        date = it.date,
        grade = it.grade,
        score = it.score
      )
    },
    name = this.name,
    restaurantId = this.restaurantId
  )
}