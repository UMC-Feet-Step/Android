package com.softsquared.template.kotlin.src.main.feed.models

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse

data class ReportResponse(
    @SerializedName("result") val result: String
):BaseResponse()
