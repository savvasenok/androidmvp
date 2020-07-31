package xyz.savvamirzoyan.mvptest

class Model : MainContract.Model {
    private val userMap = mutableMapOf<String, User>()

    override fun addUser(username: String, password: String): Boolean {
        if (userMap[username] == null) {
            this.userMap[username] = User(username, password)
            return true
        }
        return false
    }

    override fun checkPassword(username: String, password: String): Boolean =
        userMap[username]?.password == password
}