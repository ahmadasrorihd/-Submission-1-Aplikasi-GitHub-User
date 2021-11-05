package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("users")
    val username: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("avatar")
    val avatar: String?,

    @SerializedName("company")
    val company: String?,

    @SerializedName("location")
    val location: String?,

    @SerializedName("repository")
    val repository: Int,

    @SerializedName("follower")
    val follower: Int,

    @SerializedName("following")
    val following: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(name)
        parcel.writeString(avatar)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeInt(repository)
        parcel.writeInt(follower)
        parcel.writeInt(following)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserData> {
        override fun createFromParcel(parcel: Parcel): UserData {
            return UserData(parcel)
        }

        override fun newArray(size: Int): Array<UserData?> {
            return arrayOfNulls(size)
        }
    }
}

