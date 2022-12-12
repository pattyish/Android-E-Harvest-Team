package com.eharvest.cmu.di

import android.app.Application
import android.content.Context
import com.eharvest.cmu.data.local.DataStoreOperationImpl
import com.eharvest.cmu.data.remote.repositoryImpl.FirebaseRepositoryImpl
import com.eharvest.cmu.data.remote.repositoryImpl.GoogleSignInRepositoryImpl
import com.eharvest.cmu.domain.repository.DataStoreOperation
import com.eharvest.cmu.domain.repository.FirebaseRepository
import com.eharvest.cmu.domain.repository.GoogleSignInRepository
import com.eharvest.cmu.presentaion.order_screen.OrderUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Singleton
    @Provides
    fun provideFirebaseRealtimeDatabase(
    ): FirebaseDatabase {
        return FirebaseDatabase.getInstance("https://jetbee-5f678-default-rtdb.asia-southeast1.firebasedatabase.app/")
    }

    @Provides
    @Singleton
    fun provideFirebaseAuthentication() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesFireStore() = Firebase.firestore


    @Provides
    @Singleton
    fun providesFirebaseRepository(
        firestore: FirebaseFirestore,
        firebaseAuth: FirebaseAuth, firebaseDatabase: FirebaseDatabase
    ): FirebaseRepository {
        return FirebaseRepositoryImpl(
            fireStore = firestore,
            firebaseAuth = firebaseAuth,
            firebaseRealTimeDatabase = firebaseDatabase
        )
    }

    @Singleton
    @Provides
    fun provideAddOrdersUseCase(
        ordersRepository: FirebaseRepository,
        application: Application,
    ): OrderUseCase {
        return OrderUseCase(
            application = application, firebaseRepository = ordersRepository
        )
    }

    @Provides
    @Singleton
    fun provideDataStoreImpl(@ApplicationContext context: Context): DataStoreOperation {
        return DataStoreOperationImpl(context)
    }


    @Provides
    @Singleton
    fun providesGoogleSignInRepository(
        auth: FirebaseAuth,
        fireStore: FirebaseFirestore
    ): GoogleSignInRepository {
        return GoogleSignInRepositoryImpl(
            firebaseAuth = auth,
            fireStore = fireStore

        )
    }
}



