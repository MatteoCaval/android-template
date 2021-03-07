package com.mcava.samples.data

class SampleRepositoryImpl : SampleRepository {

    override suspend fun sampleMethod(): String {
        return "Prova"
    }

}