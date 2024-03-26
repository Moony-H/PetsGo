package com.moony.kakao_login

import android.app.Activity

interface KakaoLoginRepository {
    suspend fun login(activity: Activity): String?
    suspend fun logout()
    suspend fun signOut(): Boolean
    suspend fun getUserInfo(): String?

}