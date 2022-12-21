package kr.co.ok0.api.service.impl

import kr.co.ok0.api.repository.RestaurantsRepository
import kr.co.ok0.api.repository.entity.RestaurantsEntity
import kr.co.ok0.api.service.RestaurantsService
import kr.co.ok0.api.service.dto.RestaurantsResultS
import org.bson.types.ObjectId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class RestaurantsServiceImpl(
  private val restaurantsRepository: RestaurantsRepository
): RestaurantsService {
  override fun findAll(): List<RestaurantsResultS> = restaurantsRepository.findAll().toS()
  override fun findById(id: ObjectId): RestaurantsResultS? = restaurantsRepository.findByIdOrNull(id)?.toS()

  fun List<RestaurantsEntity>.toS() = this.map { it.toS() }
  fun RestaurantsEntity.toS() = RestaurantsResultS(
    id = this.id,
    borough = this.borough
  )
}