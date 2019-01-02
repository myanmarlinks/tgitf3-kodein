package net.myanmarlinks.kodeinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class SecondActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()
    private val test: Test by instance()
    private val dice: Dice by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            test.testCall()
            dice.randomDice()
        }
    }

}
