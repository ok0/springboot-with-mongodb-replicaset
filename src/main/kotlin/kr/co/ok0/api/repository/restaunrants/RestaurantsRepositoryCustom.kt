package kr.co.ok0.api.repository.restaunrants

import kr.co.ok0.api.repository.restaunrants.collection.RestaurantsCollection
import kr.co.ok0.api.repository.restaunrants.dto.RestaurantsSearchContextR
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface RestaurantsRepositoryCustom {
  fun findAllBySearchContext(searchContext: RestaurantsSearchContextR, pageable: Pageable): Page<RestaurantsCollection>
}