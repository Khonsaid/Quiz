package space.xoja.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Здесь будет команда для кнопки
                //начало конструкции
                try {
                    Intent intent= new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
                //конец конструкции
            }
        });
        //Кнопка для перехода на 1 уровень - начало
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level1.class);
                    startActivity(intent);finish();
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //Кнопка для перехода на 1 уровень - конец


        //Кнопка для перехода на 2 уровень - начало
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level2.class);
                    startActivity(intent);finish();
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //Кнопка для перехода на 2 уровень - конец


        //Кнопка для перехода на 3 уровень - начало
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level3.class);
                    startActivity(intent);finish();
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //Кнопка для перехода на 3 уровень - конец



    }
    //системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        //начало конструкции
        try {
            Intent intent= new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
        //конец конструкции
    }
    //системная кнопка "назад" - конец
}