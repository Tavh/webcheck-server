package com.tav.webcheckserver.controller

import com.tav.webcheckserver.dto.UrlWrapper
import com.tav.webcheckserver.model.RequestDetails
import com.tav.webcheckserver.service.RequestDetailsService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("request-details")
class RequestDetailsController(private val service: RequestDetailsService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createRequestDetails(@RequestBody requestDetails: RequestDetails) {
        return service.createRequestDetails(requestDetails)
    }

    @GetMapping("/{id}")
    fun getRequestDetails(@PathVariable id: String): RequestDetails {
        return service.getRequestDetails(id)
    }

    @GetMapping("most-visited")
    fun getMostVisited(): UrlWrapper {
        return service.getMostVisited()
    }

    @GetMapping("requests-in-timeframe")
    fun getRequestsInTimeframe(@RequestParam earliest: Double, @RequestParam latest: Double): List<RequestDetails> {
        return service.getRequestsInTimeframe(earliest, latest)
    }
}