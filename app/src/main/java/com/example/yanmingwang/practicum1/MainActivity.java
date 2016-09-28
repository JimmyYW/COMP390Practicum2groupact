/*************************************************************************************************
 * File:   practicum1
 * Author: Jimmy Wang, Trish Cornez
 *
 * Created on 09/09/16
 * Last Modified 09/12/16
 *
 * Purpose: A simple android program that say hello and goodbye and change text on button click for
 *          practice.
 *
 * Algorithm:
 *      a) When user click on exclamationbtn button change text to hello
 *      b) When user click again change text to goodbye
 *      c) When user click on left/right button change text blow to left first and imageview to left
 *         as well
 *      d) when user click again change text blow to right first and imageview to right
 *         as well
 *
 *************************************************************************************************/


package com.example.yanmingwang.practicum1;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //DECLARE  OBJECTS TO INTERFACE WITH LAYOUT COMPONENTS
    private TextView greetingTextView;
    private TextView otherBox;
    private ImageView img;

    //INDICATES HELLO IS CURRENTLY DISPLAYED
    private boolean isHello;
    private boolean inint;
    private boolean isLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //INFLATE THE MAIN SCREEN LAYOUT USED BY THE APP
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add textView, imageView and buttons
        Button exclaimBtn = (Button) findViewById(R.id.button);
        Button leftright = (Button) findViewById(R.id.button2);
        greetingTextView = (TextView) findViewById(R.id.textView);
        otherBox = (TextView) findViewById(R.id.textView2);
        img = (ImageView) findViewById(R.id.imageView);

        //INITIALIZE GREETINGS
        initializeGreeting();

        //REGISTER THE LISTENER EVENT FOR THE BUTTON
        exclaimBtn.setOnClickListener(toggleGreeting);
        leftright.setOnClickListener(toggleleftright);
    }

    /*************************************************************************************************
     * Description: This is a listener for button2. If user click on it, it will change the text
     *              within textView2 and the position of the imageview.(the position is
     *              hard coded as for now)
     *
     * Input:  a element to listen
     *
     * Output: None
     *
     * Global Constants:
     *         None
     *
     * Variables used:
     *         toggleleftright:  button2
     *         isLeft: flag
     *         otherBox: textview
     *         img: imageview
     *
     *
     * Last Modified: 9/12/16
     *************************************************************************************************/
    private final View.OnClickListener toggleleftright =
            new View.OnClickListener() {
                public void onClick(View btn) {
                    if (inint){
                        if (isLeft){
                            isLeft = false;
                            otherBox.setText(R.string.right);
                            img.setX(650);

                        }else {
                            isLeft= true;
                            otherBox.setText(R.string.left);
                            img.setX(0);
                        }
                    }else {
                        inint=false;
                        otherBox.setText(R.string.left);
                        img.setX(0);
                    }
                }
            };

    private final View.OnClickListener toggleGreeting =
            new View.OnClickListener() {
                public void onClick(View btn) {
                    // CONSTRUCT THE TOGGLE GREETING
                    if (isHello) {
                        isHello = false;
                        greetingTextView.setText(R.string.goodbye);
                    } else {
                        isHello = true;
                        greetingTextView.setText(R.string.hello);
                    }
                }
            };

    private void initializeGreeting() {
        //set init
        isHello = true;
        inint = true;
        isLeft = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        // this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
