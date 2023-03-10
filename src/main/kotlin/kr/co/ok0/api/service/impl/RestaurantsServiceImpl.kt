package kr.co.ok0.api.service.impl

import kr.co.ok0.api.repository.restaunrants.RestaurantsRepository
import kr.co.ok0.api.repository.restaunrants.collection.RestaurantsAddressNestedObject
import kr.co.ok0.api.repository.restaunrants.collection.RestaurantsCollection
import kr.co.ok0.api.repository.restaunrants.collection.RestaurantsGradesNestedObject
import kr.co.ok0.api.repository.restaunrants.dto.RestaurantsSearchContextR
import kr.co.ok0.api.service.RestaurantsService
import kr.co.ok0.api.service.dto.*
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RestaurantsServiceImpl(
  private val restaurantsRepository: RestaurantsRepository
): RestaurantsService {
  @Transactional
  override fun findAllBySearchContext(searchContextS: RestaurantsSearchContextS, pageable: Pageable): Page<RestaurantsResultS>
    = restaurantsRepository.findAllBySearchContext(searchContextS.toR(), pageable).toS()

  @Transactional
  override fun findById(id: ObjectId): RestaurantsResultS?
    = restaurantsRepository.findByIdOrNull(id)?.toS()

  @Transactional
  override fun insertOne(paramS: RestaurantsParamS): RestaurantsResultS
    = restaurantsRepository.save(paramS.toCollection()).toS()

  private fun RestaurantsSearchContextS.toR() = RestaurantsSearchContextR(
    cuisine = this.cuisine, borough = this.borough, grade = this.grade, name = this.name
  )
  private fun Page<RestaurantsCollection>.toS() = this.map { it.toS() }
  private fun RestaurantsCollection.toS() = RestaurantsResultS(
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

  private fun RestaurantsParamS.toCollection() = RestaurantsCollection(
    address = RestaurantsAddressNestedObject(
      building = this.address.building,
      coord = this.address.coord as MutableList<Double>,
      street = this.address.street,
      zipCode = this.address.zipCode
    ),
    borough = this.borough,
    cuisine = this.cuisine,
    grades = this.grades?.map {
      RestaurantsGradesNestedObject(
        date = it.date,
        grade = it.grade,
        score = it.score
      )
    },
    name = this.name,
    restaurantId = this.restaurantId
  )
}