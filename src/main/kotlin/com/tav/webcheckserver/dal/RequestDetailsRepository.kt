package com.tav.webcheckserver.dal

import com.tav.webcheckserver.model.RequestDetails
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestDetailsRepository : CrudRepository<RequestDetails, String> {
    @Query("FROM RequestDetails r WHERE r.timestamp>:earliest AND r.timestamp<:latest")
    fun findAllInTimeframe(earliest: Double, latest: Double): List<RequestDetails>
}