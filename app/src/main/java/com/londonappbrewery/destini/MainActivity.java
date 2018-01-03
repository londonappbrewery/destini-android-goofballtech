package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView mMainText;
    private Button mTopButton;
    private Button mBottomButton;

    private String mCurrentPage = "T1_Story";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainText = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentPage.equals("End")){
                    finish();
                }else {
                    nextPage(mCurrentPage, "Ans1");
                }
            }
        });

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentPage.equals("End")){
                    finish();
                }else {
                    nextPage(mCurrentPage, "Ans2");
                }
            }
        });

    }

    private void nextPage(String onPage, String answerChoice){
        switch (onPage) {
            case "T1_Story":
                if (answerChoice.equals("Ans1")) {
                    mMainText.setText(R.string.T3_Story);
                    mCurrentPage = "T3_Story";
                    mTopButton.setText(R.string.T3_Ans1);
                    mBottomButton.setText(R.string.T3_Ans2);
                } else {
                    mMainText.setText(R.string.T2_Story);
                    mCurrentPage = "T2_Story";
                    mTopButton.setText(R.string.T2_Ans1);
                    mBottomButton.setText(R.string.T2_Ans2);
                }
                break;
            case "T2_Story":
                if (answerChoice.equals("Ans1")) {
                    mMainText.setText(R.string.T3_Story);
                    mCurrentPage = "T3_Story";
                    mTopButton.setText(R.string.T3_Ans1);
                    mBottomButton.setText(R.string.T3_Ans2);
                } else {
                    mMainText.setText(R.string.T4_End);
                    mCurrentPage = "End";
                    mTopButton.setText("The");
                    mBottomButton.setText("End");
                }
                break;
            case "T3_Story":
                if (answerChoice.equals("Ans1")) {
                    mMainText.setText(R.string.T6_End);
                    mCurrentPage = "End";
                    mTopButton.setText("The");
                    mBottomButton.setText("End");
                } else {
                    mMainText.setText(R.string.T5_End);
                    mCurrentPage = "End";
                    mTopButton.setText("The");
                    mBottomButton.setText("End");
                }
                break;
        }
    }
}
