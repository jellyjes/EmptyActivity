package sg.edu.rp.c346.id20047778.emptyactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvTranslatedText,tvTranslatedText2;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        registerForContextMenu(tvTranslatedText); //register ^

        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(tvTranslatedText2);//register ^

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "English");
        menu.add(0, 1, 1, "Italian");

        if (v == tvTranslatedText){
            wordClicked = "hello";
        }
        else if(v == tvTranslatedText2){
            wordClicked = "bye";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0) {
            Toast.makeText(MainActivity.this, "English selected", Toast.LENGTH_LONG).show();
            if(wordClicked.equalsIgnoreCase("hello")){
                tvTranslatedText.setText("Hello");
            }
            else if(wordClicked.equalsIgnoreCase("bye")){
                tvTranslatedText.setText("Bye");

            }
            tvTranslatedText.setText("Hello");
            return true;
        } else if (item.getItemId() == 1) {

            Toast.makeText(MainActivity.this, "Italian selected", Toast.LENGTH_LONG).show();
            if(wordClicked.equalsIgnoreCase("hello")){
                tvTranslatedText.setText("Ciao");

            }else if(wordClicked.equalsIgnoreCase("bye")){
                tvTranslatedText2.setText("Addio");
            }
            tvTranslatedText.setText("Ciao");
            return true;
        }
        return super.onContextItemSelected(item);

    }
}