package com.proclub.simplemvpdemo.base

abstract class MVPPresenter<V: MVPView> {
    private var view: V? = null

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    fun withView(actions: V.() -> Unit) {
        view?.actions()
    }

    fun getView() = view
}