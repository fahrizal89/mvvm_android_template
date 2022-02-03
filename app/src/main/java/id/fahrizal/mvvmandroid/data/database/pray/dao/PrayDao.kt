package id.fahrizal.mvvmandroid.data.database.pray.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.fahrizal.mvvmandroid.data.database.pray.model.PrayEntity

@Dao
interface PrayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: List<PrayEntity>)

    @Query("SELECT * FROM pray WHERE city = :city AND time >= :from AND time <= :to")
    fun getPraySchedule(city: String, from: Long, to: Long): List<PrayEntity>

}