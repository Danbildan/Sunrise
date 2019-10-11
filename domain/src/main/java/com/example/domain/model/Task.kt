package com.example.domain.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "status") val status: Int)