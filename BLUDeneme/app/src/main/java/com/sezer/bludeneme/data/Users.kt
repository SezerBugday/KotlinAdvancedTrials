package com.sezer.bludeneme.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity (tableName = "user_table")
class Users (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") @NotNull var id: Int,
                     @ColumnInfo(name = "IsMan") @NotNull var IsMan: Int,
             @ColumnInfo(name = "IsLookingForMan") @NotNull var IsLookingForMan: Int,
             @ColumnInfo(name = "FriendsToTalk") @NotNull var FriendsToTalk: Int,
             @ColumnInfo(name = "LongRelationsship") @NotNull var LongRelationsship: Int,
             @ColumnInfo(name = "TouristInTown") @NotNull var TouristInTown: Int,
             @ColumnInfo(name = "JustSexualIntentions") @NotNull var JustSexualIntentions: Int,
)
{

}
