package ru.geekbrains.universe.presentation.converter

import android.net.Uri
import android.view.View
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.universe.data.ConverterRepository

class ConverterPresenter(

    private val repository: ConverterRepository,
) : MvpPresenter<ConverterView>() {
    private val disposable = CompositeDisposable()

    fun selectImage(view: View) {
        viewState.pickImage()
    }

    fun convertImage(uri: Uri?) {
        disposable.add(
            repository.convert(uri)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    viewState::showSuccess,
                    viewState::showError,
                    viewState::showEmpty,
                )
        )
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}