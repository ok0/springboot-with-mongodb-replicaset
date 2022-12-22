package kr.co.ok0.api.repository.restaunrants.collection

import kr.co.ok0.api.repository.restaunrants.collection.type.RestaurantsGradeType
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

class RestaurantsGradesNestedObject(
  @Field(name = "date")
  var date: Date,

  @Field(name = "grade")
  var grade: String,
  // TODO: 2022/12/22 use enum class
  @Field(name = "grade")
  var gradeTest: RestaurantsGradeType,

  @Field(name = "score")
  var score: Int?
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as RestaurantsGradesNestedObject

    if (date != other.date) return false
    if (grade != other.grade) return false
    if (gradeTest != other.gradeTest) return false
    if (score != other.score) return false

    return true
  }

  override fun hashCode(): Int {
    var result = date.hashCode()
    result = 31 * result + grade.hashCode()
    result = 31 * result + gradeTest.hashCode()
    result = 31 * result + (score ?: 0)
    return result
  }

  override fun toString(): String {
    return "RestaurantsGradesNestedObject(date=$date, grade='$grade', gradeTest=$gradeTest, score=$score)"
  }
}