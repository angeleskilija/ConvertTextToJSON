package com.example.ilijaangeleski.converttexttojson.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilijaangeleski.converttexttojson.R;
import com.example.ilijaangeleski.converttexttojson.presenter.MainPresenter;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.input)
    EditText input;

    @BindView(R.id.jsonOutput)
    TextView jsonOutput;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);

    }

    @OnTextChanged(R.id.input)
    public void onTextChanged(CharSequence text) {
        presenter.onTextChange(text.toString());
    }

    @Override
    public void showOutput(String json) {
        jsonOutput.setText(json);
    }
}
