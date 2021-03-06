package net.myanmarlinks.kodeinproject

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.myanmarlinks.kodeinproject.car.Car
import net.myanmarlinks.kodeinproject.car.CarColor
import net.myanmarlinks.kodeinproject.car.CarType
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.M
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()
    private val test: Test by instance()
    private val dice: Dice by instance()
    private val diceTwo: Dice by instance(tag = "diceTwo")
    private val inflater: LayoutInflater by instance()

    private val toyotaCar: Car by instance (arg = M(CarColor.GREEN, CarType.Toyota))
    private val mazadaCar: Car by instance(arg = M(CarColor.RED, CarType.Mazada))
    private val nissanCar: Car by instance(arg = M(CarColor.BLUE, CarType.Nissan))

    private val apiUrl: String  by instance(tag = "API_URL")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        d("MY_APP", apiUrl)
        d("MY_CAR", mazadaCar.makeCar())
        d("MY_CAR", toyotaCar.makeCar())
        d("MY_CAR", nissanCar.makeCar())


        fab.setOnClickListener { view ->
            dice.randomDice()
            test.testCall()
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
