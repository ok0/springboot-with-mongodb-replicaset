package kr.co.ok0.api.repository.restaunrants

import kr.co.ok0.api.repository.restaunrants.entity.RestaurantsEntity
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface RestaurantsRepository: MongoRepository<RestaurantsEntity, ObjectId> {
}