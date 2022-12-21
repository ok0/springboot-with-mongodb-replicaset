package kr.co.ok0.api.repository

import kr.co.ok0.api.repository.entity.RestaurantsEntity
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface RestaurantsRepository: MongoRepository<RestaurantsEntity, ObjectId> {
}