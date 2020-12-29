package com.android.layout.bean

import androidx.lifecycle.ViewModel
import com.android.layout.CrimeRepository

class CrimeListViewModel : ViewModel() {
//    val crimes = mutableListOf<Crime>()
//
//    init {
//        for (i in 0 until 100) {
//            val crime = Crime()
//            crime.title = "Crime #$i"
//            crime.solver = i % 2 == 0
//            crimes += crime
//        }
//    }

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()

    fun addCrime() {
        for (i in 0 until 100) {
            val crime = Crime()
            crime.title = "Crime #$i"
            crime.solver = i % 2 == 0
            crimeRepository.addCrime(crime)
        }

    }
}