package lit.amida.lfsanzan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        textProblem.text = intent.getStringExtra("problem")
        val correct = intent.getIntExtra("correct", 0)
        val ans = intent.getIntExtra("ans", 0)
        textCorrect.text = ans.toString()

        if(correct == ans){
            imageTF.setImageResource(R.drawable.correct_image)
            imageRandy.setImageResource(R.drawable.randy_happy_image)
        }else{
            imageTF.setImageResource(R.drawable.miss_image)
            imageRandy.setImageResource(R.drawable.randy_sad_image)
        }

        buttonFinish.setOnClickListener { finish() }

    }
}