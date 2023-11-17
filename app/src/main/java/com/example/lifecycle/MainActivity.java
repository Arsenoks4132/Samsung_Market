package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lifecycle.databinding.ElementsBinding;

public class MainActivity extends AppCompatActivity {

    ElementsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ElementsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        binding.Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.Computer.setChecked(false);
                binding.Vacuum.setChecked(false);
                binding.Cat.setChecked(false);
                binding.Dog.setChecked(false);
                binding.Mause.setChecked(false);

                binding.Delivery.setChecked(false);
                binding.Self.setChecked(false);
                binding.Store.setChecked(false);

                binding.Comment.setText("");
                Toast.makeText(getApplicationContext(), "Выбранные опции сброшены", Toast.LENGTH_SHORT).show();
            }
        });
        binding.Ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((binding.Store.isChecked() && (binding.Cat.isChecked() || binding.Mause.isChecked() || binding.Dog.isChecked()))) {
                    Toast.makeText(getApplicationContext(), "Вы - живодёр! Нельзя оставлять животных на хранение!!!", Toast.LENGTH_SHORT).show();
                }
                else if ((binding.Computer.isChecked() ||
                        binding.Cat.isChecked() ||
                        binding.Dog.isChecked() ||
                        binding.Mause.isChecked() ||
                        binding.Vacuum.isChecked())
                        &&
                        (binding.Delivery.isChecked() ||
                        binding.Self.isChecked() ||
                        binding.Store.isChecked())) {
                    Toast.makeText(getApplicationContext(), "Спасибо за заказ!\n", Toast.LENGTH_SHORT).show();
                }
            }
        });
//
//        binding.myedit.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.d("TEXTCHANGED BEFORE", s.toString());
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("TEXTCHANGED ON", s.toString());
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Log.d("TEXTCHANGED AFTER", s.toString());
//
//            }
//        });
//
//        Toast.makeText(this, "create", Toast.LENGTH_SHORT).show();
//        EditText editText = findViewById(R.id.myedit);
//
//
//        CheckBox checkBox = findViewById(R.id.mychek);
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//            }
//        });
//        checkBox.isChecked();
//
//        TextView textView = findViewById(R.id.mytext);
//
//        RadioGroup radioGroup = findViewById(R.id.mygroup);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (R.id.RB1 == checkedId) {
//                    textView.setText("Привет, Олег");
//                }
//                if (R.id.RB2 == checkedId) {
//                    textView.setText("ЭТО НЕ ОЛЕГ!!!");
//                }
//            }
//        });
    }
}