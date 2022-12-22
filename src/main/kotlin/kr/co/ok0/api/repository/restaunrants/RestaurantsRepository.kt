package kr.co.ok0.api.repository.restaunrants

import kr.co.ok0.api.repository.restaunrants.collection.RestaurantsCollection
import org.bson.types.ObjectId
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository

interface RestaurantsRepository: MongoRepository<RestaurantsCollection, ObjectId>, RestaurantsRepositoryCustom {
}