package com.mcava.samples.data

interface SampleRepository {
    suspend fun sampleMethod(): String
}