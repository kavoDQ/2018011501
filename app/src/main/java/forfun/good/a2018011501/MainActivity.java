package forfun.good.a2018011501;

import android.app.VoiceInteractor;
import android.graphics.Bitmap;
import android.service.voice.VoiceInteractionSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb ;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.progressBar);
        img = findViewById(R.id.imageView);
    }
    public void CL1(View v)
    {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        pb.setVisibility(View.VISIBLE);  //一開始看的到
        img.setVisibility(View.INVISIBLE); //一開始消失
        ImageRequest request = new ImageRequest("http://img3.okgo.tw/titlepic/b3409_2.jpg",

            new Response.Listener<Bitmap>() { //當擷取到之後的動作
                    @Override
                    public void onResponse(Bitmap response) {
                        img.setImageBitmap(response);
                        pb.setVisibility(View.INVISIBLE);
                        img.setVisibility(View.VISIBLE);
                    }
                }

                , 0, 0 //設定圖片長寬 0代表自動配釋
                , ImageView.ScaleType.FIT_XY //自動修正XY
                , Bitmap.Config.RGB_565
                , new Response.ErrorListener() { //遇到錯誤怎麼辦
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();
    }
    public  void CL2(View V)
    {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new UTF8StringRequest("https://www.mobile01.com/rss/news.xml"//抓此連結
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Net", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        queue.add(request);
        queue.start();

    }
}
