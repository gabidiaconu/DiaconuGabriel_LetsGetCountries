package com.lgcinterview.letsgetcountries.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lgcinterview.letsgetcountries.data.db.typeconverters.DoubleListStringTypeConverter
import com.lgcinterview.letsgetcountries.data.db.typeconverters.StringOrientedTypeConverters
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "countries", primaryKeys = ["name"])
@JsonClass(generateAdapter = true)
data class Country(

    @Transient
    @field:PrimaryKey(autoGenerate = true)
    var id : Long = 0L,

    @field:Json(name = "name")
    var name : String = "Unknown",

    @field:Json(name = "capital")
    var capital : String = "Unknown",

    @field:Json(name = "region")
    var region : String = "Unknown",

    @field:Json(name = "alpha2Code")
    var alpha2Code : String? = "Unknown",

    @field:Json(name = "alpha3Code")
    var alpha3Code : String? = "Unknown",

    @TypeConverters(StringOrientedTypeConverters::class)
    @field:Json(name = "altSpellings")
    var altSpellings : List<String>? = null,

    @field:Json(name = "relevance")
    var relevance : String? = "Unknown",

    @field:Json(name = "subregion")
    var subregion : String? = "Unknown",

    @Embedded
    @field:Json(name = "translations")
    var translations : Translation? = null,

    @field:Json(name = "population")
    var population : Int? = 0,

    @TypeConverters(DoubleListStringTypeConverter::class)
    @field:Json(name = "latlng")
    var coordinates: List<Double>? = null,

    @field:Json(name = "demonym")
    var demonym : String? = "Unknown",

    @field:Json(name = "area")
    var area : Double? = 0.0,

    @field:Json(name = "gini")
    var gini : Double? = 0.0,

    @TypeConverters(StringOrientedTypeConverters::class)
    @field:Json(name = "timezones")
    var timezones : List<String>? = null,

    @TypeConverters(StringOrientedTypeConverters::class)
    @field:Json(name = "callingCodes")
    var callingCodes : List<String>? = null,

    @TypeConverters(StringOrientedTypeConverters::class)
    @field:Json(name = "currencies")
    var currencies : List<String>? = null,

    @TypeConverters(StringOrientedTypeConverters::class)
    @field:Json(name = "languages")
    var languages : List<String>? = null,

    @TypeConverters(StringOrientedTypeConverters::class)
    @field:Json(name = "borders")
    var borders : List<String>? = null,

    @field:Json(name = "nativeName")
    var nativeName : String? = "Unknown",

    @field:Json(name = "numericCode")
    var numericCode : String? = "Unknown",

    @Transient
    var isFavorite : Boolean = false

) : java.io.Serializable