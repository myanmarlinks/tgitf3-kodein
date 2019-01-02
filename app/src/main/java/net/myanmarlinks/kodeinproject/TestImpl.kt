package net.myanmarlinks.kodeinproject

import android.util.Log.d

class TestImpl: Test {
    init {
        d("MY_APP", "Object created!")
    }

    companion object {
        @Volatile private var instance: TestImpl? = null
        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: TestImpl().also { instance = it }
            }
    }
    override fun testCall() {
        d("MY_APP", "Test Call")
    }

    override fun anotherTestCall() {
        d("MY_APP", "Test Another Call")
    }
}