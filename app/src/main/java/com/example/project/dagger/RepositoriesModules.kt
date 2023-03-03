package com.example.project.dagger

import com.example.coreLocal.data.LocalRepository
import com.example.coreLocal.domain.repos.ILocalRepository
import com.example.coreNetwork.domain.repos.INetworkRepository
import com.example.coreNetwork.NetworkRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoriesModule {
    @Singleton
    @Binds
    fun bindILocalRepository(localRepository: LocalRepository): ILocalRepository

    @Singleton
    @Binds
    fun bindINetworkRepository(networkRepository: NetworkRepository): INetworkRepository
}