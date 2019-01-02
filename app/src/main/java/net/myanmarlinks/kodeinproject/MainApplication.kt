package net.myanmarlinks.kodeinproject

import android.app.Application
import android.util.Log.d
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import org.kodein.di.generic.with


class MainApplication: Application(), KodeinAware{
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MainApplication))
        constant(tag = "API_URL") with "https://http://savethelibrarymyanmar.org/api/"
        bind<Test>() with singleton { TestImpl() }
        bind<Dice>() with provider { Dice() }
        bind<Dice>(tag = "diceTwo") with provider { Dice() }
    }

    override fun onCreate() {
        super.onCreate()
        val k = kodein
        d("MY_APP", k.toString())
    }
}