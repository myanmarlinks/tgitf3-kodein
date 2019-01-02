package net.myanmarlinks.kodeinproject

import android.util.Log.d
import java.util.*

class Dice {
    init {
        d("MY_APP", "Dice Created!")
    }
    fun randomDice() {
        d("MY_APP", Random().nextInt().toString())
    }
}