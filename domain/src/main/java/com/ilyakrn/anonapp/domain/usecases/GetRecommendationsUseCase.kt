package com.ilyakrn.anonapp.domain.usecases

import com.ilyakrn.anonapp.domain.models.AuthCredentials
import com.ilyakrn.anonapp.domain.models.PostModel
import com.ilyakrn.anonapp.domain.repositories.AuthRepository
import com.ilyakrn.anonapp.domain.repositories.ListRepository
import com.ilyakrn.anonapp.domain.repositories.PostRepository
import com.ilyakrn.anonapp.domain.repositories.TokensRepository
import io.reactivex.Observable
import io.reactivex.Observer

class GetRecommendationsUseCase(
    private val listRepository: ListRepository,
    private val postRepository: PostRepository,
    private val authRepository: AuthRepository,
    private val tokensRepository: TokensRepository,
    private val observer: Observer<PostModel>
) {

    private var offset: Int = 0

    fun invoke(){
        tokensRepository.getRefreshToken()?.let {
            authRepository.refresh(it)?.let {
                tokensRepository.setRefreshToken(it.refreshToken)
                tokensRepository.setRefreshToken(it.accessToken)
                Thread {
                    val posts = listRepository.getRecommendations(tokensRepository.getAccessToken()!!, offset, 100)
                    for (p in posts) {
                        postRepository.getById(tokensRepository.getAccessToken()!!, p)?.let {
                            observer.onNext(it)
                        }
                    }
                    offset += 100
                }.start()
            }
        }
    }

}