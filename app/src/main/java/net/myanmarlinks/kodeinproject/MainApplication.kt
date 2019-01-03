package net.myanmarlinks.kodeinproject

import android.app.Application
import android.util.Log.d
import net.myanmarlinks.kodeinproject.car.Car
import net.myanmarlinks.kodeinproject.car.CarColor
import net.myanmarlinks.kodeinproject.car.CarFactory
import net.myanmarlinks.kodeinproject.car.CarType
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*


class MainApplication: Application(), KodeinAware{
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MainApplication))


        constant(tag = "API_URL") with "https://yourapi.com/api/"


        bind<Test>() with singleton { TestImpl() }


        bind<Dice>() with provider { Dice() }
        bind<Dice>(tag = "diceTwo") with provider { Dice() }

        bind<Car>() with factory { carColor: CarColor,
                                   carType: CarType
            -> CarFactory().create(carColor, carType) }
    }

    override fun onCreate() {
        super.onCreate()
        val k = kodein
        d("MY_APP", k.toString())
    }
}