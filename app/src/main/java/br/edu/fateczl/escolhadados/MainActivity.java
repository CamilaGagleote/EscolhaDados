/*
 *@author:<Camila Gagleote, 1110482312050>
 */

package br.edu.fateczl.escolhadados;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spFace;

    private Spinner spQtd;

    private Button btnLancar;

    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spFace = findViewById(R.id.spFace);
        spQtd = findViewById(R.id.spQtd);
        btnLancar = findViewById(R.id.btnLancar);
        tvResult = findViewById(R.id.tvResult);

        preencheSpinner();
        btnLancar.setOnClickListener(op -> lancar());

    }

    private void lancar() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        Integer faces = (Integer) spFace.getSelectedItem();
        Integer dados = (Integer) spQtd.getSelectedItem();

        if(dados == 1){
            buffer.append(random.nextInt(6));
        }
        else if(dados == 2){
            for(int i = 0; i<2; i++){
                buffer.append(buffer.append(random.nextInt(6)));
            }
        }
        else if(dados == 3){
            for(int i = 0; i<3; i++){
                buffer.append(buffer.append(random.nextInt(6)));
            }
        }
        tvResult.setText(buffer.toString());

    }

    private void preencheSpinner() {
        String[] dados = {"D4", "D6", "D8", "D10", "D12", "D20", "D100"};

        ArrayAdapter <String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dados);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFace.setAdapter(adapter);

        List<Integer> listQtd = new ArrayList<>();
        listQtd.add(1);
        listQtd.add(2);
        listQtd.add(3);

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listQtd);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQtd.setAdapter(adapter1);

    }




}