package com.android.layout.bean

import androidx.lifecycle.*
import com.android.layout.CrimeRepository
import java.util.*

class CrimeDetailViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    var crimeLiveData: LiveData<Crime?> = Transformations.switchMap(crimeIdLiveData) { crimeId ->
        crimeRepository.getCrime(crimeId)
    }

    fun loadCrime(crimeId: UUID) {
        crimeIdLiveData.value = crimeId
    }

    fun saveCrime(crime: Crime) {
        crimeRepository.updateCrime(crime)
    }


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
}