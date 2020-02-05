package fr.leo.testsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView scoresView;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoresView = ( TextView ) findViewById(R.id.scoresView) ;
        databaseManager = new DatabaseManager(this);

//        databaseManager.insertScore("Zoe" , 1000);
//        databaseManager.insertScore("Vyvy" , 500);
//        databaseManager.insertScore("Me" , 250);
//        databaseManager.insertScore("Aurélie" , 1400);
//        databaseManager.insertScore("Jane" , 3900);

        List<ScoreData> scores = databaseManager.readTop10();

        for (ScoreData score : scores ) {
            scoresView.append(score.toString() + "\n\n");
        }

        databaseManager.close();
    }
}
