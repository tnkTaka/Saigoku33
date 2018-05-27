package local.hal.st21.android.saigoku3360213;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TempleEditActivity extends AppCompatActivity {

    private int _selectedTempleNo = 0;

    private String _selectedTempleName = "";

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple_edit);

        Intent intent = getIntent();
        _selectedTempleNo = intent.getIntExtra("selectedTempleNo",0);
        _selectedTempleName = intent.getStringExtra("selectedTempleName");

        String honzon = "";
        String shushi = "";
        String address = "";
        String url = "";
        String content = "";

        DatabaseHelper helper = new DatabaseHelper(TempleEditActivity.this);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            honzon = DatabaseAccess.findHonzonByPK(db, _selectedTempleNo);
            shushi = DatabaseAccess.findShushiByPK(db, _selectedTempleNo);
            address = DatabaseAccess.findAddressByPK(db, _selectedTempleNo);
            url = DatabaseAccess.findUrlByPK(db, _selectedTempleNo);
            content = DatabaseAccess.findNoteByPK(db, _selectedTempleNo);
        }
        catch (Exception ex){
            Log.e("ERROR",ex.toString());
        }
        finally {
            db.close();
        }

        EditText etHonzon = findViewById(R.id.etHonzon);
        etHonzon.setText(honzon);

        EditText etShushi = findViewById(R.id.etShushi);
        etShushi.setText(shushi);

        EditText etAddress = findViewById(R.id.etAddress);
        etAddress.setText(address);

        EditText etUrl = findViewById(R.id.etUrl);
        etUrl.setText(url);

        EditText etContent = findViewById(R.id.etContent);
        etContent.setText(content);

        TextView tvTemple = findViewById(R.id.tvTemple);
        tvTemple.setText(_selectedTempleName);

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v){

            EditText etHonzon = findViewById(R.id.etHonzon);
            String honzon = etHonzon.getText().toString();

            EditText etShushi = findViewById(R.id.etShushi);
            String shushi = etShushi.getText().toString();

            EditText etAddress = findViewById(R.id.etAddress);
            String address = etAddress.getText().toString();

            EditText etUrl = findViewById(R.id.etUrl);
            String url = etUrl.getText().toString();

            EditText etContent = findViewById(R.id.etContent);
            String note = etContent.getText().toString();

            DatabaseHelper helper = new DatabaseHelper(TempleEditActivity.this);
            SQLiteDatabase db = helper.getWritableDatabase();

            try {
                boolean exist = DatabaseAccess.findRowByPK(db, _selectedTempleNo);
                if(exist){
                    DatabaseAccess.update(db, _selectedTempleNo,_selectedTempleName,honzon,shushi,address,url,note);
                }else {
                    DatabaseAccess.insert(db, _selectedTempleNo,_selectedTempleName,honzon,shushi,address,url,note);
                }
            }
            catch (Exception ex){
                Log.e("ERROR",ex.toString());
            }
            finally {
                db.close();
            }

            finish();
        }
    }
}

