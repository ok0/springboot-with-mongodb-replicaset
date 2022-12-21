package kr.co.ok0.mongodb

import com.mongodb.ReadPreference
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext

@Configuration
class MongodbConfiguration {
  @Value("\${spring.data.mongodb.uri}")
  private lateinit var mongodbURI: String

  @Value("\${spring.data.mongodb.database}")
  private lateinit var mongodbDatabase: String

  @Bean(name = ["mongoTemplate"])
  fun mongoTemplate(): MongoTemplate? {
    val mongoClient: MongoClient = MongoClients.create(mongodbURI)
    val factory: MongoDatabaseFactory = SimpleMongoClientDatabaseFactory(mongoClient, mongodbDatabase)
    val converter = MappingMongoConverter(DefaultDbRefResolver(factory), MongoMappingContext())
    converter.setTypeMapper(DefaultMongoTypeMapper(null))

    val template = MongoTemplate(factory, converter)
    template.setReadPreference(ReadPreference.secondaryPreferred())
    return template
  }
}