package kr.co.ok0.mongo

import kr.co.ok0.api.repository.restaunrants.collection.type.RestaurantsGradeType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.convert.MongoCustomConversions

@Configuration
class MongoConverterConfiguration {
//  @Bean
//  fun customConversions(): MongoCustomConversions {
//    val converters = listOf(
//      RestaurantsGradeType.RestaurantsGradeTypeReadingConverter(),
//      RestaurantsGradeType.RestaurantsGradeTypeWritingConverter(),
//    )
//    return MongoCustomConversions(converters)
//  }
}