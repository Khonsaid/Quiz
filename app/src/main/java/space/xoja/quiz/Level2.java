package space.xoja.quiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft; //переменная для левой картинки + текст
    public int numRight; //переменная для правой картинки + текст
    Array array = new Array(); //создали новый объект из класса Array
    Random random = new Random(); //для генерации случайных чисел
    public int count = 0; //счетчик правильных ответов

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level2); //установили техт

        final ImageView img_left = findViewById(R.id.img_left);
        //код который скругляет углы левой картинки
        img_left.setClipToOutline(true);

        final ImageView img_right = findViewById(R.id.img_right);
        //код который скругляет углы правый картинки
        img_right.setClipToOutline(true);

        //путь к левой TextView
        final TextView text_left = findViewById(R.id.text_left);

        //путь к правой TextView
        final TextView text_right = findViewById(R.id.text_right);

        //Развернуть игру на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Развернуть игру на весь экран - конец

        //вызов диалогового окна в начале игры
        dialog = new Dialog(this); //создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialog.setContentView(R.layout.previewdialog); //путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //окно нельзя закрыть кнопкой "назад"
        dialog.setCancelable(false); //Окно нельзя закрыть кнопкой "назад"

        //Устанавливаем картинку в диалоговое окно - начало
        ImageView previewimg = dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.previewimgtwo);
        //Устанавливаем картинку в диалоговое окно - конец

        //Устанавливаем описание задание - начало
        TextView textdescription = dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.leveltwo);
        //Устанавливаем описание задание - конец

        //кнопка которая закрывает диалогоывое окно - начало
        TextView btnclose = dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обрабатываем нажатие кнопки - начало
                try {
                    //вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(Level2.this, GameLevels.class); //создали намерение для перехода
                    startActivity(intent); //старт намерения
                    finish(); //закрыть этот класс
                    //вернуться назад к выбору уровня - цонец
                }catch (Exception e){
                    //здесь кода не будет
                }
                dialog.dismiss(); //закрываем диалоговое окно
                //обрабатываем нажатие кнопки - конец
            }
        });
        //кнопка которая закрывает диалогоывое окно - конец

        //кнопка "продолдить" - начало
        Button btncontinue = dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); //закрываем диалоговое окно
            }
        });
        //кнопка "продолдить" - конец

        //_________________________________________________________________________
        //вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this); //создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend); //путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); //Окно нельзя закрыть кнопкой "Назад"


        //Интересный факт - начало
        TextView textdescriptionEnd = dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdescriptionEnd.setText(R.string.leveltwoEnd);
        //Интересный факт - конец


        //кнопка которая закрывает диалогоывое окно - начало
        TextView btnclose2 = dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обрабатываем нажатие кнопки - начало
                try {
                    //вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(Level2.this, GameLevels.class); //создали намерение для перехода
                    startActivity(intent); //старт намерения
                    finish(); //закрыть этот класс
                    //вернуться назад к выбору уровня - цонец
                }catch (Exception e){
                    //здесь кода не будет
                }
                dialogEnd.dismiss(); //закрываем диалоговое окно
                //обрабатываем нажатие кнопки - конец
            }
        });
        //кнопка которая закрывает диалогоывое окно - конец

        //кнопка "продолдить" - начало
        Button btncontinue2 = dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level2.this, Level3.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //здесь кода не будет
                }
                dialogEnd.dismiss(); //закрываем диалоговое окно
            }
        });
        //кнопка "продолдить" - конец
        //_______________________________________________________________

        dialog.show(); //показать диалоговое окно

        //кнопка "назад" - начало
        Button btn_back = findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обрабатываем нажатие кнопки "назад" - начало
                try {
                    //вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent); //старт намерения
                    finish();//закрыть этот класс
                    //вернуться назад к выбору уровня - конец
                }catch (Exception e){
                    //здесь кода не будет
                }
                //обрабатываем нажатие кнопки "назад" - конец
            }
        });
        //кнопка "назад" - конец

        //массив для прогресса игры - начало
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };
        //массив для прогресса игры - конец

        //подклчаем анимацию - начало
        final Animation a = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);
        //подклчаем анимацию - конец

        numLeft = random.nextInt(10); //генерируем случайное число от 0 до 9
        img_left.setImageResource(array.images2[numLeft]); //достаем из массива картинку
        text_left.setText(array.text2[numLeft]); //достаем из массива текст

        numRight = random.nextInt(10); //генерируем случайное число от 0 до 9

        //цикл с предусловием, проверящий равенство числ - начало
        while (numLeft==numRight){
            numRight = random.nextInt(10);
        }
        //цикл с предусловием, проверящий равенство числ - конец

        img_right.setImageResource(array.images2[numRight]); //достаем из массива картинку
        text_right.setText(array.text2[numRight]); //достаем из массива текст

        //обрабатываем нажатие на левую картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки - начало
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки - начало
                    img_right.setEnabled(false); //блокируем правую картинку
                    if (numLeft>numRight){
                        img_left.setImageResource(R.drawable.img_true);
                    }else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                    //если коснулся картинки - конец
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    //если отпустил палец - начало
                    if (numLeft>numRight){
                        //если левая картинка больше
                        if (count<20){
                            count=count+1;
                        }

                        //закрашиваем прогресс севым цветом - начало
                        for (int i=0; i<20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс севым цветом - конец

                        //определяем правильные ответы и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым - конец
                    }else {
                        //если левая картинка - меньше
                        if (count>0){
                            if (count==1){
                                count=0;
                            }else{
                                count=count-2;
                            }
                        }
                        //закрашиваем прогресс севым цветом - начало
                        for (int i=0; i<19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс севым цветом - конец

                        //определяем правильные ответы и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым - конец
                    }
                    //если отпустил палец - конец
                    if (count==20){
                        //Выход из уровня
                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(10); //генерируем случайное число от 0 до 9
                        img_left.setImageResource(array.images2[numLeft]); //достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.text2[numLeft]); //достаем из массива текст

                        numRight = random.nextInt(10); //генерируем случайное число от 0 до 9

                        //цикл с предусловием, проверящий равенство числ - начало
                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }
                        //цикл с предусловием, проверящий равенство числ - конец

                        img_right.setImageResource(array.images2[numRight]); //достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.text2[numRight]); //достаем из массива текст

                        img_right.setEnabled(true); //Включаем обратно правую картинку
                    }

                }
                //условие касания картинки - конец
                return true;
            }
        });
        //обрабатываем нажатие на левую картинку - конец


        //обрабатываем нажатие на правую картинку - начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки - начало
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки - начало
                    img_left.setEnabled(false); //блокируем левую картинку
                    if (numLeft<numRight){
                        img_right.setImageResource(R.drawable.img_true);
                    }else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                    //если коснулся картинки - конец
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    //если отпустил палец - начало
                    if (numLeft<numRight){
                        //если правая картинка больше
                        if (count<20){
                            count=count+1;
                        }

                        //закрашиваем прогресс севым цветом - начало
                        for (int i=0; i<20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс севым цветом - конец

                        //определяем правильные ответы и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым - конец
                    }else {
                        //если правая картинка - меньше
                        if (count>0){
                            if (count==1){
                                count=0;
                            }else{
                                count=count-2;
                            }
                        }
                        //закрашиваем прогресс севым цветом - начало
                        for (int i=0; i<19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс севым цветом - конец

                        //определяем правильные ответы и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым - конец
                    }
                    //если отпустил палец - конец
                    if (count==20){
                        //Выход из уровня
                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(10); //генерируем случайное число от 0 до 9
                        img_left.setImageResource(array.images2[numLeft]); //достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.text2[numLeft]); //достаем из массива текст

                        numRight = random.nextInt(10); //генерируем случайное число от 0 до 9

                        //цикл с предусловием, проверящий равенство числ - начало
                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }
                        //цикл с предусловием, проверящий равенство числ - конец

                        img_right.setImageResource(array.images2[numRight]); //достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.text2[numRight]); //достаем из массива текст

                        img_left.setEnabled(true); //Включаем обратно левую картинку
                    }

                }
                //условие касания картинки - конец
                return true;
            }
        });
        //обрабатываем нажатие на правую картинку - конец
    }

    //системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        //обрабатываем нажатие кнопки "назад" - начало
        try {
            //вернуться назад к выбору уровня - начало
            Intent intent = new Intent(Level2.this, GameLevels.class);
            startActivity(intent); //старт намерения
            finish();//закрыть этот класс
            //вернуться назад к выбору уровня - конец
        }catch (Exception e){
            //здесь кода не будет
        }
        //обрабатываем нажатие кнопки "назад" - конец
    }
    //системная кнопка "назад" - конец
}