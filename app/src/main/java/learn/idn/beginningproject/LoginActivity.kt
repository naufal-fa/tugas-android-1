package learn.idn.beginningproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {

    private lateinit var dataEmail: Array<String>
    private lateinit var dataPassword: Array<String>
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail : EditText = findViewById(R.id.edt_email)
        val edtPassword : EditText = findViewById(R.id.edt_lock)
        val btnLogin : Button = findViewById(R.id.btn_login)
        val btnRegister: Button = findViewById(R.id.btn_register)
        progressBar = findViewById(R.id.progress_bar)
        val forgetPass : TextView = findViewById(R.id.forget_password)
        val radioRemember: RadioButton = findViewById(R.id.rememberme)

        val builder = AlertDialog.Builder(this, R.style.AlertDialog_AppCompat).create()
        builder.setTitle("Harap isi")
        builder.setMessage("Tentukan pilihan anda")
        builder.setIcon(R.drawable.ic_person)
        builder.setCancelable(true)
        builder.show()


        dataEmail = arrayOf("kapa", "paqih", "akbar")
        dataPassword = arrayOf("69", "6969","696969")

        btnLogin.setOnClickListener{
            progressBar?.visibility = View.VISIBLE
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
                progressBar?.visibility = View.GONE
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                progressBar?.visibility = View.GONE
                Toast.makeText(this, "Akun Salah", Toast.LENGTH_SHORT).show()
            }

        }
    }
}