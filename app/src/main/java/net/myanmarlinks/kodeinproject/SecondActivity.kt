package net.myanmarlinks.kodeinproject

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import net.myanmarlinks.kodeinproject.car.Car
import net.myanmarlinks.kodeinproject.car.CarColor
import net.myanmarlinks.kodeinproject.car.CarType
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.M
import org.kodein.di.generic.instance

class SecondActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()
    private val test: Test by instance()
    private val dice: Dice by instance()
    private val mazadaCar: Car by instance(M(CarColor.RED, CarType.Mazada))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        d("MY_CAR", mazadaCar.makeCar())

        fab.setOnClickListener { view ->
            test.testCall()
            dice.randomDice()
        }
    }

}
