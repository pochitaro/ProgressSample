package com.example.admin.progresssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;

public class MainActivity extends AppCompatActivity implements Runnable {

    ProgressDialog m_dialog;
    Thread m_thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // プログレスダイアログの生成&設定処理
        m_dialog = new ProgressDialog(this);
        m_dialog.setTitle("ProgressDialog Sample");
        m_dialog.setMessage("プログレスダイアログのサンプル");
        m_dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        // プログレスダイアログの表示
        m_dialog.show();

        // バックグラウンドで処理を行うスレッドの生成&開始
        m_thread = new Thread(this);
        m_thread.start();
    }

    @Override
    public void run() {
        // 何か重い処理
        try {
            m_thread.sleep(5000);
        }
        catch(InterruptedException e) {
        }

        // プログレスダイアログを閉じる
        m_dialog.dismiss();
    }
}
