package kr.co.ok0.api.service

import kr.co.ok0.api.repository.entity.RestaurantsEntity
import kr.co.ok0.api.service.dto.RestaurantsResultS
import org.bson.types.ObjectId

interface RestaurantsService {
  fun findAll(): List<RestaurantsResultS>
  fun findById(id: ObjectId): RestaurantsResultS?
}