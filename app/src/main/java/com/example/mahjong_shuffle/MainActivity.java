package com.example.mahjong_shuffle;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] Tile_Wall={
            "1m","2m","3m","4m","5m","6m","7m","8m","9m","1p","2p","3p","4p","5p","6p","7p","8p","9p","1s","2s","3s","4s","5s","6s","7s","8s","9s","東","南","西","北","白","發","中",
            "1m","2m","3m","4m","5m","6m","7m","8m","9m","1p","2p","3p","4p","5p","6p","7p","8p","9p","1s","2s","3s","4s","5s","6s","7s","8s","9s","東","南","西","北","白","發","中",
            "1m","2m","3m","4m","5m","6m","7m","8m","9m","1p","2p","3p","4p","5p","6p","7p","8p","9p","1s","2s","3s","4s","5s","6s","7s","8s","9s","東","南","西","北","白","發","中",
            "暗01","暗02","暗03","暗04","暗05","暗06","暗07","暗08","暗09","暗10","暗11","暗12","暗13","暗14","暗15","暗16","暗17","暗18","暗19","暗20","暗21","暗22","暗23","暗24","暗25","暗26","暗27","暗28","暗29","暗30","暗31","暗32","暗33","暗34"
    };
    private int tile_ind;
    private Button next_button;
    private TextView textview;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        List<String> list = new ArrayList<String>();
        for(int i=0;i<Tile_Wall.length;i++){
            list.add(Tile_Wall[i]);
        }
        Collections.shuffle(list);//随机打乱了list的顺序
        String Tile_Wall_Shuffle[] = new String[Tile_Wall.length];
        for(int i=0;i<Tile_Wall.length;i++){
            Tile_Wall_Shuffle[i]=list.get(i);
        }
        textview=findViewById(R.id.textview);
        next_button=findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在这里添加你想要运行的逻辑代码
                if(tile_ind<52){
                    String firstPart = "第"+(tile_ind+1)+"到"+(tile_ind+4)+"张牌：\n"+String.join(",", Arrays.copyOfRange(Tile_Wall_Shuffle, tile_ind, tile_ind+4));
                    textview.setText(firstPart);
                    Toast.makeText(getApplicationContext(),String.join(",", Arrays.copyOfRange(Tile_Wall_Shuffle, tile_ind, tile_ind+4)) , Toast.LENGTH_SHORT).show();
                    tile_ind+=4;
                }
                else if(tile_ind<Tile_Wall.length){
                    textview.setText("第"+ (tile_ind + 1) +"张牌："+Tile_Wall_Shuffle[tile_ind]);
                    Toast.makeText(getApplicationContext(), Tile_Wall_Shuffle[tile_ind], Toast.LENGTH_SHORT).show();
                    tile_ind++;
                }
                //Toast.makeText(getApplicationContext(), Tile_Wall_Shuffle[tile_ind], Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}