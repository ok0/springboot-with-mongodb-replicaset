package kr.co.ok0.api.service.impl

import kr.co.ok0.api.repository.restaunrants.RestaurantsRepository
import kr.co.ok0.api.repository.restaunrants.collection.RestaurantsCollection
import kr.co.ok0.api.service.RestaurantsService
import kr.co.ok0.api.service.dto.RestaurantsResultS
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
    borough = this.borough
  )
}