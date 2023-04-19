package com.example.mka.LoginRegister


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.mka.*
import com.example.mka.Api.ApiService
import com.example.mka.Api.LoginAPI
import com.example.mka.Api.LoginResponse
import com.example.mka.MenuHome.HomeActivity
import com.example.mka.databinding.ActivityLoginBinding
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.prefs.PreferencesFactory

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inisialisasi View Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengikat elemen-elemen pada layout file
        val username = binding.masukEmail.text.toString()
        val password = binding.masukPassword.text.toString()
        val loginButton = binding.btnMasuk

        // Implementasi event klik pada tombol login
        loginButton.setOnClickListener {
            // Panggil fungsi login API
            login(username, password)
        }
        binding.tvHaveAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        binding.btnGoogle.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.btnLupaKataSandi.setOnClickListener {
            startActivity(Intent(this, LupaKataSandiActivity::class.java))
        }
    }


    private fun login(username: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8089/v1/student/login/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(LoginAPI::class.java)

        val call = api.login(username, password)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                // Tangani respons dari server
                Toast.makeText(this@LoginActivity, "Login success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // Tangani kesalahan koneksi
                Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
            }
        })
    }

}



/*private fun login(username: String, password: String) {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://your-login-api-url.com")
        .post(RequestBody.create(
            "application/json".toMediaTypeOrNull(),
            getRequestBody(username, password)
        ))
        .build()

    client.newCall(request).enqueue(object : Callback, okhttp3.Callback {
        override fun onResponse(call: Call, response: Response) {
            val responseString = response.body()?.string()
            runOnUiThread {
                try {
                    val jsonObject = JSONObject(responseString)
                    if (jsonObject.getBoolean("success")) {
                        // login success
                        Toast.makeText(this@LoginActivity, "Login success", Toast.LENGTH_SHORT).show()
                    } else {
                        // login failed
                        Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
        }

        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
            runOnUiThread {
                Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
    })
}

private fun getRequestBody(username: String, password: String): String {
    val jsonObject = JSONObject()
    jsonObject.put("username", username)
    jsonObject.put("password", password)
    return jsonObject.toString()
}
}

    /*initAction()

    /*btn_google.setOnClickListener {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
    btn_lupa_kata_sandi.setOnClickListener {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
    tv_have_account.setOnClickListener{
        startActivity(Intent(this, RegisterActivity::class.java))
    }
     */

}
fun initAction(){
    binding.btnMasuk.setOnClickListener {
        masuk()
    }
}
fun masuk(){
    val request = UserRequest()
    request.email = MasukEmail.text.toString().trim()
    request.password = masukKataSandi.text.toString().trim()

    val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
    retro.login(request).enqueue(object : Callback<UserResponse>{
        override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            Log.e("Error", t.message.toString())
        }

        override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
            val user = response.body()
            user!!.data?.token?.let { Log.e("token", it) }
            user!!.data?.token?.let { Log.e("email", it) }
        }

    })
}

}


/*
private fun masuk() {

val email = MasukEmail.text.toString()
val password = masukKataSandi.text.toString()

if (email.isEmpty()){
    MasukEmail.error = "Email harus diisi"
    return
}
if (password.isEmpty()){
    masukKataSandi.error = "Password harus diisi"
    return
}
ApiConfig.instanceRetrofit.login(email, password)
    .enqueue(object : Callback<ResponseUser>{
        override fun onResponse(
            call: Call<ResponseUser>,
            response: Response<ResponseUser>
        ){
            val response = response.body()

            if (response != null){
                if (response.status == 0){
                    Toast.makeText(this@LoginActivity, response.message, Toast.LENGTH_SHORT).show()
                }else {
                    sph.setStatusLogin(true)
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }
            }
        }

        override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
            Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT)
                .show()
        }
    })

}

}
*/
/*
fun masuk(){
    val request = UserRequest()
    request.email =MasukEmail.text.toString().trim()
    request.password = masukKataSandi.text.toString().trim()

    val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
    retro.login(request).enqueue(object : Callback<UserResponse>{
        override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
            val user = response.body()
            Log.e("token", user!!.data?.token.toString())
            Log.e("email", user!!.data?.token.toString())
        }

        override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            Log.e("Error", t.message.toString())
        }
    })
}
*/