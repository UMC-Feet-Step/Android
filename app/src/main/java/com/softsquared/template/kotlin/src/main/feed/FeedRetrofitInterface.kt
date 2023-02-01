package com.softsquared.template.kotlin.src.main.feed

import com.softsquared.template.kotlin.src.main.feed.models.FeedListResponse
import retrofit2.http.GET
import retrofit2.Call

interface FeedRetrofitInterface {

    /*
        To Do 1. 타 유저 피드 리스트 조회 API
     */
    @GET("/footstep/feed")
    fun getFeedList() : Call<FeedListResponse>


    /*
        To Do 2. 피드 - 특정 피드 상세 조회 API
     */
    // GalleryRetrofitInterface에서 사용하여 피드 레트로핏에는 생략구현

    /*
        To Do 3. 피드 - 특정 유저 피드 리스트 조회 API
    */


}