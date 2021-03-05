package mx.com.satoritech.web

import com.google.gson.GsonBuilder
import mx.com.satoritech.web.api.serializers.BooleanDeserializer
import mx.com.satoritech.web.api.serializers.BooleanSerializer
import mx.com.satoritech.web.api.serializers.DateDeserializer
import mx.com.satoritech.web.api.serializers.DateSerializer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object APIDataLol {
    private const val TAG = "API_DATA_LOL"
//    private val apiService: DataLolService

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        //Prepare http client
        val httpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

        // Prepare Gson instance
        val gson = GsonBuilder()
            .registerTypeAdapter(Boolean::class.java, BooleanSerializer())
            .registerTypeAdapter(Boolean::class.java, BooleanDeserializer())
            .registerTypeAdapter(Boolean::class.javaPrimitiveType, BooleanSerializer())
            .registerTypeAdapter(Boolean::class.javaPrimitiveType, BooleanDeserializer())
            .registerTypeAdapter(Date::class.java, DateSerializer())
            .registerTypeAdapter(Date::class.java, DateDeserializer())
            .create()

        //Prepare retrofit instance
//        val retrofit = Retrofit.Builder()
//                .baseUrl(BuildConfig.API_BASE)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(httpClietBuilder.build())
//                .build()
    }
}