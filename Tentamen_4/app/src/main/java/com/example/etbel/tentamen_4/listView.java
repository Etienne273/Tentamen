package com.example.etbel.tentamen_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Etbel on 14-6-2017.
 */

    public class listView extends AppCompatActivity implements requestMovies.OnRandomUserAvailable, ListView.OnItemClickListener {

        private ArrayList<Films> voorstellingItems = new ArrayList<>();
        private ListView basicListView = null;
        private static final String TAG = "MainActivity";
        private adapter ArrayAdapter = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            basicListView = (ListView) findViewById(R.id.listview);

            ArrayAdapter = new adapter(getApplicationContext(),
                    getLayoutInflater(), voorstellingItems);


            basicListView.setAdapter(ArrayAdapter);
            basicListView.setOnItemClickListener(this);

            requestMovies getRandomUser = new requestMovies(this);
            String[] urls = new String[] { "https://api.themoviedb.org/3/movie/upcoming?api_key=863618e1d5c5f5cc4e34a37c49b8338e" };
            getRandomUser.execute(urls);

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);

        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Films voorstelling = (Films) voorstellingItems.get(position);

            Intent intent = new Intent (getApplicationContext(), Detailed.class);



            startActivity(intent);

        }
        public void onRandomUserAvailable(Films films) {

            voorstellingItems.add(films);
            Log.i(TAG, "Person added (" + films.toString() + ")");
            ArrayAdapter.notifyDataSetChanged();
        }


    }

