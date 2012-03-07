package com.androidbook.triviaquiz;

import java.util.*;
import java.lang.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class QuizMenuActivity extends QuizActivity {
	
	 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        //layout animation
        LinearLayout layout = (LinearLayout) findViewById(R.id.menu_main_layout);
        Animation layout_animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        LayoutAnimationController controller = new LayoutAnimationController(layout_animation);
        layout.setLayoutAnimation(controller);
        
       //MyAdapter simple = simpleAdapterKokeilu();
        
        //ListView items
        ListView menuList = (ListView)findViewById(R.id.listView_menu);
        
        String items[] = {getResources().getString(R.string.listview_item1),
         		getResources().getString(R.string.listview_item2),
         				getResources().getString(R.string.listview_item3),
         						getResources().getString(R.string.listview_item4)};
     
        //Array put in a form of a layout file
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
        		R.layout.menu_item, items);
       
        
        menuList.setAdapter(adapter);
        //Menu listener
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
					long id) {
				// TODO Auto-generated method stub
				TextView textview = (TextView) itemClicked;
				String strItem = textview.getText().toString();
				if(strItem.equalsIgnoreCase(getResources().getString(
						R.string.listview_item1))){
					startActivity(new Intent(getApplicationContext(), QuizGameActivity.class));
				}
				else if(strItem.equalsIgnoreCase(getResources().getString(
						R.string.listview_item2))){
					startActivity(new Intent(getApplicationContext(), QuizScoresActivity.class));
				}
				else if(strItem.equalsIgnoreCase(getResources().getString(
						R.string.listview_item3))){
					startActivity(new Intent(getApplicationContext(), QuizSettingsActivity.class));
				}
				else if(strItem.equalsIgnoreCase(getResources().getString(
						R.string.listview_item4))){
					startActivity(new Intent(getApplicationContext(), QuizHelpActivity.class));
				}
			}
		});
    }
    
    /*private MyAdapter simpleAdapterKokeilu() {
    	 String[] from = {"name", "image"};
         int[] to = {R.id.menu_listview_image,R.id.menu_listview_text};
         String menu_items[] = {getResources().getString(R.string.listview_item1),
          		getResources().getString(R.string.listview_item2),
          				getResources().getString(R.string.listview_item3),
          						getResources().getString(R.string.listview_item4)};
         
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(from[0], menu_items[0]);
        map.put(from[1], R.drawable.quizicon);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put(from[0], menu_items[1]);
        map.put(from[1], R.drawable.quizicon);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put(from[0], menu_items[2]);
        map.put(from[1], R.drawable.quizicon);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put(from[0], menu_items[3]);
        map.put(from[1], R.drawable.quizicon);
        list.add(map);
        
        return new MyAdapter(getApplicationContext(), list, R.layout.menu_item, from, to);
        
    }
    
    private class MyAdapter extends SimpleAdapter {
    	
    	public MyAdapter(Context context, List<? extends Map<String, ?>> list, 
    			int resource, String[] from, int[] to) {
    		
    		super(context, list, resource, from, to);
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.menu_item,
                        null);
            }

            HashMap<String, Object> data = (HashMap<String, Object>) getItem(position);

            ((TextView) convertView.findViewById(R.id.menu_listview_text))
                    .setText((String) data.get("name"));
            ((ImageView) convertView.findViewById(R.id.menu_listview_image))
                    .setImageResource(R.drawable.quizicon);

            return convertView;
        }
    	
    	
    }*/
}