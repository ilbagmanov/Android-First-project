package com.example.itisdemo.helpClasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize /*Android studio предложил это добавить, чтобы можно было отправлять во второй экран*/
class DataBase(
    var login: String,
    var password: String,
    var name: String,
    var surname: String,
    var imgPath: String) : Parcelable {
}