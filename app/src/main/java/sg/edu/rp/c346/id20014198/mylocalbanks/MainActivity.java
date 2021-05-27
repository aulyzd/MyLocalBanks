package sg.edu.rp.c346.id20014198.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String wordClicked ="";
    boolean favdbs = false;
    boolean favocbc = false;
    boolean favuob = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS=findViewById(R.id.textViewDBS);
        tvOCBC=findViewById(R.id.textViewOCBC);
        tvUOB=findViewById(R.id.textViewUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if(v == tvDBS) {
            wordClicked = "DBS";
        }
        else if (v == tvOCBC) {
            wordClicked = "OCBC";
        }
        else if (v == tvUOB) {
            wordClicked = "UOB";
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(wordClicked == "DBS") {
            if (id == R.id.WebsiteSelection) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
                startActivity(i);
                return true;
            } else if (id == R.id.ContactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbsNum)));
                startActivity(intentCall);
                return true;
            } else {

                if (!favdbs ){
                    favdbs = true;
                    tvDBS.setTextColor(Color.RED);
                }else {
                    favdbs = false;
                    tvDBS.setTextColor(Color.BLACK);
                }
            }


        }

            else if (wordClicked == "OCBC") {
                if (id == R.id.WebsiteSelection) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
                    startActivity(i);
                    return true;
                } else if (id == R.id.ContactSelection) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.ocbcNum)));
                    startActivity(intentCall);
                    return true;
                }
                else {

                    if (!favocbc){
                        favocbc = true;
                        tvOCBC.setTextColor(Color.RED);
                    }else {
                        favocbc = false;
                        tvOCBC.setTextColor(Color.BLACK);
                    }
                }

        }
            else if (wordClicked == "UOB") {
                if (id == R.id.WebsiteSelection) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
                    startActivity(i);
                    return true;
                } else if (id == R.id.ContactSelection) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobNum)));
                    startActivity(intentCall);
                    return true;
                }else{

                    if (!favuob){
                        favuob = true;
                        tvUOB.setTextColor(Color.RED);
                    }else {
                        favuob = false;
                        tvUOB.setTextColor(Color.BLACK);
            }
        }

    }



        return super.onContextItemSelected(item);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {

            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(getString(R.string.c_dbs));
            tvOCBC.setText(getString(R.string.c_ocbc));
            tvUOB.setText(getString(R.string.c_uob));
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

}