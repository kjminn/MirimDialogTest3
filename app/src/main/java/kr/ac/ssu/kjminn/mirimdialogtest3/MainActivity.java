package kr.ac.ssu.kjminn.mirimdialogtest3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton radioPark, radioSon, radioAhn, radioPark2;
    View dialogView;
    ImageView dlgImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
        radioPark = findViewById(R.id.radio_park);
        radioPark2 = findViewById(R.id.radio_hana);
        radioSon = findViewById(R.id.radio_son);
        radioAhn = findViewById(R.id.radio_ahn);
        Button btnShow = findViewById(R.id.btn_show);
        btnShow.setOnClickListener(btnShowListener);
    }
    
    View.OnClickListener btnShowListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
            dlgImg = dialogView.findViewById(R.id.img);
            int selectedId = 0;
            String seletedTitle = "";
            switch (rg.getCheckedRadioButtonId()){
                case R.id.radio_park:
                    selectedId = R.drawable.seripark;
                    seletedTitle = radioPark.getText().toString();
                    break;
                case R.id.radio_hana:
                    selectedId = R.drawable.park2;
                    seletedTitle = radioPark2.getText().toString();
                    break;
                case R.id.radio_son:
                    selectedId = R.drawable.son;
                    seletedTitle = radioSon.getText().toString();
                    break;
                case R.id.radio_ahn:
                    selectedId = R.drawable.ahn;
                    seletedTitle = radioAhn.getText().toString();
                    break;
            }
            AlertDialog. Builder  dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle(seletedTitle);
            dlgImg.setImageResource(selectedId);
            dlg.setView(dialogView);
            dlg.setPositiveButton("닫기", null);
            dlg.show();
        }
    };
}