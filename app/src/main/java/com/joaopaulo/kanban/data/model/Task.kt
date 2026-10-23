package com.joaopaulo.kanban.data.model
//verificar o parcelize!//
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class Task (
    val id: String,
    val description: String
    val status: Status = Status.TODO
): Parcelable