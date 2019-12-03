package cn.edu.bistu.cs.se.jisuanqi;

import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.bistu.cs.se.jisuanqi.jisuanmokuai.Calculator;

public class MainActivity extends AppCompatActivity {
    List<String> LiShi=new ArrayList<>();
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        xuanzuo();
        final TextView textView=findViewById(R.id.resultText);
        final TextView StringText = (TextView) findViewById(R.id.StringText);
        final TextView resultText = (TextView) findViewById(R.id.resultText);


        Button button_0=findViewById(R.id.button_0);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("0");
                } else {
                    StringText.setText(StringText.getText() + "0");
                }

            }
        });
        Button button_1=findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("1");
                } else {
                    StringText.setText(StringText.getText() + "1");
                }
            }
        });
        Button button_2=findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("2");
                } else {
                    StringText.setText(StringText.getText() + "2");
                }
            }
        });
        Button button_3 =findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("3");
                } else {
                    StringText.setText(StringText.getText() + "3");
                }
            }
        });
        Button button_4=findViewById(R.id.button_4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("4");
                } else {
                    StringText.setText(StringText.getText() + "4");
                }
            }
        });
        Button button_5=findViewById(R.id.button_5);
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("5");
                } else {
                    StringText.setText(StringText.getText() + "5");
                }
            }
        });
        Button button_6=findViewById(R.id.button_6);
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("6");
                } else {
                    StringText.setText(StringText.getText() + "6");
                }
            }
        });
        Button button_7=findViewById(R.id.button_7);
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("7");
                } else {
                    StringText.setText(StringText.getText() + "7");
                }
            }
        });
        Button button_8=findViewById(R.id.button_8);
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("8");
                } else {
                    StringText.setText(StringText.getText() + "8");
                }
            }
        });
        Button button_9=findViewById(R.id.button_9);
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("9");
                } else {
                    StringText.setText(StringText.getText() + "9");
                }
            }
        });
        Button button_add=findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("+");
                } else {
                    StringText.setText(StringText.getText() + "+");
                }
            }
        });
        Button button_Right_parenthesis=findViewById(R.id.button_Right_parenthesis);
        button_Right_parenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText(")");
                } else {
                    StringText.setText(StringText.getText() + ")");
                }
            }
        });

        Button button_button_Left_parenthesis=findViewById(R.id.button_Left_parenthesis);
        button_button_Left_parenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("(");
                } else {
                    StringText.setText(StringText.getText() + "(");
                }
            }
        });

        Button button_division=findViewById(R.id.button_division);
        button_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("÷");
                } else {
                    StringText.setText(StringText.getText() + "/");
                }
            }
        });
        Button button_back=findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {

                } else {
                    s=s.substring(0,s.length()-1);
                    StringText.setText(s);
                }
            }
        });

        Button button_Multiply=findViewById(R.id.button_Multiply);
        button_Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("*");
                } else {
                    StringText.setText(StringText.getText() + "*");
                }
            }
        });
        Button button_Subtraction=findViewById(R.id.button_Subtraction);
        button_Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("-");
                } else {
                    StringText.setText(StringText.getText() + "-");
                }
            }
        });

        Button button_point=findViewById(R.id.button_point);
        button_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText(".");
                } else {
                    StringText.setText(StringText.getText() + ".");
                }
            }
        });
        Button button_equal=findViewById(R.id.button_equal);
        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("0");
                } else {

                    if(flag==0){
                        double result= Calculator.conversion(s);
                        LiShi.add(s+"="+result);
                        StringText.setText(result+"");
                        resultText.setText(result+"");}
                    else {

                        String[] string=s.split("\\^");
                        double a=Double.parseDouble(string[0]);
                        double b=Double.parseDouble(string[1]);
                        LiShi.add(s+"="+Math.pow(a,b));
                        StringText.setText(Math.pow(a,b)+"");
                        resultText.setText(Math.pow(a,b)+"");


                    }

                }
            }
        });

        Button button_AC=findViewById(R.id.button_AC);
        button_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=0;
                StringText.setText("0");
                resultText.setText("0");
            }
        });

        Button button_sin=findViewById(R.id.button_sin);
        button_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                double number=Double.parseDouble(s);
                resultText.setText(Math.sin(number)+"");
            }
        });

        Button button_cos=findViewById(R.id.button_cos);
        button_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                double number=Double.parseDouble(s);
                resultText.setText(Math.cos(number)+"");
            }
        });
        Button button_tan=findViewById(R.id.button_tan);
        button_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                double number=Double.parseDouble(s);
                resultText.setText(Math.tan(number)+"");
            }
        });




        Button button_power=findViewById(R.id.button_power);
        button_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag=1;
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("^");
                } else {
                    StringText.setText(StringText.getText() + "^");
                }


            }
        });






        Button button_A=findViewById(R.id.button_A);
        button_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("A");
                } else {
                    StringText.setText(StringText.getText() + "a");
                }
            }
        });
        Button button_B=findViewById(R.id.button_B);
        button_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("B");
                } else {
                    StringText.setText(StringText.getText() + "b");
                }
            }
        });
        Button button_C=findViewById(R.id.button_C);
        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("C");
                } else {
                    StringText.setText(StringText.getText() + "c");
                }
            }
        });
        Button button_D=findViewById(R.id.button_D);
        button_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("D");
                } else {
                    StringText.setText(StringText.getText() + "d");
                }
            }
        });
        Button button_E=findViewById(R.id.button_E);
        button_E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("E");
                } else {
                    StringText.setText(StringText.getText() + "e");
                }
            }
        });
        Button button_F=findViewById(R.id.button_F);
        button_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                if (s.equals("0")) {
                    StringText.setText("F");
                } else {
                    StringText.setText(StringText.getText() + "f");
                }
            }
        });

        Button button_DecimaltoBinary=findViewById(R.id.button_DecimaltoBinary);
        button_DecimaltoBinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                double number=Double.parseDouble(s);
                resultText.setText(Integer.toBinaryString((int)number)+"");
            }
        });

        Button button_BinarytoDecimal=findViewById(R.id.button_BinarytoDecimal);
        button_BinarytoDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                int temp=(int)Double.parseDouble(s);
                s=temp+"";
                resultText.setText(Integer.parseInt(s,2)+"");
            }
        });


        Button button_DecimaltoHexadecimal=findViewById(R.id.button_DecimaltoHexadecimal);
        button_DecimaltoHexadecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                double number=Double.parseDouble(s);
                resultText.setText(Integer.toHexString((int)number)+"");
            }
        });

        Button button_HexadecimaltoDecimal=findViewById(R.id.button_HexadecimaltoDecimal);
        button_HexadecimaltoDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();

                resultText.setText(Integer.parseInt(s,16)+"");
            }
        });

        Button button_DecimaltoOctal=findViewById(R.id.button_DecimaltoOctal);
        button_DecimaltoOctal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                double number=Double.parseDouble(s);
                resultText.setText(Integer.toOctalString((int)number)+"");
            }
        });


        Button button_OctaltoDecimal=findViewById(R.id.button_OctaltoDecimal);
        button_OctaltoDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = StringText.getText().toString();
                int temp=(int)Double.parseDouble(s);
                s=temp+"";
                resultText.setText(Integer.parseInt(s,8)+"");
            }
        });


            Button button_help = (Button) findViewById(R.id.button_help);
            button_help.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("This is HELP");
                    dialog.setMessage("HELP");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("Ture", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.setNegativeButton("False", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();



                }
            });
            //竖屏
            Button button_cm3todm3=findViewById(R.id.button_cm3todm3);
            button_cm3todm3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = StringText.getText().toString();
                    double n=Double.parseDouble(s);
                    resultText.setText(n*1000+"");
                }
            });

            Button button_dm3tom3=findViewById(R.id.button_dm3tom3);
            button_dm3tom3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = StringText.getText().toString();
                    double n=Double.parseDouble(s);
                    resultText.setText(n*1000+"");
                }
            });

            Button button_m3tocm3=findViewById(R.id.button_m3tocm3);
            button_m3tocm3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = StringText.getText().toString();
                    double n=Double.parseDouble(s);
                    resultText.setText(n/10000000+"");
                }
            });

            Button button_KmtoM=findViewById(R.id.button_KmtoM);
            button_KmtoM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = StringText.getText().toString();
                    double n=Double.parseDouble(s);
                    resultText.setText(n*1000+"");
                }
            });

            Button button_MtoCm=findViewById(R.id.button_MtoCm);
            button_MtoCm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = StringText.getText().toString();
                    double n=Double.parseDouble(s);
                    resultText.setText(n*1000+"");
                }
            });
        }
        public void  xuanzuo(){
        Button riqijisuan=findViewById(R.id.riqijisuan);
        riqijisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,time_ca.class);
                startActivity(intent);
            }
        });



        Button jisuanlishi=findViewById(R.id.jisuanlishi);


        jisuanlishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListView listView=new ListView(MainActivity.this);
                ArrayAdapter simpleAdapter = new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        LiShi);
                listView.setAdapter(simpleAdapter);


                simpleAdapter.notifyDataSetChanged();
                final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setView(listView);
                builder.setTitle("计算历史");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Log.d("mytag","click");
                    }
                });
                builder.create();
                builder.show();
            }
        });
        final Button huilv =findViewById(R.id.huilv);
        huilv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,huilv.class);
                startActivity(intent);
            }
        });
    }
    }

