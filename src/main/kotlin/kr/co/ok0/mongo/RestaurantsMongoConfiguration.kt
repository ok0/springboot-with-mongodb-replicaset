package kr.co.ok0.mongo

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(
  basePackages = ["kr.co.ok0.api.repository.restaunrants"],
  mongoTemplateRef = RestaurantsMongoConfiguration.MONGO_TEMPLATE
)
class RestaurantsMongoConfiguration {
  companion object {
    const val MONGO_TEMPLATE = "restaurantsMongoTemplate"
  }
}