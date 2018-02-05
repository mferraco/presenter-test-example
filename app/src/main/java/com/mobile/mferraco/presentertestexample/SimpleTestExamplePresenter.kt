package com.mobile.mferraco.presentertestexample

/**
 * The presenter holding all business logic for this component
 */
class SimpleTestExamplePresenter : SimpleTestExampleContract.Presenter {

    private lateinit var view: SimpleTestExampleContract.View

    override fun bindView(view: SimpleTestExampleContract.View) {
        this.view = view
    }

    override fun onCreate() {
        view.setTitleText(R.string.app_name)
        view.setSubtitleText(R.string.app_name)
    }

    override fun onButtonClick() {
        view.setBackgroundColor(R.color.colorPrimary)
    }
}