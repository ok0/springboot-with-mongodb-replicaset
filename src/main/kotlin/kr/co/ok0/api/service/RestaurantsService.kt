package kr.co.ok0.api.service

import kr.co.ok0.api.service.dto.RestaurantsParamS
import kr.co.ok0.api.service.dto.RestaurantsResultS
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface RestaurantsService {
  fun findAll(pageable: Pageable): Page<RestaurantsResultS>
  fun findById(id: ObjectId): RestaurantsResultS?
  fun insertOne(paramS: RestaurantsParamS): RestaurantsResultS
}