package com.mycomp.sampleidea.data.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "simple_idea")
data class SampleIdeaEntry(
    @ColumnInfo(name = "name")
    val name:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}