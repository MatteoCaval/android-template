package com.mcava.samples.domain

import com.mcava.samples.data.SampleRepository

class SampleUseCase(private val sampleRepository: SampleRepository) {

    suspend operator fun invoke(): String {
        return this.sampleRepository.sampleMethod()
    }

}