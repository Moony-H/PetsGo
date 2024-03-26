package com.moony.kakao_login

import android.app.Activity
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

object KakaLoginManager {
    suspend fun login(activity: Activity): String? {
        return suspendCancellableCoroutine { continuation ->
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(activity)) {

                UserApiClient.instance.loginWithKakaoTalk(activity) { token, error ->
                    //에러가 있음
                    if (error != null) {
                        //카카오톡은 설치가 되어 있으나, 동의를 받는 와중에 사용자가 로그인을 취소한 경우.
                        if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                            return@loginWithKakaoTalk
                        }

                        //카카오톡 설치가 되어 있지만, 로그인은 안 되어 있는 경우 웹으로 시도.
                        UserApiClient.instance.loginWithKakaoAccount(activity) { token: OAuthToken?, error: Throwable? ->
                            if (error != null) {
                                continuation.resume(null)
                            } else continuation.resume(token?.accessToken)
                        }
                    } else if (token != null) {
                        //카카오톡 설치도 되어있고, 정상적으로 사용자가 로그인함
                        continuation.resume(token.accessToken)
                    }


                }
            } else {
                //카톡 설치 안되어있음
                UserApiClient.instance.loginWithKakaoAccount(activity) { token: OAuthToken?, error: Throwable? ->
                    if (error != null) {
                        continuation.resume(null)
                    } else if (token != null) {
                        continuation.resume(token.accessToken)
                    }
                }

            }
            //continuation.resume(null)
        }
    }

    suspend fun logout() {
        return suspendCancellableCoroutine { continuation ->
            UserApiClient.instance.logout { error ->
                error?.let {
                    continuation.resume(Unit)
                } ?: run {
                    continuation.resume(Unit)
                }
            }
        }
    }

    suspend fun signOut(): Boolean {
        return suspendCancellableCoroutine { continuation ->
            UserApiClient.instance.unlink { error ->
                if (error != null) {
                    continuation.resume(true)
                } else {
                    continuation.resume(false)
                }
            }

        }
    }


    suspend fun getUserInfo(): String? {
        return suspendCancellableCoroutine { continuation ->
            UserApiClient.instance.me { user, error ->
                if (error != null)
                    continuation.resume(null)
                else if (user != null)
                    continuation.resume(user.id?.toString())
                else
                    continuation.resume(null)
            }
        }
    }
}