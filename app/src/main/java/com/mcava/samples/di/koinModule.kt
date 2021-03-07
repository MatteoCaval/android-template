package com.mcava.samples.di

import com.mcava.samples.data.SampleRepository
import com.mcava.samples.data.SampleRepositoryImpl
import com.mcava.samples.domain.SampleUseCase
import com.mcava.samples.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        SampleRepositoryImpl() as SampleRepository
    }

    single {
        SampleUseCase(get())
    }


    viewModel {
        HomeViewModel(get())
    }

}