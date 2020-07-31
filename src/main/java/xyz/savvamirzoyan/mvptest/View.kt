package xyz.savvamirzoyan.mvptest

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MainContract.View {

    private val TAG = "MainContract.View"

    private val presenter: Presenter = Presenter(this)

    private lateinit var signUpButton: Button
    private lateinit var logInButton: Button

    private lateinit var usernameLogInET: EditText
    private lateinit var passwordLogInET: EditText
    private lateinit var usernameSignUpET: EditText
    private lateinit var passwordSignUpET: EditText

    private lateinit var signUpTV: TextView
    private lateinit var logInTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buttons
        signUpButton = findViewById(R.id.signup_button)
        logInButton = findViewById(R.id.login_button)

        // EditTexts
        usernameLogInET = findViewById(R.id.username_login_edittext)
        passwordLogInET = findViewById(R.id.password_login_edittext)
        usernameSignUpET = findViewById(R.id.username_signup_edittext)
        passwordSignUpET = findViewById(R.id.password_signup_edittext)

        // TextViews
        signUpTV = findViewById(R.id.result_signup)
        logInTV = findViewById(R.id.result_login)


        signUpButton.setOnClickListener {
            presenter.onSignUpButtonClick()
        }
        logInButton.setOnClickListener {
            presenter.onLogInButtonClick()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun userAlreadyExists() {
        Log.d(TAG, "display userAlreadyExists")
        signUpTV.text = "Cannot create user. User already exists"
    }

    @SuppressLint("SetTextI18n")
    override fun successfulSignedUp() {
        Log.d(TAG, "display successfulSignedUp")
        signUpTV.text = "New user has been created!"
    }

    @SuppressLint("SetTextI18n")
    override fun wrongUsernameOrPassword() {
        Log.d(TAG, "display wrongUsernameOrPassword")
        logInTV.text = "Wrong username or password"
    }

    @SuppressLint("SetTextI18n")
    override fun successfulLogIn() {
        Log.d(TAG, "display successfulLogIn")
        logInTV.text = "Successfully logged in"
    }


    override fun getSignUpUsernamePassword(): Pair<String, String> {
        return Pair(usernameSignUpET.text.toString(), passwordSignUpET.text.toString())
    }

    override fun getLogInUsernamePassword(): Pair<String, String> {
        return Pair(usernameLogInET.text.toString(), passwordLogInET.text.toString())
    }


    override fun clearSignUpET() {
        usernameSignUpET.text.clear()
        passwordSignUpET.text.clear()
    }

    override fun clearLogInET() {
        usernameLogInET.text.clear()
        passwordLogInET.text.clear()
    }


}
