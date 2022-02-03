package com.tav.webcheckserver.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "request_details")
data class RequestDetails(
    @Id
    val id: String,
    @Column(nullable = false)
    val timestamp: Double,
    @Column(nullable = false)
    val duration: Double,
    @Column(nullable = false)
    val targetUrl: String,
    @Column(nullable = false)
    val responseCode: Int
    )
