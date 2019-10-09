package com.example.sunrise.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.sunrise.R
import com.example.sunrise.ui.ApplicationActivity

class LoginFragment : MvpAppCompatFragment(), LoginView{


    @InjectPresenter
    lateinit var  presenter:  LoginPresenter

    lateinit var passwordEditText: EditText
    lateinit var loginEditText: EditText
    lateinit var loadingView :SwipeRefreshLayout



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_login, container, false)
        loadingView = v.findViewById(R.id.loading)
        loadingView.isEnabled = false

        passwordEditText = v.findViewById(R.id.enter_password_editText)
        loginEditText = v.findViewById(R.id.enter_login_editText)

        v.findViewById<Button>(R.id.registration_logAct_button).setOnClickListener {
            presenter.registration()
        }

        v.findViewById<Button>(R.id.log_in_button).setOnClickListener {
            presenter.login(loginEditText.text.toString()
                , passwordEditText.text.toString())
        }
        return v

    }

    override fun showDesk() {
        getAppActivity()?.showDeskScreen()  //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(errorMessage: String) {

        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
        //TODO сделай пакрасате
    }

    override fun showLoading() {
        loadingView.isRefreshing = true

    }

    override fun hideLoading() {
        loadingView.isRefreshing = false


    }

    override fun showRegistrationScreen() {
        getAppActivity()?.showRegistrationScreen()
    }

    private fun getAppActivity(): ApplicationActivity?{
        return activity as? ApplicationActivity
    }

}