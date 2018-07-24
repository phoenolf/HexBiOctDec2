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
//        } else
//        {
//            int i = Integer.parseInt(editText.getText().toString());
//            view = Integer.toHexString(i);
//            obj = ((DecimalToBinary) (obj)).toBinary(i);
//            String s = Integer.toOctalString(i);
//            String s1 = Integer.toString(i);
//            textView.setText((new StringBuilder()).append(" ").append(((String) (obj))).append(" ").append("BIN  ").toString());
//            textView2.setText((new StringBuilder()).append(" ").append(view).append(" ").append("HEX  ").toString());
//            textView3.setText((new StringBuilder()).append(" ").append(s).append(" ").append("OCT").toString());
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
//    // Unreferenced inner class com/application/phoen/hexbioctdecconverter/MainActivity$2
//
///* anonymous class */
//    class MainActivity._cls2
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
//            editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
//            editText.setText("");
//            Toast.makeText(MainActivity.this, "Please enter a Decimal value.", 0).show();
//            button.setOnClickListener(new MainActivity._cls2._cls1());
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
