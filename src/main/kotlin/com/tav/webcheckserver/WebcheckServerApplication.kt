package com.tav.webcheckserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebcheckServerApplication

fun main(args: Array<String>) {
	runApplication<WebcheckServerApplication>(*args)
}
