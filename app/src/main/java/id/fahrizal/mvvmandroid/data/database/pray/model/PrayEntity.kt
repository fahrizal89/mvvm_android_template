package id.fahrizal.mvvmandroid.data.database.pray.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pray")
class PrayEntity(
    @PrimaryKey
    val id: Long? = null,
    val city: String = "",
    val name: String,
    val time: Long
)