package ui.mainong.alert;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import ui.mainong.alert.codec.AlertType;
import ui.mainong.alert.helper.AlertListener;

public class Alert extends Dialog implements View.OnClickListener {

    private Context context;
    private AlertType type;
    private String title;
    private String message;

    private AlertListener mListener;

    private static final int DEFAULT_THEME = android.R.style.Theme_Material_Dialog_MinWidth;

    // Palettes
    private ImageView imgIcon;
    private TextView txtAlertTitle;
    private TextView txtAlertMessage;


    public Alert(@NonNull Context context, @NonNull AlertType type, @NonNull String title, @NonNull String message){
        this(context, type, title, message, DEFAULT_THEME);
    }

    public Alert(Context context, AlertType type, String title, String message, int themeResId){
        super(context, themeResId);

        this.context = context;
        this.type = type;
        this.title = title;
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        if (type == AlertType.CONFIRM){
            setContentView(R.layout.dialog_confirm);
            TextView btnCancel = findViewById(R.id.btn_cancel);
            btnCancel.setOnClickListener(this);
            setCancelable(false);
        } else {
            setContentView(R.layout.dialog_alert);
            setCancelable(true);
        }

        imgIcon = findViewById(R.id.alert_icon);
        txtAlertTitle = findViewById(R.id.alert_title);
        txtAlertMessage = findViewById(R.id.alert_message);
        TextView btnAlert = findViewById(R.id.btn_alert);

        btnAlert.setOnClickListener(this);

        setData();
    }

    private void setData() {
        switch (type) {
            case INFO:
                setInfoData();
                break;

            case WARNING:
                setWarningData();
                break;

            case SUCCESS:
                setSuccessData();
                break;

            case ERROR:
                setErrorData();
                break;

            case CONFIRM:
                setConfirmData();
                break;

        }
    }

    private void setConfirmData() {
        // Setting data
        Drawable img = ContextCompat.getDrawable(context, R.drawable.ic_confirm);
        imgIcon.setImageDrawable(img);
        txtAlertTitle.setText(title);
        txtAlertMessage.setText(message);

        // Setting color
        imgIcon.setColorFilter(ContextCompat.getColor(context, R.color.colorConfirm));
        txtAlertTitle.setTextColor(ContextCompat.getColor(context, R.color.colorConfirm));
    }

    private void setSuccessData() {

        // Setting data
        Drawable img = ContextCompat.getDrawable(context, R.drawable.ic_success);
        imgIcon.setImageDrawable(img);
        txtAlertTitle.setText(title);
        txtAlertMessage.setText(message);

        // Setting color
        imgIcon.setColorFilter(ContextCompat.getColor(context, R.color.colorSuccess));
        txtAlertTitle.setTextColor(ContextCompat.getColor(context, R.color.colorSuccess));
    }

    private void setInfoData() {

        // Setting data
        Drawable img = ContextCompat.getDrawable(context, R.drawable.ic_info);
        imgIcon.setImageDrawable(img);
        txtAlertTitle.setText(title);
        txtAlertMessage.setText(message);

        // Setting color
        imgIcon.setColorFilter(ContextCompat.getColor(context, R.color.colorInfo));
        txtAlertTitle.setTextColor(ContextCompat.getColor(context, R.color.colorInfo));
    }

    private void setWarningData() {

        // Setting data
        Drawable img = ContextCompat.getDrawable(context, R.drawable.ic_warning);
        imgIcon.setImageDrawable(img);
        txtAlertTitle.setText(title);
        txtAlertMessage.setText(message);

        // Setting color
        imgIcon.setColorFilter(ContextCompat.getColor(context, R.color.colorWarning));
        txtAlertTitle.setTextColor(ContextCompat.getColor(context, R.color.colorWarning));
    }

    private void setErrorData() {

        // Setting data
        Drawable img = ContextCompat.getDrawable(context, R.drawable.ic_error);
        imgIcon.setImageDrawable(img);
        txtAlertTitle.setText(title);
        txtAlertMessage.setText(message);

        // Setting color
        imgIcon.setColorFilter(ContextCompat.getColor(context, R.color.colorError));
        txtAlertTitle.setTextColor(ContextCompat.getColor(context, R.color.colorError));
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_cancel) {
            dismiss();
        } else if (v.getId() == R.id.btn_alert) {
            if (type == AlertType.CONFIRM) {
                mListener.confirm();
                dismiss();
            } else {
                dismiss();
            }
        }

    }

    @Override
    public void setOnDismissListener(@Nullable OnDismissListener listener) {
        imgIcon.clearColorFilter();
        super.setOnDismissListener(listener);
    }

    public void setOnAlertListener(AlertListener mListener) {
        this.mListener = mListener;
    }
}
