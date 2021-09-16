package learn.idn.beginningproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataEmail: Array<String>
    private lateinit var dataPassword: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtEmail : EditText = findViewById(R.id.edt_email)
        val edtPassword : EditText = findViewById(R.id.edt_lock)
        val btnLogin : Button = findViewById(R.id.btn_login)
        val btnRegister: Button = findViewById(R.id.btn_register)
        val forgetPass : TextView = findViewById(R.id.forget_password)
        val radioRemember: RadioButton = findViewById(R.id.rememberme)


        dataEmail = arrayOf("kapa", "paqih", "akbar")
        dataPassword = arrayOf("69", "6969","696969")

        btnLogin.setOnClickListener{
            signIn(edtEmail.text.toString(),edtPassword.text.toString())
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
    fun signIn(email: String, password: String)
    {
        for(i in dataEmail.indices){
            val takeDataEmail = dataEmail.get(i)
            val takeDataPass = dataPassword.get(i)
            if(takeDataEmail == email && takeDataPass == password) {
                Toast.makeText(this, "LogedIn", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(this, "Akun Salah", Toast.LENGTH_SHORT).show()
            }

        }
    }
}