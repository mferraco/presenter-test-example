package com.mobile.mferraco.presentertestexample.simpletestexample

/**
 * This class is pretending to be an API
 */
class FakeAPI {

    fun getData(handler: FakeApiResponseHandler, shouldError: Boolean = false) {
        // the actual implementation of this method does not matter, because it will all
        // be mocked in the Presenter tests

        if (shouldError) {
            handler.onError("There was an error!")
        } else {
            handler.onSuccess("SUCCESS!")
        }
    }
}

interface FakeApiResponseHandler {
    fun onSuccess(response: String)
    fun onError(error: String)
}