package ru.geekbrains.universe

class MainPresenter(
    val view: MainView, val model: CountersModel
) {

    init {
        view.showCounterOne(counter = "0")
        view.showCounterTwo(counter = "0")
        view.showCounterThree(counter = "0")
    }

    fun countPlus1() {
        view.showCounterOne((++model[0]).toString())
    }

    fun countPlus2() {
        view.showCounterTwo((++model[1]).toString())
    }

    fun countPlus3() {
        view.showCounterThree((++model[2]).toString())
    }

}