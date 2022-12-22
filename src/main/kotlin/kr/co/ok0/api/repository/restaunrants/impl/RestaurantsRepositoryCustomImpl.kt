package kr.co.ok0.api.repository.restaunrants.impl

import kr.co.ok0.api.repository.restaunrants.RestaurantsRepositoryCustom
import kr.co.ok0.api.repository.restaunrants.collection.RestaurantsCollection
import kr.co.ok0.api.repository.restaunrants.dto.RestaurantsSearchContextR
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class RestaurantsRepositoryCustomImpl(
  private val mongoTemplate: MongoTemplate
): RestaurantsRepositoryCustom {
  override fun findAllBySearchContext(
    searchContext: RestaurantsSearchContextR,
    pageable: Pageable
  ): Page<RestaurantsCollection> {
    val query = Query()

    searchContext.borough?.let {
      query.addCriteria(Criteria.where("borough").`is`(it))
    }

    searchContext.cuisine?.let {
      query.addCriteria(Criteria.where("cuisine").`is`(it))
    }

    searchContext.grade?.let {
      query.addCriteria(Criteria.where("grades.grade").`is`(it))
    }

    searchContext.name?.let {
      query.addCriteria(Criteria.where("name").`is`(it))
    }

    val count = mongoTemplate.count(query, RestaurantsCollection::class.java)
    val result = mongoTemplate.find(
      query.with(pageable).with(Sort.by(Sort.Direction.DESC, "_id")),
      RestaurantsCollection::class.java
    )

    return PageImpl(result, pageable, count)
  }
}