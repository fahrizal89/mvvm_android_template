package id.fahrizal.mvvmandroid.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.fahrizal.mvvmandroid.data.database.pray.MyRoomDatabase
import id.fahrizal.mvvmandroid.data.database.pray.dao.PrayDao

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DB_NAME = "fahrizal_db"

    @Provides
    fun provideMyRoomDatabase(@ApplicationContext context: Context): MyRoomDatabase {
        return Room.databaseBuilder(
            context,
            MyRoomDatabase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    fun providePrayDao(myRoomDatabase: MyRoomDatabase): PrayDao {
        return myRoomDatabase.prayDao()
    }
}