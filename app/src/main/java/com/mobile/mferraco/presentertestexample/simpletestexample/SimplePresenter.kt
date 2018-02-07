package com.mobile.mferraco.presentertestexample.simpletestexample

import com.mobile.mferraco.presentertestexample.R

/**
 * The presenter holding all business logic for this component
 */
class SimplePresenter(private val fakeAPI: FakeAPI) : SimpleContract.Presenter, FakeApiResponseHandler {

    private lateinit var view: SimpleContract.View

    override fun bindView(view: SimpleContract.View) {
        this.view = view
    }

    override fun onCreate() {
        view.setTitleText(R.string.app_name)
        view.setSubtitleText(R.string.app_name)
    }

    override fun getData() {
        fakeAPI.getData(this)
    }

    override fun onSuccess(response: String) {
        view.updateWithSuccess(response)
    }

    override fun onError(error: String) {
        view.updateWithError(error)
    }
}