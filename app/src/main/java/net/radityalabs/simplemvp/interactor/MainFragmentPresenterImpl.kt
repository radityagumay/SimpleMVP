package net.radityalabs.simplemvp.interactor

import android.content.Context
import android.view.View
import net.radityalabs.simplemvp.presenter.MainFragmentPresenter
import net.radityalabs.simplemvp.view.MainFragmentView

/**
 * Created by radityagumay on 6/17/17.
 */

class MainFragmentPresenterImpl(private val context: Context, private val view: MainFragmentView) :
        MainFragmentPresenter {
    override fun doSomeWork() {
        Thread.sleep(1000)
        view.doSomeWorkSuccess("Hello world")
    }
}