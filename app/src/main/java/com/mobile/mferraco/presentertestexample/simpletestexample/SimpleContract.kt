package com.mobile.mferraco.presentertestexample.simpletestexample

/**
 * Defines the communication between the view and presenter for this component
 */
interface SimpleContract {

    interface View {

        /**
         * Sets the title on the view
         * @param title The string resource to set as the title
         */
        fun setTitleText(title: Int)

        /**
         * Sets the subtitle on the view
         * @param subtitle The string resource to set as the subtitle
         */
        fun setSubtitleText(subtitle: Int)

        /**
         * Updates the view after a successful response from the API
         * @param text The text to update the view with
         */
        fun updateWithSuccess(text: String)

        /**
         * Updates the view after an error response from the API
         * @param text The text to update the view with
         */
        fun updateWithError(text: String)
    }

    interface Presenter {

        /**
         * Binds a specific [View] to this presenter
         * @param view The view to bind
         */
        fun bindView(view: View)

        /**
         * Notifies the presenter that the corresponding view's onCreate method was called
         */
        fun onCreate()

        /**
         * Notifies the presenter that it should retrieve data from the API
         */
        fun getData()
    }
}