package com.mobile.mferraco.presentertestexample.simpletestexample

import com.mobile.mferraco.presentertestexample.R
import com.nhaarman.mockito_kotlin.*
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`


/**
 * Tests for [SimplePresenter]
 */
class SimplePresenterTest {

    private val view: SimpleContract.View = mock()
    private val fakeApi: FakeAPI = mock()
    private lateinit var presenter: SimplePresenter

    @Before
    fun setup() {
        presenter = SimplePresenter(fakeApi)
        presenter.bindView(view)
    }

    @Test
    fun testOnCreate() {
        presenter.onCreate()

        verify(view).setTitleText(any())
        verify(view).setSubtitleText(any())
    }

    @Test
    fun testOnCreate_inOrder() {
        presenter.onCreate()

        inOrder(view) {
            verify(view).setTitleText(any())
            verify(view).setSubtitleText(any())
        }
    }

    @Test
    fun testOnCreate_captureParameters() {
        presenter.onCreate()

        argumentCaptor<Int>().apply {
            verify(view).setTitleText(capture())
            Assert.assertEquals(R.string.app_name, firstValue)
        }
    }

    @Test
    fun testGetData_success() {
        `when`(fakeApi.getData(presenter)).thenAnswer { presenter.onSuccess("success") }

        presenter.getData()

        inOrder(fakeApi, view) {
            verify(fakeApi).getData(presenter)
            verify(view).updateWithSuccess("success")
        }
    }

    @Test
    fun testGetData_failure() {
        `when`(fakeApi.getData(presenter)).thenAnswer { presenter.onError("error") }

        presenter.getData()

        inOrder(fakeApi, view) {
            verify(fakeApi).getData(presenter)
            verify(view).updateWithError("error")
        }
    }
}