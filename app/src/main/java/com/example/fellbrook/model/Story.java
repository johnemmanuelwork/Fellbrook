package com.example.fellbrook.model;

import com.example.fellbrook.R;

public class Story {

    private Page[] pages;
    public Story(){
        pages = new Page[7];

        pages[0] = new Page( //R.drawable.page0,
                R.string.page0,
                new Choice(R.string.page0_choice1, 1),
                new Choice(R.string.page0_choice2, 2),
                new Choice(R.string.page0_choice3, 2),
                new Choice(R.string.page0_choice4, 2));

        pages[1] = new Page(//R.drawable.page1,
                R.string.page1,
                new Choice(R.string.page0_choice1, 3),
                new Choice(R.string.page0_choice2, 4),
                new Choice(R.string.page0_choice3, 2),
                new Choice(R.string.page0_choice4, 2));

        pages[2] = new Page(//R.drawable.page2,
                R.string.page2,
                new Choice(R.string.page0_choice1, 4),
                new Choice(R.string.page0_choice2, 6),
                new Choice(R.string.page0_choice3, 2),
                new Choice(R.string.page0_choice4, 2));

        pages[3] = new Page(//R.drawable.page3,
                R.string.page3,
                new Choice(R.string.page0_choice1, 4),
                new Choice(R.string.page0_choice2, 5),
                new Choice(R.string.page0_choice3, 2),
                new Choice(R.string.page0_choice4, 2));

        pages[4] = new Page(//R.drawable.page4,
                R.string.page4,
                new Choice(R.string.page0_choice1, 5),
                new Choice(R.string.page0_choice2, 6),
                new Choice(R.string.page0_choice3, 2),
                new Choice(R.string.page0_choice4, 2));

        //R.drawable.page5,
        pages[5] = new Page(R.string.page5);

        //R.drawable.page5,
        pages[6] = new Page(R.string.page6);
    }

    public Page getPage(int pageNumber) {
        if (pageNumber >= pages.length) {
            pageNumber = 0;
        }
        return pages[pageNumber];
    }
}
