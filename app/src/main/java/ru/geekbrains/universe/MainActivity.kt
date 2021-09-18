package ru.geekbrains.universe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.geekbrains.universe.R.layout.activity_main

class MainActivity : AppCompatActivity(activity_main), MainView {

    private val presenter: MainPresenter by lazy {
        MainPresenter(view = this, model = CountersModel)
    }

    private val buttonCounter1: Button by lazy { findViewById(R.id.btn_counter1) }
    private val buttonCounter2: Button by lazy { findViewById(R.id.btn_counter2) }
    private val buttonCounter3: Button by lazy { findViewById(R.id.btn_counter3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        buttonCounter1.setOnClickListener { presenter.countPlus1() }
        buttonCounter2.setOnClickListener { presenter.countPlus2() }
        buttonCounter3.setOnClickListener { presenter.countPlus3() }
    }

    override fun showCounterOne(counter: String) {
        buttonCounter1.text = counter
    }

    override fun showCounterTwo(counter: String) {
        buttonCounter2.text = counter
    }

    override fun showCounterThree(counter: String) {
        buttonCounter3.text = counter
    }

}