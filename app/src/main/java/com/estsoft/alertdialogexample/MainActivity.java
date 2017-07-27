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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int indexSingleChoice = 0;
    private boolean[] indexMultiChoiceSelected = { false, false, false, false, false, false };

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

    public void dialogProgress( View view ) {
        ProgressDialog pd = new ProgressDialog( this );
        pd.setTitle( "진행중..." );
        pd.setIcon( android.R.drawable.ic_menu_upload );
        pd.setMessage( "잠시만 기다려 주세요." );
        pd.show();
    }

    public void dialogList( View view ) {
        new AlertDialog.Builder( this ).
                setTitle( "list dialog" ).
                setIcon( android.R.drawable.ic_dialog_alert ).
                setItems(R.array.lists, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] items = getResources().getStringArray( R.array.lists );
                        Toast.makeText(
                                getApplication(),
                                items[ which ] + " selected!",
                                Toast.LENGTH_LONG).
                                show();
                    }
                }).
                setPositiveButton( "닫기", null ).
                show();
    }

    public void dialogSingleChoice( View view ) {
        new AlertDialog.Builder( this ).
                setIcon( android.R.drawable.ic_dialog_alert ).
                setTitle( "하나를 고르세요" ).
                setSingleChoiceItems(
                        R.array.lists,
                        indexSingleChoice,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                indexSingleChoice = which;
                            }
                        }).
                setPositiveButton( "닫기", null ).
                show();
    }

    public void dialogMultipleChoice( View view ){
        new AlertDialog.Builder( this ).
                setIcon( android.R.drawable.ic_dialog_alert ).
                setTitle( "여러 개를 고르세요" ).
                setMultiChoiceItems(
                        R.array.lists,
                        indexMultiChoiceSelected,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                               indexMultiChoiceSelected[ which ] = isChecked;
                            }
                        }).
                setPositiveButton( "닫기", null ).
                show();
    }

    public void dialogCustomLayout( View view ) {
        // layout inflation
        LayoutInflater inflater = getLayoutInflater();
        final View rootView =
                inflater.inflate( R.layout.dialog_custom, null );

        new AlertDialog.Builder( this ).
                setIcon( android.R.drawable.ic_dialog_alert ).
                setTitle( "커스텀 다이알로그" ).
                //setView( R.layout.dialog_custom ). // API21 more
                setView( rootView ).
                setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       EditText et =
                               (EditText)rootView.findViewById( R.id.password );
                        String password = et.getText().toString();
                        Toast.makeText(
                                getApplication(),
                                "password:" + password,
                                Toast.LENGTH_LONG).
                                show();
                    }
                }).
                show();
    }
}
