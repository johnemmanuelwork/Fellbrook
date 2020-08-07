package com.example.fellbrook.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fellbrook.R;
import com.example.fellbrook.model.Page;
import com.example.fellbrook.model.Story;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    private Page[] pages;

    private Story story;
    private ImageView storyImageView;
    private Button characterMenuButton;
    private Button inventoryMenuButton;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;
    private Button choice3Button;
    private Button choice4Button;
    //private Stack<integer> pageStack = newStack<Integer>();
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //Adding toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        //Adding menu
        characterMenuButton = findViewById(R.id.characterMenuButton);
        characterMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        StoryActivity.this,R.style.BottomSheet
                );
                View bottomSheet = LayoutInflater.from(getApplicationContext())
                        .inflate(R.layout.bottom_sheet_layout_character,
                                (LinearLayout) findViewById(R.id.bottomSheetCont));
                bottomSheet.findViewById(R.id.contLayoutOne).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(StoryActivity.this, "Option 1", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(bottomSheet);
                bottomSheetDialog.show();
            }
        });

        //Adding inventory
                inventoryMenuButton = findViewById(R.id.inventoryMenuButton);
                inventoryMenuButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                                StoryActivity.this,R.style.BottomSheet
                        );
                        View bottomSheet = LayoutInflater.from(getApplicationContext())
                                .inflate(R.layout.bottom_sheet_layout_inventory,
                                        (LinearLayout) findViewById(R.id.bottomSheetCont));
                        bottomSheet.findViewById(R.id.contLayoutOne).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(StoryActivity.this, "Option 1", Toast.LENGTH_SHORT).show();
                                bottomSheetDialog.dismiss();
                            }
                        });
                        bottomSheetDialog.setContentView(bottomSheet);
                        bottomSheetDialog.show();
            }
        });

        //storyImageView = (ImageView) findViewById(R.id.storyImageView);
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        choice1Button = (Button)findViewById(R.id.choice1Button);
        choice2Button = (Button)findViewById(R.id.choice2Button);
        choice3Button = (Button)findViewById(R.id.choice3Button);
        choice4Button = (Button)findViewById(R.id.choice4Button);

        Intent intent = getIntent();
        story = new Story();
        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        //pageStack.push(pageNumber);
        final Page page = story.getPage(pageNumber);

        //Drawable image = ContextCompat.getDrawable(this, page.getImageId());
        //storyImageView.setImageDrawable();

        String pageText = getString(page.getTextId());
        pageText = String.format(pageText); //FIRST
        storyTextView.setText(pageText);

        if (page.isFinalPage()) {
            choice1Button.setVisibility(View.INVISIBLE);
            choice3Button.setVisibility(View.GONE);
            choice4Button.setVisibility(View.GONE);
            choice2Button.setText("Congratulations! You completed the game!");
            choice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        loadPage(0);
                }
            });

        }
        else {
            choice1Button.setVisibility(View.INVISIBLE);
            choice2Button.setVisibility(View.INVISIBLE);
            choice3Button.setVisibility(View.GONE);
            choice4Button.setVisibility(View.GONE);
            loadButtons(page);
        }
    }

    private void loadButtons(final Page page) {
        choice1Button.setVisibility(View.VISIBLE);
        choice1Button.setText(page.getChoice1().getTextId());
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice1().getNextPage();
                loadPage(nextPage);
            }
        });
        choice2Button.setVisibility(View.VISIBLE);
        choice2Button.setText(page.getChoice2().getTextId());
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
        if (TextUtils.isEmpty(getText(page.getChoice3().getTextId()))) {
            //do nothing
        } else {
            choice3Button.setVisibility(View.VISIBLE);
            choice3Button.setText(page.getChoice3().getTextId());
            choice3Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = page.getChoice3().getNextPage();
                    loadPage(nextPage);
                }
            });
        };
        if (TextUtils.isEmpty(getText(page.getChoice4().getTextId()))) {
            //do nothing
        } else {
            choice4Button.setVisibility(View.VISIBLE);
            choice4Button.setText(page.getChoice4().getTextId());
            choice4Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = page.getChoice4().getNextPage();
                    loadPage(nextPage);
                }
            });
        };
    }
}
