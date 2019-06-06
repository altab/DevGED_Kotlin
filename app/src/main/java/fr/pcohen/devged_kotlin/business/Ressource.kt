package fr.pcohen.devged_kotlin.business

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDateTime

@Entity
data class Ressource(

    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    val title: String,
    val res: String,
    val date: LocalDateTime,
    val tags: List<String>,
    val type: String

)

enum class Type {
    URL, TEXT
}