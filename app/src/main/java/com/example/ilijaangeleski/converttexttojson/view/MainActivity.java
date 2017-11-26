package com.example.ilijaangeleski.converttexttojson.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ilijaangeleski.converttexttojson.R;
import com.example.ilijaangeleski.converttexttojson.di.component.DaggerMainComponent;
import com.example.ilijaangeleski.converttexttojson.di.module.AppModule;
import com.example.ilijaangeleski.converttexttojson.di.module.MainModule;
import com.example.ilijaangeleski.converttexttojson.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.input)
    EditText input;

    @BindView(R.id.jsonOutput)
    TextView jsonOutput;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerMainComponent.builder().mainModule(new MainModule(this)).appModule(new AppModule(getApplicationContext())).build().inject(this);
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
