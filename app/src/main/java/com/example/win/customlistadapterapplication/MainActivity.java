package com.example.win.customlistadapterapplication;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //int[] images={R.drawable.sachin,R.drawable.amitabh,R.drawable.sundar,R.drawable.smiley,R.drawable.smiley,R.drawable.smiley,R.drawable.smiley};
   //String[] names={"Sachin", "Amitabh","Sundar","Name","Name","Name","Name"};
  // String[] desc={"Sport","Actor","CEO","Desc","Desc","Desc","Desc"};


   List<People> peopleList=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        peopleList.add(new People(R.drawable.sachin,"Sachin","Sport"));
//        peopleList.add(new People(R.drawable.sachin,"Sachin","Sport"));
//        peopleList.add(new People(R.drawable.sachin,"Sachin","Sport"));
//        peopleList.add(new People(R.drawable.sachin,"Sachin","Sport"));
//        peopleList.add(new People(R.drawable.sachin,"Sachin","Sport"));
//
        for(int i=0;i<5;i++){
            People people=new People();
            people.setImage(R.drawable.sachin);
            people.setName("Sachin"+i);
            people.setDesc("Sport"+i);
            peopleList.add(people);
        }


        ListView listView=(ListView)findViewById(R.id.list_view);
        CustomAdaptor customAdaptor=new CustomAdaptor();
        listView.setAdapter(customAdaptor);

    }

    class CustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return peopleList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.list_item,null);

            ImageView imageView=(ImageView)view.findViewById(R.id.image);
            TextView textViewName=(TextView)view.findViewById(R.id.name);
            TextView textViewDesc=(TextView)view.findViewById(R.id.desc);

            imageView.setImageResource(peopleList.get(position).getImage());
            textViewName.setText(peopleList.get(position).getName());
            textViewDesc.setText(peopleList.get(position).getDesc());


            return view;
        }
    }
}
