package kr.co.ok0.api.repository.restaunrants.collection

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field

abstract class BaseCollection {
  @Id
  @Field(name = "_id")
  lateinit var _id: ObjectId
}