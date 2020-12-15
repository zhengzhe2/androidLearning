package com.example.androidlearning;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListViewTest extends BasicActivity{
    private static final String TAG = "ListViewTest";

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon",
        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
            "Pineapple", "Strawberry", "Cherry", "Mango"};

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewTest.this, android.R.layout.simple_list_item_1, data);
//        ListView listView = (ListView)findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(ListViewTest.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewTest.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 3; ++i) {
            Fruit apple = new Fruit("Apple", R.drawable.ic_launcher_background);
            fruitList.add(apple);
            Fruit Banana = new Fruit("Banana", R.drawable.ic_launcher_foreground);
            fruitList.add(Banana);
            Fruit Orange = new Fruit("Orange", R.drawable.ic_launcher_background);
            fruitList.add(Orange);
            Fruit Watermelon = new Fruit("Watermelon", R.drawable.ic_launcher_foreground);
            fruitList.add(Watermelon);
            Fruit Pear = new Fruit("Pear", R.drawable.ic_launcher_background);
            fruitList.add(Pear);
            Fruit Grape = new Fruit("Grape", R.drawable.ic_launcher_foreground);
            fruitList.add(Grape);
        }
    }
}
