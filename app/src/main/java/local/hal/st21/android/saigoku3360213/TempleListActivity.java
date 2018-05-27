package local.hal.st21.android.saigoku3360213;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TempleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple_list);

        ListView lvTemple = findViewById(R.id.lvTemple);

        List<String> teraList = createTeraList();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(TempleListActivity.this,
                android.R.layout.simple_list_item_1,teraList);
        lvTemple.setAdapter(adapter);

        lvTemple.setOnItemClickListener(new ListItemClickListener());
    }

    private List<String> createTeraList() {
        List<String> teraList = new ArrayList<>();
        teraList.add("第一番　青岸渡寺");
        teraList.add("第二番 　金剛宝寺");
        teraList.add("第三番 　粉河寺");
        teraList.add("第四番 　施福寺");
        teraList.add("第五番 　葛井寺");
        teraList.add("第六番 　南法華寺");
        teraList.add("第七番 　岡寺");
        teraList.add("第八番 　長谷寺");
        teraList.add("第九番 　南円堂");
        teraList.add("第十番 　三室戸寺");
        teraList.add("第十一番 　上醍醐 准胝堂");
        teraList.add("第十二番 　正法寺");
        teraList.add("第十三番 　石山寺");
        teraList.add("第十四番 　三井寺");
        teraList.add("第十五番 　今熊野観音寺");
        teraList.add("第十六番 　清水寺");
        teraList.add("第十七番 　六波羅蜜寺");
        teraList.add("第十八番 　六角堂 頂法寺");
        teraList.add("第十九番 　革堂 行願寺");
        teraList.add("第二十番 　善峯寺");
        teraList.add("第二十一番 　穴太寺");
        teraList.add("第二十二番 　総持寺");
        teraList.add("第二十三番 　勝尾寺");
        teraList.add("第二十四番 　中山寺");
        teraList.add("第二十五番 　播州清水寺");
        teraList.add("第二十六番 　一乗寺");
        teraList.add("第二十七番 　圓教寺");
        teraList.add("第二十八番 　成相寺");
        teraList.add("第二十九番 　松尾寺");
        teraList.add("第三十番 　宝厳寺");
        teraList.add("第三十一番 　長命寺");
        teraList.add("第三十二番 　観音正寺");
        teraList.add("第三十三番 　華厳寺");
        return teraList;
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            String teraName = (String) parent.getItemAtPosition(position);

            Intent intent = new Intent(TempleListActivity.this,TempleEditActivity.class);
            intent.putExtra("selectedTempleNo",position);
            intent.putExtra("selectedTempleName",teraName);
            startActivity(intent);
        }

    }
}
