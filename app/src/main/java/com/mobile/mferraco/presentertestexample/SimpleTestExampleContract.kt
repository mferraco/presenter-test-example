package com.mobile.mferraco.presentertestexample

/**
 * Defines the communication between the view and presenter for this component
 */
interface SimpleTestExampleContract {

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
         * Sets the view's background color
         * @param color The color resource to use for the background color
         */
        fun setBackgroundColor(color: Int)
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
         * Notifies the presenter that a specific button was clicked on the view
         */
        fun onButtonClick()
    }
}