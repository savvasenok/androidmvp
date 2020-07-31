package xyz.savvamirzoyan.mvptest

import android.util.Log

class Model : MainContract.Model {
    private val TAG = "MainContract.Model"

    private val userMap = mutableMapOf<String, User>()

    override fun addUser(username: String, password: String): Boolean {
        Log.d(TAG, "adding new user")
        if (userMap[username] == null) {
            this.userMap[username] = User(username, password)
            return true
        }
        return false
    }

    override fun checkPassword(username: String, password: String): Boolean {
        Log.d(TAG, "checking password")
        val user = userMap[username]
        return (user?.username == username) and (user?.password == password)
    }
}