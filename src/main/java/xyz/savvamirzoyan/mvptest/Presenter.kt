package xyz.savvamirzoyan.mvptest

import android.util.Log


class Presenter(private val mView: MainContract.View) : MainContract.Presenter {
    private val TAG = "MainContract.Presenter"

    private val mModel: MainContract.Model

    init {
        this.mModel = Model()
    }

    override fun onSignUpButtonClick() {
        Log.d(TAG, "received signUpButton click")
        val (username, password) = mView.getSignUpUsernamePassword()
        val result = mModel.addUser(username, password)

        if (result) {
            mView.successfulSignedUp()
            mView.clearSignUpET()
        } else {
            mView.userAlreadyExists()
        }
    }

    override fun onLogInButtonClick() {
        Log.d(TAG, "received logInButton click")
        val (username, password) = mView.getLogInUsernamePassword()
        val result = mModel.checkPassword(username, password)

        if (result) {
            mView.successfulLogIn()
            mView.clearLogInET()
        } else {
            mView.wrongUsernameOrPassword()
        }
    }

}