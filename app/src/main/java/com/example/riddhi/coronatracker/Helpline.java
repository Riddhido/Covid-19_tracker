package com.example.riddhi.coronatracker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import retrofit2.http.Url;

public class Helpline extends AppCompatActivity {
    ListView listView;
    ImageView back;
    String stateName[]={"Andhra Pradesh","Arunachal Pradesh","Assam",
            "Bihar","Chhattisgarh","Goa","Gujarat","Haryana",
            "Himachal Pradesh","Jharkhand","Karnataka","Kerala",
            "Madhya Pradesh","Maharashtra","Manipur","Meghalaya",
            "Mizoram","Nagaland","Odisha","Punjab","Rajasthan",
            "Sikkim","Tamil Nadu","Telangana","Tripura",
            "Uttarakhand","Uttar Pradesh","West Bengal",
            "Andaman and Nicobar Islands","Chandigarh","Dadra and Nagar Haveli and Daman and Diu","Delhi","Jammu & Kashmir","Ladakh","Lakshadweep","Puducherry"};

    String numbers[]={"0866-2410978","9436055743","6913347770","104","104","104","104","8558893911","104","104",
            "104","0471-2552056","104","020-26127394","3852411668","108","102","7005539653",
            "9439994859","104","0141-2225624","104","044-29510500","104","0381-2315879","104","18001805145","1800313444222",
            "03192-232102","9779558282","104","011-22307145","01912520982","01982256462","104","104"};
    int images[]={R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,
            R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,
            R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,
            R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,
            R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,
            R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,
            R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,
            R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone,
            R.drawable.ic_phone,R.drawable.ic_phone,R.drawable.ic_phone};

    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);
        back=findViewById(R.id.back_arrow_helpline);
        back.setOnClickListener(v -> onBackPressed());
        listView=findViewById(R.id.listview);
        adapter=new MyAdapter(this,stateName,images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i=0;i<36;i++)
                {
                    if(position==i){
                        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+numbers[position]));
                        startActivity(intent);
                    }
                }

            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String state[];
        int call[];
        MyAdapter(Context c,String stateName[],int image[]){
            super(c,R.layout.row,stateName);
            this.context=c;
            this.state=stateName;
            this.call=image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images=row.findViewById(R.id.Call);
            TextView state_name=row.findViewById(R.id.tvStateName);
            images.setImageResource(call[position]);
            state_name.setText(state[position]);
            return row;
        }


    }
}
