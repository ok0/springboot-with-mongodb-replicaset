package kr.co.ok0.mongo

import com.mongodb.ReadPreference
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.data.mongodb.SessionSynchronization
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
class MongoConfiguration {
  @Value("\${data.mongo.restaurants.uri}")
  private lateinit var uri: String

  @Primary
  @Bean(name = ["restaurantsMongoTemplate"])
  fun restaurantsMongoTemplate(): MongoTemplate {
    val factory = SimpleMongoClientDatabaseFactory(uri)
    val converter = MappingMongoConverter(DefaultDbRefResolver(factory), MongoMappingContext())
    converter.setTypeMapper(null)

    val mongoTemplate = MongoTemplate(factory, converter)
    mongoTemplate.setReadPreference(ReadPreference.secondaryPreferred())
    mongoTemplate.setSessionSynchronization(SessionSynchronization.ON_ACTUAL_TRANSACTION)
    return mongoTemplate
  }

  @Primary
  @Bean(name = ["restaurantsTransactionManager"])
  fun restaurantsTransactionManager()
    = MongoTransactionManager(SimpleMongoClientDatabaseFactory(uri))
}