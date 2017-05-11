/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int mHeadIndex;
    private int mBodyIndex;
    private int mLegIndex;
    private int mBodyPart;

    public static String HEAD_KEY;
    public static String BODY_KEY;
    public static String LEG_KEY;

    Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // TODO (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments

        mBodyPart =position/12;

        int listIndex=position-12*mBodyPart;

        switch (mBodyPart){
            case 0:
                mHeadIndex=listIndex;
                Toast.makeText(this, "Please Choose the Body", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                mBodyIndex=listIndex;
                Toast.makeText(this, "Please Choose the Leg", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                mLegIndex=listIndex;
                break;
            default:
                mHeadIndex=0;
                mBodyIndex=12;
                mLegIndex=24;

        }

        // TODO (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        final Intent intent=new Intent(MainActivity.this,AndroidMeActivity.class);
        intent.putExtra(HEAD_KEY,mHeadIndex);
        intent.putExtra(BODY_KEY,mBodyIndex);
        intent.putExtra(LEG_KEY,mLegIndex);

        // TODO (4) Get a reference to the "Next" button and launch the intent when this button is clicked
        mButton=(Button)findViewById(R.id.button);



        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });


    }

}
