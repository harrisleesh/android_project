package com.example.qweqa.firstproject.models

data class HomeResponse(
    val user: User,
    val posts: List<PostSummary>
)