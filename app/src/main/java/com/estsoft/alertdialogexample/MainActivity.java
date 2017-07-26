package com.estsoft.alertdialogexample;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialogMessage( View view ) {
//        AlertDialog.Builder adb = new AlertDialog.Builder( this );
//        adb.setIcon( android.R.drawable.ic_dialog_info );
//        adb.setTitle( "Dialog" );
//        adb.setMessage( "메세지 다이알로그 테스트\n안녕하세요~" );
//        adb.show();

        //Method Chain
        new AlertDialog.Builder( this ).
        setIcon( android.R.drawable.ic_dialog_info ).
        setTitle( "Dialog" ).
        setMessage( "메세지 다이알로그 테스트\n안녕하세요~" ).
        show();
    }

    public void dialogCloseButton( View view ) {
        new AlertDialog.Builder( this ).
                setIcon( R.mipmap.ic_launcher ).
                setTitle( "Dialog" ).
                setMessage( "메세지 다이알로그 테스트\n안녕하세요~" ).
                setPositiveButton( "닫기", null ).
                show();
    }

    public void DialogOKCancelNoButton( View view ) {
        new AlertDialog.Builder( this ).
                setIcon( android.R.drawable.ic_dialog_alert ).
                setTitle( "종료" ).
                setMessage( "앱을 종료 하시겠습니다." ).
                setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println( "------>취소:" + which );
                    }
                }).
                setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println( "------>아니오:" + which );
                    }
                }).
                setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println( "------>예:" + which );
                    }
                }).
                show();
    }
}
