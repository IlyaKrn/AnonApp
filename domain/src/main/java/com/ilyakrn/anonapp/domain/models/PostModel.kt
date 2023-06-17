package com.ilyakrn.anonapp.domain.models

data class PostModel (
    var id: Long?,
    var authorId: Long?,
    var likesIds: List<Long>?,
    var commentsIds: List<Long>?,
    var text: String?,
    var tags: List<String>?,
    var isBanned: Boolean?,
    var isDeleted: Boolean?,
    var uploadTime: Long?,
    var isEdited: Boolean?,
    var imagesUrls: List<String>?,
    var filesUrls: List<String>?
)