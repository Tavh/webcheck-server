package com.tav.webcheckserver.dal

import com.tav.webcheckserver.model.RequestDetails
import org.springframework.stereotype.Component
import javax.persistence.EntityManager





@Component
class RequestDetailsDAL(
    private val requestDetailsRepository: RequestDetailsRepository,
    private val entityManager: EntityManager
    ){
    fun findMostVisitedWebsite(): String {
        val query = entityManager.createNativeQuery(
            "SELECT target FROM\n" +
                    "(SELECT MAX(hit_count) as mhc, b.target_url as target FROM (SELECT target_url, COUNT(target_url) as hit_count FROM request_details GROUP BY target_url) a\n" +
                    "JOIN \n" +
                    "(SELECT COUNT(target_url) as hc, target_url FROM request_details GROUP BY target_url) b) c"
        )
        return query.singleResult as String;
    }

    fun findById(id: String): RequestDetails {
        return requestDetailsRepository.findById(id).get()
    }

    fun save(requestDetails: RequestDetails) {
        requestDetailsRepository.save(requestDetails)
    }

    fun findRequestsInTimeframe(earliest: Double, latest: Double): List<RequestDetails> {
        return requestDetailsRepository.findAllInTimeframe(earliest, latest)
    }
}