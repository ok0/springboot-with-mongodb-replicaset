package kr.co.ok0.api.service.impl

import kr.co.ok0.api.repository.restaunrants.RestaurantsRepository
import kr.co.ok0.api.repository.restaunrants.collection.RestaurantsCollection
import kr.co.ok0.api.service.RestaurantsService
import kr.co.ok0.api.service.dto.RestaurantsResultS
import kr.co.ok0.api.service.dto.RestaurantsResultSAddress
import kr.co.ok0.api.service.dto.RestaurantsResultSGrades
import org.bson.types.ObjectId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RestaurantsServiceImpl(
  private val restaurantsRepository: RestaurantsRepository
): RestaurantsService {
  @Transactional
  override fun findAll(): List<RestaurantsResultS> = restaurantsRepository.findAll().toS()

  @Transactional
  override fun findById(id: ObjectId): RestaurantsResultS? = restaurantsRepository.findByIdOrNull(id)?.toS()

  fun List<RestaurantsCollection>.toS() = this.map { it.toS() }
  fun RestaurantsCollection.toS() = RestaurantsResultS(
    _id = this._id,
    address = RestaurantsResultSAddress(
      building = this.address.building,
      coord = this.address.coord,
      street = this.address.street,
      zipCode = this.address.zipCode
    ),
    borough = this.borough,
    cuisine = this.cuisine,
    grades = this.grades?.map {
      RestaurantsResultSGrades(
        date = it.date,
        grade = it.grade,
        score = it.score
      )},
    name = this.name,
    restaurantId = this.restaurantId
  )
}