package qdu.my.ch1_intent_extra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Image_act extends Activity{
	public int[] imgs = new int[]
            {
                R.drawable.icon1,R.drawable.icon2,R.drawable.icon3,R.drawable.icon4,
                R.drawable.icon5,R.drawable.icon6,R.drawable.icon7,R.drawable.icon8,
                R.drawable.icon9,R.drawable.icon10
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageact_ly);

        GridView gd = (GridView)findViewById(R.id.gridicon);
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imgs.length;
            }
            //
            @Override
            public Object getItem(int position) {
                return position;
            }
            //
            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;
                if(convertView == null){
                    imageView = new ImageView(Image_act.this);
                    
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(111);
                    imageView.setMaxWidth(111);
                    imageView.setPadding(5,5,5,5);
                }
                else  imageView = (ImageView)convertView;

                imageView.setImageResource(imgs[position]);
                return imageView;

            }
        };

        gd.setAdapter(baseAdapter);


        gd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = getIntent();
                Bundle bd = new Bundle();
                bd.putInt("imgid",imgs[position]);
                it.putExtras(bd);
                setResult(0x123,it);
                finish();
            }
        });
    }
}
