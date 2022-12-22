package kr.co.ok0.api.repository.restaunrants.collection.type

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.*

enum class RestaurantsGradeType(val type: String) {
  UNKNOWN("UNKNOWN"),
  A("A"),
  B("B"),
  C("C"),
  Z("Z"),
  P("P"),
  NOT_YET_GRADED("Not Yet Graded");

  @ReadingConverter
  class RestaurantsGradeTypeReadingConverter: Converter<String, RestaurantsGradeType> {
    override fun convert(source: String): RestaurantsGradeType {
      return enumValues<RestaurantsGradeType>().firstOrNull { o -> o.type == source } ?: UNKNOWN
    }
  }

  @WritingConverter
  class RestaurantsGradeTypeWritingConverter: Converter<RestaurantsGradeType, String> {
    override fun convert(source: RestaurantsGradeType): String {
      return source.type
    }
  }
}