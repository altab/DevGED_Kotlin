package fr.pcohen.devged_kotlin.business

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Search(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val title: String,
    val res: String,
    val date: Date,
    val tags: List<String>,
    val type: String

)