package com.android.layout.bean

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class Crime(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var solver: Boolean = false
)
//data class Crime(
//    var id: UUID = UUID.randomUUID(),
//    var title: String = "",
//    var date: Date = Date(),
//    var solver: Boolean = false
//) {
//    companion object {
//        val defaultList: MutableList<Crime>
//            get() {
//                val crimeList = mutableListOf<Crime>()
//                for (i in 0..100) {
//                    val crimeInfo = Crime(
//                        i, "Crime # ${i.toString()}",
//                        Date(),
//                        i % 2 == 0
//                    )
//
//                    crimeList.add(crimeInfo)
//                }
//
//                return crimeList
//            }
//
//    }
//}