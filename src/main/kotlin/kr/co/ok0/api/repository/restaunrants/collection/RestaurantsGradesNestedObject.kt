package kr.co.ok0.api.repository.restaunrants.collection

import kr.co.ok0.api.repository.restaunrants.collection.type.RestaurantsGradeType
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

class RestaurantsGradesNestedObject(
  @Field(name = "date")
  var date: Date,

  @Field(name = "grade")
//  var grade: RestaurantsGradeType,
  var grade: String,

  @Field(name = "score")
  var score: Int?
)