package com.lgcinterview.letsgetcountries.data.db.dao

import androidx.room.*
import com.lgcinterview.letsgetcountries.data.models.Translation

@Dao
interface TranslationDao {

    @Update
    suspend fun updateTranslation(translation: Translation)

    @Query("DELETE FROM translations ")
    suspend fun deleteAllTranslations()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(translations: List<Translation>)

    @Transaction
    suspend fun deleteAllAndInsert(translations: List<Translation>) {
        deleteAllTranslations()
        insertList(translations)
    }

}