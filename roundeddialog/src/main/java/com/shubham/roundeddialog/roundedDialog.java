package com.shubham.roundeddialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class roundedDialog extends Dialog {

    private onClick onClick;

    private Dialog dialog;
    private String strTitle,strMessage,strDone,strCancel;

//    public roundedDialog(@NonNull Activity context, onClick onClick) {
//        super(context);
//        activity = context;
//        this.onClick=onClick;
//        setCancelable(false);
//        dialog = this;
//    }
//
    private roundedDialog(Activity activity, onClick onClick, String title, String message, String doneText, String cancelText)
    {
        super(activity);
        this.onClick=onClick;
        dialog = this;
        strTitle = title;
        strMessage = message;
        strDone = doneText;
        strCancel = cancelText;
        setCancelable(false);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_dialog);

        TextView title = findViewById(R.id.title);
        TextView message = findViewById(R.id.message);
        Button cancel = findViewById(R.id.cancel);
        Button done = findViewById(R.id.done);

        title.setText(strTitle);
        message.setText(strMessage);
        done.setText(strDone);
        cancel.setText(strCancel);

        if(strCancel==null)
        {
            cancel.setVisibility(View.INVISIBLE);
        }

        if(strDone==null)
        {
            done.setText("Ok");
        }

        if(strTitle == null)
        {
            title.setVisibility(View.GONE);
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                onClick.onCancel(dialog);

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                onClick.onDone(dialog);

            }
        });

        //getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        if(getWindow()!=null) {
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
    }


    public interface onClick
    {
        void onDone(Dialog dialog);
        void onCancel(Dialog dialog);
    }

    public static class Builder {

        String title = null;
        String message = null;
        String doneText = null;
        String cancelText = null;
        Activity context;
        onClick onClick;

        public roundedDialog.onClick getOnClick() {
            return onClick;
        }

        public Builder setOnClick(roundedDialog.onClick onClick) {
            this.onClick = onClick;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        String getMessage() {
            return message;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        String getDoneText() {
            return doneText;
        }

        public Builder setDoneText(String doneText) {
            if(doneText.length()>10) {
                this.doneText = doneText.substring(0, 10);
            }
            else
            {
                this.doneText = doneText;
            }
            return this;
        }

        String getCancelText() {
            return cancelText;
        }

        public Builder setCancelText(String cancelText) {
            if(cancelText.length()>10) {
                this.cancelText = cancelText.substring(0, 10);
            }
            else
            {
                this.cancelText = cancelText;
            }
            return this;
        }

        public Context getContext() {
            return context;
        }

        public void setContext(Activity context) {
            this.context = context;
        }

        public Builder(Activity context)
        {
            this.context = context;
        }

        public void show() {
            new roundedDialog(context,getOnClick(), getTitle(), getMessage(), getDoneText(), getCancelText()).show();
        }
    }


}
