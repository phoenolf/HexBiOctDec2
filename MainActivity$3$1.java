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
////            DecimalToBinary, MainActivity
//
//class this._cls1
//    implements android.view.ner
//{
//
//    final l.textView4 this$1;
//
//    public void onClick(View view)
//    {
//        Object obj = new DecimalToBinary();
//        if (TextUtils.isEmpty(editText.getText().toString()))
//        {
//            editText.setError("This item cannot be empty.");
//            return;
//        }
//        view = editText.getText().toString();
//        if (view.equals("q") || view.equals("w") || view.equals("r") || view.equals("t") || view.equals("y") || view.equals("u") || view.equals("i") || view.equals("o") || view.equals("p") || view.equals("[") || view.equals("]") || view.equals("s") || view.equals("g") || view.equals("h") || view.equals("j") || view.equals("k") || view.equals("l") || view.equals(";") || view.equals("'") || view.equals("z") || view.equals("x") || view.equals("x") || view.equals("v") || view.equals("n") || view.equals("m") || view.equals(",") || view.equals(".") || view.equals("/"))
//        {
//            editText.setError("Incorrect input");
//            return;
//        } else
//        {
//            int i = Integer.parseInt(editText.getText().toString(), 16);
//            view = Integer.toHexString(i);
//            obj = ((DecimalToBinary) (obj)).toBinary(i);
//            String s = Integer.toOctalString(i);
//            String s1 = Integer.toString(i);
//            textView.setText((new StringBuilder()).append(" ").append(((String) (obj))).append(" ").append("BIN  ").toString());
//            textView2.setText((new StringBuilder()).append(" ").append(view).append(" ").append("HEX  ").toString());
//            textView3.setText((new StringBuilder()).append(" ").append(s).append(" ").append("OCT  ").toString());
//            textView4.setText((new StringBuilder()).append(" ").append(s1).append(" ").append("DEC  ").toString());
//            return;
//        }
//    }
//
//    l.textView4()
//    {
//        this$1 = this._cls1.this;
//        super();
//    }
//
//    // Unreferenced inner class com/application/phoen/hexbioctdecconverter/MainActivity$3
//
///* anonymous class */
//    class MainActivity._cls3
//        implements android.view.View.OnClickListener
//    {
//
//        final MainActivity this$0;
//        final Button val$button;
//        final EditText val$editText;
//        final TextView val$textView;
//        final TextView val$textView2;
//        final TextView val$textView3;
//        final TextView val$textView4;
//
//        public void onClick(View view)
//        {
//            editText.setInputType(1);
//            Toast.makeText(MainActivity.this, "Please choose a Hexadecimal value .", 0).show();
//            editText.setText("");
//            button.setOnClickListener(new MainActivity._cls3._cls1());
//        }
//
//
//            {
//                this$0 = final_mainactivity;
//                editText = edittext;
//                button = button1;
//                textView = textview;
//                textView2 = textview1;
//                textView3 = textview2;
//                textView4 = TextView.this;
//                super();
//            }
//    }
//
//}
