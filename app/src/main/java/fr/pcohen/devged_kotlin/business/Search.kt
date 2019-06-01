package fr.pcohen.devged_kotlin.business

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Search(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var title: String,
    var res: String,
    var date: Date,
    var tags: List<String>,
    var type: String

)