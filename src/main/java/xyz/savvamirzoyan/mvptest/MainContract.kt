package xyz.savvamirzoyan.mvptest

interface MainContract {
    interface View {
        fun userAlreadyExists()
        fun successfulSignedUp()

        fun wrongUsernameOrPassword()
        fun successfulLogIn()

        fun getSignUpUsernamePassword(): Pair<String, String>
        fun getLogInUsernamePassword(): Pair<String, String>

        fun clearSignUpET()
        fun clearLogInET()
    }

    interface Presenter {
        fun onSignUpButtonClick()
        fun onLogInButtonClick()
    }

    interface Model {
        fun addUser(username: String, password: String): Boolean
        fun checkPassword(username: String, password: String): Boolean
    }
}