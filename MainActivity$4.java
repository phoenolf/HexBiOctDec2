//// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
//// Jad home page: http://www.geocities.com/kpdus/jad.html
//// Decompiler options: braces fieldsfirst space lnc
//
//package phoenlf.application.com.hexbioctdec;
//
//import android.text.TextUtils;
//import android.text.method.DigitsKeyListener;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//// Referenced classes of package com.application.phoen.hexbioctdecconverter:
////            MainActivity, DecimalToBinary
//
//class val.textView4
//    implements android.view.tener
//{
//
//    final MainActivity this$0;
//    final Button val$button;
//    final EditText val$editText;
//    final TextView val$textView;
//    final TextView val$textView2;
//    final TextView val$textView3;
//    final TextView val$textView4;
//
//    public void onClick(View view)
//    {
//        val$editText.setKeyListener(DigitsKeyListener.getInstance("01234567"));
//        val$editText.setText("");
//        Toast.makeText(MainActivity.this, "Please enter an Octal value.", 0).show();
//        val$button.setOnClickListener(new android.view.View.OnClickListener() {
//
//            final MainActivity._cls4 this$1;
//
//            public void onClick(View view1)
//            {
//                Object obj = new DecimalToBinary();
//                if (TextUtils.isEmpty(editText.getText().toString()))
//                {
//                    editText.setError("This item cannot be empty.");
//                    return;
//                } else
//                {
//                    int i = Integer.parseInt(editText.getText().toString(), 8);
//                    view1 = Integer.toHexString(i);
//                    obj = ((DecimalToBinary) (obj)).toBinary(i);
//                    String s = Integer.toOctalString(i);
//                    String s1 = Integer.toString(i);
//                    textView.setText((new StringBuilder()).append(" ").append(((String) (obj))).append(" ").append("BIN  ").toString());
//                    textView2.setText((new StringBuilder()).append(" ").append(view1).append(" ").append("HEX  ").toString());
//                    textView3.setText((new StringBuilder()).append(" ").append(s).append(" ").append("OCT  ").toString());
//                    textView4.setText((new StringBuilder()).append(" ").append(s1).append(" ").append("DEC  ").toString());
//                    return;
//                }
//            }
//
//
//            {
//                this$1 = MainActivity._cls4.this;
//                super();
//            }
//        });
//    }
//
//    _cls1.this._cls1()
//    {
//        this$0 = final_mainactivity;
//        val$editText = edittext;
//        val$button = button1;
//        val$textView = textview;
//        val$textView2 = textview1;
//        val$textView3 = textview2;
//        val$textView4 = TextView.this;
//        super();
//    }
//}
