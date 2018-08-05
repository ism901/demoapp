package com.example.server.kbcpractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Kbcactivity extends AppCompatActivity {

    int mCurrentIndex = 0;
    TextView tv;
    TextView tvind;
    RadioButton rd1, rd2, rd3, rd4;
    Button btnnext, btncheck;
    int index=1;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_text),
            new Question(R.string.question_text2),
            new Question(R.string.question_text3),
            new Question(R.string.question_text4),
            new Question(R.string.question_text5),

    };
    private Option1[] option1= new Option1[]{
            new Option1(R.string.option_1),
            new Option1(R.string.option2_1),
            new Option1(R.string.option3_1),
            new Option1(R.string.option4_1),
            new Option1(R.string.option5_1),

    };
    private Option2[] option2= new Option2[]{
            new Option2(R.string.option_2),
            new Option2(R.string.option2_2),
            new Option2(R.string.option3_2),
            new Option2(R.string.option4_2),
            new Option2(R.string.option5_2),

    };
    private Option3[] option3= new Option3[]{
            new Option3(R.string.option_3),
            new Option3(R.string.option2_3),
            new Option3(R.string.option3_3),
            new Option3(R.string.option4_3),
            new Option3(R.string.option5_3),
    };
    private Option4[] option4= new Option4[]{
            new Option4(R.string.option_4),
            new Option4(R.string.option2_4),
            new Option4(R.string.option3_4),
            new Option4(R.string.option4_4),
            new Option4(R.string.option5_4),

    };
    private RightAnswer[] rightanswer= new RightAnswer[]{
            new RightAnswer(R.string.right_answer),
            new RightAnswer(R.string.right_answer2),
            new RightAnswer(R.string.right_answer3),
            new RightAnswer(R.string.right_answer4),
            new RightAnswer(R.string.right_answer5),

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kbcactivity);

        rd1 = findViewById(R.id.radiobtn1);
        rd2 = findViewById(R.id.radiobtn2);
        rd3 = findViewById(R.id.radiobtn3);
        rd4 = findViewById(R.id.radiobtn4);

        btnnext = findViewById(R.id.btnsubmitanswer);
        tv = findViewById(R.id.QuestionsTextview);

        tvind =findViewById(R.id.Questionidexing);
       tvind.setText("Question "+ index +" " + "/" + " "+ mQuestionBank.length);

        UpdateMethod();

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv2 = findViewById(R.id.MessageTextview);

                String SubAns =getResources().getString(R.string.btntext_submitanswer);

                if ((String) btnnext.getText() ==SubAns) {

                    String RightAns = getResources().getString(rightanswer[mCurrentIndex].getTextResId());

                    if (rd1.isChecked() == true && (String) rd1.getText() == RightAns
                            || rd2.isChecked() == true && (String) rd2.getText() == RightAns
                            || rd3.isChecked() == true && (String) rd3.getText() == RightAns
                            || rd4.isChecked() == true && (String) rd4.getText() == RightAns) {
                        tv2.setText(R.string.correct_message);

                        btnnext.setText(R.string.btntext_nextquestion);
                        tv2.setBackgroundColor(Color.parseColor("#A7DF9A"));
                        tv2.setTextColor(Color.parseColor("#548947"));



                    } else {
                        tv2.setText(R.string.wrong_message);
                        tv2.setBackgroundColor(Color.parseColor("#E68D8D"));
                        tv2.setTextColor(Color.parseColor("#CD1F1F"));
                    }
                }

                    else if ((String) btnnext.getText() ==getResources().getString(R.string.btntext_nextquestion)) {

                    mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                    UpdateMethod();
                    btnnext.setText(R.string.btntext_submitanswer);
                    tv2.setText(R.string.nulltext);

                    tv2.setBackgroundColor(Color.parseColor("#FDFEFE"));
                    rd1.setChecked(false);
                    rd2.setChecked(false);
                    rd3.setChecked(false);
                    rd4.setChecked(false);
                    index++;
//                    index=index%mQuestionBank.length;
                    tvind.setText("Question "+ index +" " + "/" + " "+ mQuestionBank.length);
                    if(index==5)
                    {
                        index=0;
                    }
                }
            }
        });

    }
    void UpdateMethod()
    {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        tv.setText(question);

        int op1 = option1[mCurrentIndex].getTextResId();
        rd1.setText(op1);

        int op2 = option2[mCurrentIndex].getTextResId();
        rd2.setText(op2);

        int op3 = option3[mCurrentIndex].getTextResId();
        rd3.setText(op3);

        int op4 = option4[mCurrentIndex].getTextResId();
        rd4.setText(op4);
    }

}
