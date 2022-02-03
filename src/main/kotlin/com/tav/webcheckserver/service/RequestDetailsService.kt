package com.tav.webcheckserver.service

import com.tav.webcheckserver.dal.RequestDetailsDAL
import com.tav.webcheckserver.dal.RequestDetailsRepository
import com.tav.webcheckserver.dto.UrlWrapper
import com.tav.webcheckserver.model.RequestDetails
import org.springframework.stereotype.Service

@Service
class RequestDetailsService(private val dal: RequestDetailsDAL) {
    fun createRequestDetails(requestDetails: RequestDetails) {
        return dal.save(requestDetails);
    }

    fun getRequestDetails(id: String): RequestDetails {
        return dal.findById(id);
    }

    fun getMostVisited(): UrlWrapper {
        return UrlWrapper(dal.findMostVisitedWebsite())
    }

    fun getRequestsInTimeframe(earliest: Double, latest: Double): List<RequestDetails> {
        return dal.findRequestsInTimeframe(earliest, latest)
    }
}