package com.footstep.dangbal.kotlin.src.main.gallery.info


import android.util.Log
import com.footstep.dangbal.kotlin.config.ApplicationClass
import com.footstep.dangbal.kotlin.config.BaseResponse
import com.footstep.dangbal.kotlin.src.main.feed.models.ReportResponse
import com.footstep.dangbal.kotlin.src.main.feed.models.createReportDto
import com.footstep.dangbal.kotlin.src.main.gallery.GalleryRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GalleryInfoFragmentService(val galleryInfoFragmentInterface: GalleryInfoFragmentInterface) {

    /*
    To Do 3. 게시글 댓글 삭제 API
    */
    fun deletePostComment(comment_id: Int) {
        val GalleryRetrofitInterface =
            ApplicationClass.sRetrofit.create(GalleryRetrofitInterface::class.java)
        GalleryRetrofitInterface.deletePostComment(comment_id).enqueue(object :
            Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                galleryInfoFragmentInterface.onDeletePostCommentSuccess(response.body() as BaseResponse)
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                galleryInfoFragmentInterface.onDeletePostCommentFailure(t.message ?: "통신 오류")
            }
        })
    }

    //댓글 신고 API
    fun ReportComment(comment_id:Int,createReportDto:createReportDto){
        val GalleryRetrofitInterface =
            ApplicationClass.sRetrofit.create(GalleryRetrofitInterface::class.java)
        Log.d("reportProcess", "갤러리 댓글 ReportComment 안쪽직전진입")

        GalleryRetrofitInterface.reportComment(comment_id,createReportDto).enqueue(object :
            Callback<ReportResponse> {

            override fun onResponse(
                call: Call<ReportResponse>,
                response: Response<ReportResponse>
            ) {
                galleryInfoFragmentInterface.onReportCommentSuccess(response.body() as ReportResponse)
                Log.d("reportProcess", "갤러리 댓글 ReportComment onResponse")

            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                galleryInfoFragmentInterface.onReportCommentFailure(t.message ?: "통신 오류")
                Log.d("reportProcess", "갤러리 댓글 ReportComment onFailure")

            }

        })
    }

    //유저 신고 API
    fun ReportUser(user_id:Int,createReportDto:createReportDto){
        val GalleryRetrofitInterface =
            ApplicationClass.sRetrofit.create(GalleryRetrofitInterface::class.java)
        Log.d("reportProcess", "갤러리 댓글유저 ReportUser 안쪽직전진입")

        GalleryRetrofitInterface.reportUser(user_id,createReportDto).enqueue(object :
            Callback<ReportResponse> {

            override fun onResponse(
                call: Call<ReportResponse>,
                response: Response<ReportResponse>
            ) {
                galleryInfoFragmentInterface.onReportUserSuccess(response.body() as ReportResponse)
                Log.d("reportProcess", "갤러리 댓글유저 ReportUser onResponse")

            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                galleryInfoFragmentInterface.onReportUserFailure(t.message ?: "통신 오류")
                Log.d("reportProcess", "갤러리 댓글유저 ReportUser onFailure")

            }

        })
    }
}