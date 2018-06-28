package com.yanes.album;

/**
 * Created by Claudia and Lidia Yanes.
 */


public class Blackjack_Card {

    private int suit;
    private int value;
    private int money;
    private Integer cardID;
    private boolean flippedUp;

    public Blackjack_Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
        setImage();
    }

    public Integer setImage() {
        cardID = null;
            switch (suit)
            {
                case 0:{ //clubs
                    switch (value){
                        case 0: {cardID = R.drawable.c0;
                        break;}
                        case 1: {cardID = R.drawable.c1;
                        break;}
                        case 2:{ cardID=R.drawable.c2;
                        break;}
                        case 3:{ cardID=R.drawable.c3;
                        break;}
                        case 4:{ cardID=R.drawable.c4;
                        break;}
                        case 5:{ cardID=R.drawable.c5;
                        break;}
                        case 6:{ cardID=R.drawable.c6;
                        break;}
                        case 7:{ cardID=R.drawable.c7;
                        break;}
                        case 8:{ cardID=R.drawable.c8;
                        break;}
                        case 9:{ cardID=R.drawable.c9;
                        break;}
                        case 10:{ cardID=R.drawable.c10;
                        break;}
                        case 11: {cardID = R.drawable.c11;
                        break;}
                        case 12: {cardID = R.drawable.c12;
                        break;}
                    }
                    break;}
                case 1: //hearts
                  {
                    switch (value){
                        case 0:{cardID= R.drawable.h0;
                        break;}
                        case 1:{cardID= R.drawable.h1;
                        break;}
                        case 2:{cardID= R.drawable.h2;
                        break;}
                        case 3:{cardID= R.drawable.h3;
                        break;}
                        case 4:{cardID= R.drawable.h4;
                        break;}
                        case 5:{cardID= R.drawable.h5;
                        break;}
                        case 6:{cardID= R.drawable.h6;
                        break;}
                        case 7:{cardID= R.drawable.h7;
                        break;}
                        case 8:{cardID= R.drawable.h8;
                        break;}
                        case 9:{cardID= R.drawable.h9;
                        break;}
                        case 10:{cardID= R.drawable.h10;
                        break;}
                        case 11:{cardID= R.drawable.h11;
                        break;}
                        case 12:{cardID= R.drawable.h12;
                        break;}
                    }
                    break;
                }
                case 2: //spades
                    {
                    switch (value){
                        case 0:{cardID= R.drawable.s0;
                            break;}
                        case 1:{cardID= R.drawable.s1;
                            break;}
                        case 2:{cardID= R.drawable.s2;
                            break;}
                        case 3:{cardID= R.drawable.s3;
                            break;}
                        case 4:{cardID= R.drawable.s4;
                            break;}
                        case 5:{cardID= R.drawable.s5;
                            break;}
                        case 6:{cardID= R.drawable.s6;
                            break;}
                        case 7:{cardID= R.drawable.s7;
                            break;}
                        case 8:{cardID= R.drawable.s8;
                            break;}
                        case 9:{cardID= R.drawable.s9;
                            break;}
                        case 10:{cardID= R.drawable.s10;
                            break;}
                        case 11:{cardID= R.drawable.s11;
                            break;}
                        case 12:{cardID= R.drawable.s12;
                            break;}
                    }
                    break;
                }
                case 3: //diamonds
                    {
                    switch (value){
                        case 0:{cardID= R.drawable.d0;
                            break;}
                        case 1:{cardID= R.drawable.d1;
                            break;}
                        case 2:{cardID= R.drawable.d2;
                            break;}
                        case 3:{cardID= R.drawable.d3;
                            break;}
                        case 4:{cardID= R.drawable.d4;
                            break;}
                        case 5:{cardID= R.drawable.d5;
                            break;}
                        case 6:{cardID= R.drawable.d6;
                            break;}
                        case 7:{cardID= R.drawable.d7;
                            break;}
                        case 8:{cardID= R.drawable.d8;
                            break;}
                        case 9:{cardID= R.drawable.d9;
                            break;}
                        case 10:{cardID= R.drawable.d10;
                            break;}
                        case 11:{cardID= R.drawable.d11;
                            break;}
                        case 12:{cardID= R.drawable.d12;
                            break;}

                    }
                    break;
                }
                }

        return cardID;
    }

    public int setmoney(){
        money = 0;
        switch (value){
                    case 0: {money= 10;
                        break;}
                    case 1: {money= 11;
                        break;}
                    case 2:{ money= 2;
                        break;}
                    case 3:{ money= 3;
                        break;}
                    case 4:{ money= 4;
                        break;}
                    case 5:{money=5;
                        break;}
                    case 6:{ money=6;
                        break;}
                    case 7:{ money=7;
                        break;}
                    case 8:{ money=8;
                        break;}
                    case 9:{ money=9;
                        break;}
                    case 10:{money=10;
                        break;}
                    case 11: {money= 10;
                        break;}
                    case 12: {money= 10;
                        break;}
                }
        return money;
    }


}


