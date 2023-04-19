package com.example.mka.LoginRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mka.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.masukDisini.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
// binding.btnMasukDaftar.setOnClickListener {
// // Do register API request
// val namaLengkap = binding.daftarNamaLengkap.text.toString()
// val email = binding.daftarEmail.text.toString()
// val password = binding.daftarKataSandi.text.toString()
// val batch = binding.daftarBatch.text.toString()
// val divisi = binding.daftarDivisi.text.toString()
// val asalKampus = binding.daftarAsalKampus.text.toString()
//
// if (namaLengkap.isEmpty() || email.isEmpty() || password.isEmpty() || batch.isEmpty() || divisi.isEmpty() || asalKampus.isEmpty()) {
// Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
// return@setOnClickListener
// }
//
// // Buat objek request untuk API register
// val request = RegisterRequest(namaLengkap, email, password, batch, divisi, asalKampus)
//
// // Lakukan request ke API
// ApiService.create().register(request)
// .enqueue(object : Callback<RegisterResponse> {
// override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
// if (response.isSuccessful) {
// val registerResponse = response.body()
// Toast.makeText(this@RegisterActivity, "Register success", Toast.LENGTH_SHORT).show()
// // inisialisasi intent
// val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
// startActivity(intent)
// finish()
//
// } else {
// val errorBody = response.errorBody()?.string()
// Toast.makeText(this@RegisterActivity, errorBody, Toast.LENGTH_SHORT).show()
// }
// }
//
// override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
// Toast.makeText(this@RegisterActivity, "Register failed", Toast.LENGTH_SHORT).show()
// }
// })
// }
// }
//
// object ApiService {
// private const val BASE_URL = "http://127.0.0.1:8089/v1/student/register/"
//
// private val client = OkHttpClient.Builder()
// .addInterceptor(HttpLoggingInterceptor().apply {
// level = HttpLoggingInterceptor.Level.BODY
// })
// .build()
//
// private val retrofit = Retrofit.Builder()
// .baseUrl(BASE_URL)
// .client(client)
// .addConverterFactory(GsonConverterFactory.create())
// .build()
//
// fun create(): com.example.mka.Api.ApiService {
// return retrofit.create(ApiService::class.java)
// }
// }