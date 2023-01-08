package com.example.rickmortyv3.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.rickmortyv3.data.loca_db.AppDatabase
import com.example.rickmortyv3.data.remote_db.CharacterService
import com.example.rickmortyv3.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGson() : Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideRetrofit(gson : Gson) : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideCharacterService(retrofit: Retrofit) : CharacterService =
        retrofit.create(CharacterService::class.java)



    @Provides
    @Singleton
    fun provideLocalDataBase(@ApplicationContext appContext : Context) : AppDatabase =
        AppDatabase.getDatabase(appContext)

    @Provides
    @Singleton
    fun provideCharacterDao(database: AppDatabase) = database.characterDao()

//    @Singleton
//    @Provides
//    fun provideFavCharacterDatabase(
//        @ApplicationContext app:Context
//    ) = Room.databaseBuilder(
//        app,
//        FavoriteCharacterDatabase::class.java,
//        "charcater_db"
//    ).build()
//
//    @Singleton
//    @Provides
//    fun provideFavCharacterDao(db: FavoriteCharacterDatabase) = db.getFavoriteCharacterDao()


}