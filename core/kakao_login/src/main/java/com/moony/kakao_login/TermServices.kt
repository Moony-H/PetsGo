package com.moony.kakao_login

internal enum class TermServices(private val key: String) {
    NICKNAME("profile_nickname"), IMAGE("profile_image");

    companion object{
        fun getServiceKeyList(mask:Int):List<String>{
            val resultList= arrayListOf<String>()
            for(i in 0 until entries.size){
                if(mask and (1 shl i)!=0)
                    resultList.add(entries[i].key)
            }
            return resultList
        }
    }
}