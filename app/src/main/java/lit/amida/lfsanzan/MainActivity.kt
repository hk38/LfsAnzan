package lit.amida.lfsanzan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = setProblem()

        buttonAns.setOnClickListener {
            intent.putExtra("ans", Integer.parseInt(editAns.text.toString()))
            startActivity(intent)
            editAns.setText("")
            intent = setProblem()
        }
    }



    fun setProblem(): Intent {
        val intent = Intent(applicationContext, AnswerActivity::class.java)
        val randOp1 = (0..999).random()
        val randOp2 = (0..999).random()

        textOp1.text = randOp1.toString()
        textOp2.text = randOp2.toString()

        if(Random.nextBoolean()){
            textOt.text = "+"
            intent.putExtra("problem", "$randOp1 + $randOp2 =")
            intent.putExtra("correct", randOp1 + randOp2)
        }else{
            textOt.text = "-"
            intent.putExtra("problem", "$randOp1 - $randOp2 =")
            intent.putExtra("correct", randOp1 - randOp2)
        }

        return intent
    }
}