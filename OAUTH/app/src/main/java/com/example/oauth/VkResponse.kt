package com.example.oauth

data class VkResponse(
    var id: String?,
    var first_name: String?,
    var last_name: String?,
    var can_access_closed: String?,
    var is_closed: String?,
    var bdate: String?
)