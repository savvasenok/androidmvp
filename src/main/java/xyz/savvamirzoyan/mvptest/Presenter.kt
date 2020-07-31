package xyz.savvamirzoyan.mvptest

class Presenter(private val mView: MainContract.View) : MainContract.Presenter {
    private val mModel: MainContract.Model

    init {
        this.mModel = Model()
    }

    override fun onSignUpButtonClick() {
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