//// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
//// Jad home page: http://www.geocities.com/kpdus/jad.html
//// Decompiler options: braces fieldsfirst space lnc
//
//package phoenlf.application.com.hexbioctdec;
//
//import android.text.TextUtils;
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
//        val$editText.setInputType(1);
//        Toast.makeText(MainActivity.this, "Please choose a Hexadecimal value .", 0).show();
//        val$editText.setText("");
//        val$button.setOnClickListener(new android.view.View.OnClickListener() {
//
//            final MainActivity._cls3 this$1;
//
//            public void onClick(View view1)
//            {
//                Object obj = new DecimalToBinary();
//                if (TextUtils.isEmpty(editText.getText().toString()))
//                {
//                    editText.setError("This item cannot be empty.");
//                    return;
//                }
//                view1 = editText.getText().toString();
//                if (view1.equals("q") || view1.equals("w") || view1.equals("r") || view1.equals("t") || view1.equals("y") || view1.equals("u") || view1.equals("i") || view1.equals("o") || view1.equals("p") || view1.equals("[") || view1.equals("]") || view1.equals("s") || view1.equals("g") || view1.equals("h") || view1.equals("j") || view1.equals("k") || view1.equals("l") || view1.equals(";") || view1.equals("'") || view1.equals("z") || view1.equals("x") || view1.equals("x") || view1.equals("v") || view1.equals("n") || view1.equals("m") || view1.equals(",") || view1.equals(".") || view1.equals("/"))
//                {
//                    editText.setError("Incorrect input");
//                    return;
//                } else
//                {
//                    int i = Integer.parseInt(editText.getText().toString(), 16);
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
//                this$1 = MainActivity._cls3.this;
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
