package kr.co.ok0

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication(exclude = [MongoDataAutoConfiguration::class])
@ComponentScan("kr.co.ok0")
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}