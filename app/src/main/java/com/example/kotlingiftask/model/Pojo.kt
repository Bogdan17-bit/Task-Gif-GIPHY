package com.example.kotlingiftask.model

import com.google.gson.annotations.SerializedName

data class Gif(
    @SerializedName("id")
    var id : String,
    @SerializedName("bitly_url")
    var bitlyUrl : String,
    @SerializedName("images")
    var images : Images
)

data class JsonResponse(
    @SerializedName("data")
    var gifs :List <Gif>
)

data class Images(
    @SerializedName("fixed_height")
    var parameters : Original
)

data class Original(
    @SerializedName("url")
    var url : String
)
