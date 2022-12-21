package kr.co.ok0.api.repository

import kr.co.ok0.api.repository.entity.Restaurants
import org.springframework.data.mongodb.repository.MongoRepository

interface RestaurantsRepository: MongoRepository<Restaurants, String> {
}