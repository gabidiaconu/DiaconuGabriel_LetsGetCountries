package com.lgcinterview.letsgetcountries.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "translations")
@JsonClass(generateAdapter = true)
data class Translation(

    @field:PrimaryKey(autoGenerate = true)
    var translationId : Long = 0L,

    @field:Json(name = "de")
    var deutchTranslation : String? = "Unknown",

    @field:Json(name = "es")
    var spanishTranslation : String? = "Unknown",

    @field:Json(name = "fr")
    var frenchTranslation : String? = "Unknown",

    @field:Json(name = "ja")
    var japaneseTranslation : String? = "Unknown",

    @field:Json(name = "it")
    var italianTranslation : String? = "Unknown"
)