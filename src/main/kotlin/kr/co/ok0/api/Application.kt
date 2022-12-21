package kr.co.ok0.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("kr.co.ok0")
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}