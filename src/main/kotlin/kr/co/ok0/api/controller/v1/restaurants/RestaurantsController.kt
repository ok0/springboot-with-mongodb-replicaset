package kr.co.ok0.api.controller.v1.restaurants

import kr.co.ok0.api.controller.v1.dto.RestaurantsResultI
import kr.co.ok0.api.service.RestaurantsService
import kr.co.ok0.api.service.dto.RestaurantsResultS
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/restaurants")
class RestaurantsController(
  private val restaurantsService: RestaurantsService
) {
  @GetMapping("")
  fun getRestaurants() = restaurantsService.findAll().toI()

  @GetMapping("/{id}")
  fun getRestaurantById(
    @PathVariable(name = "id") id: ObjectId
  ) = restaurantsService.findById(id)?.toI()

  fun List<RestaurantsResultS>.toI() = this.map { it.toI() }
  fun RestaurantsResultS.toI() = RestaurantsResultI(
    _id = this._id.toHexString(),
    borough = this.borough
  )
}