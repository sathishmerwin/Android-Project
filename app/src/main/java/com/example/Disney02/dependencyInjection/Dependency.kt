package com.example.Disney02.dependencyInjection

import android.content.Context
import com.example.Disney02.retroData.ApiInterface
import com.example.Disney02.roomDb.RoomApp
import com.example.Disney02.roomDb.RoomDaoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Dependency {

    @Provides
    fun providBaseUrl():String = "https://makeup-api.herokuapp.com/"

    @Provides
    fun provideRetrofitBuilder(baseUrl:String):Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit):ApiInterface =
        retrofit.create(ApiInterface::class.java)


    @Provides
    @Singleton
    fun providesDatabseBuilder(
        @ApplicationContext context: Context
    ): RoomApp = RoomApp.getDataBase(context)

    @Provides
    fun providesrepository(Database: RoomApp):RoomDaoImp = RoomDaoImp(Database.deo())


}