package ui.mainong.alert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ui.mainong.alert.codec.AlertType;
import ui.mainong.alert.helper.AlertListener;
import ui.mainong.pop.Pop;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSuccess;
    private Button btnInfo;
    private Button btnWarn;
    private Button btnError;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPalettes();
        initClickListener();

    }

    /**
     * Initializes buttons
     */
    private void initPalettes() {
        btnSuccess = findViewById(R.id.btn_success);
        btnInfo = findViewById(R.id.btn_info);
        btnWarn = findViewById(R.id.btn_warn);
        btnError = findViewById(R.id.btn_error);
        btnConfirm = findViewById(R.id.btn_confirm);
    }

    /**
     * Initializes OnClickListeners for buttons
     */
    private void initClickListener() {
        btnSuccess.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnWarn.setOnClickListener(this);
        btnError.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_success:
                new Alert(this, AlertType.SUCCESS,"Success", "This is a success alert dialog")
                        .show();

                break;

            case R.id.btn_info:
                new Alert(this, AlertType.INFO,"Info", "This is an info alert dialog")
                        .show();
                break;

            case R.id.btn_warn:
                new Alert(this, AlertType.WARNING,"Warning", "This is a warning alert dialog")
                        .show();
                break;

            case R.id.btn_error:
                new Alert(this, AlertType.ERROR,"Error", "This is an error alert dialog")
                        .show();
                break;

            case R.id.btn_confirm:
                Alert dialog = new Alert(this, AlertType.CONFIRM
                        , "Confirm", "This is a confirmation dialog");

                dialog.setOnAlertListener(new AlertListener() {
                    @Override
                    public void confirm() {
                        Pop.info(MainActivity.this, "Success");
                    }
                });
                dialog.show();
        }
    }
}