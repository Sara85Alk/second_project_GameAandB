package com.hazimfenjan.second_project_gameaandb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String STATE_SCORE_TEAM_A = "STATE_SCORE_TeamA";
    public static final String STATE_SCORE_TEAM_B = "STATE_SCORE_TeamB";
    //declare two TextViews for each team
    static TextView countViewerA, countViewerB;
    // Tracks the score for Team A
    int scoreA;
    // Tracks the score for Team B
    int scoreB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            scoreA = (int) savedInstanceState.getSerializable(STATE_SCORE_TEAM_A);
            scoreB = (int) savedInstanceState.getSerializable(STATE_SCORE_TEAM_B);
        } else {
            scoreA = 0;
            scoreB = 0;
        }
        setContentView(R.layout.activity_main);

        countViewerA = findViewById(R.id.team_a_score);
        countViewerB = findViewById(R.id.team_b_score);

        displayTeamA(scoreA);
        displayTeamB(scoreB);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        // Save the content
        outState.putSerializable(STATE_SCORE_TEAM_A, scoreA);
        outState.putSerializable(STATE_SCORE_TEAM_B, scoreB);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        scoreA = (int) savedInstanceState.getSerializable(STATE_SCORE_TEAM_A);
        scoreB = (int) savedInstanceState.getSerializable(STATE_SCORE_TEAM_B);
    }

    /**
     * Displays the given score for Team A.
     */

    public void addThreeForTeamA(View view) {
        scoreA += 3;
        displayTeamA(scoreA);
    }

    public void addTwoForTeamA(View view) {
        scoreA += 2;
        displayTeamA(scoreA);
    }

    public void addOneForTeamA(View view) {
        scoreA += 1;
        displayTeamA(scoreA);
    }


    public void displayTeamA(int number) {

        countViewerA.setText("" + number);
    }

    /**
     * Display score for team B
     */

    public void addThreeForTeamB(View view) {
        scoreB += 3;
        displayTeamB(scoreB);
    }

    public void addTwoForTeamB(View view) {
        scoreB += 2;
        displayTeamB(scoreB);
    }

    public void addOneForTeamB(View view) {
        scoreB += 1;
        displayTeamB(scoreB);
    }

    public void displayTeamB(int number) {

        countViewerB.setText("" + number);
    }

    /**
     * Resets the score for both teams back to 0.
     */

    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayTeamA(scoreA);
        displayTeamB(scoreB);
    }
}