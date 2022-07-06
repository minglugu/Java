import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-29
 * @decription: 构造一副扑克牌（数字和花色）
 *              揭牌
 */

class Card {
    private int rank;
    private String suit;

    public Card(String suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "[ " + this.suit +
                " " + this.rank + " ]";
    }
}
public class Test2 {
    // no jokers,1 2 3 ... 10 11 12 13
    private static final String[] suits = {"💕","♠","♣","♦"};

    public static List<Card> buyCard() {
        ArrayList<Card> list = new ArrayList<>();
        // size of suits is 4
        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j <= 13; j++) {
/*                String suit = suits[i];
                int rank = j;
                Card card  = new Card(suit, rank);
                list.add(card);*/
                list.add(new Card(suits[i],j));
            }
        }
        return list;
    }
    private static void swap(List<Card> cards, int i, int j) {
        // Card temp = cards[i]; error，因为不是数组
        Card temp = cards.get(i);
        // cards[i] = cards[j]
        cards.set(i, cards.get(j));
        // cards[j] = temp;
        cards.set(j, temp);
    }

    // 洗牌,
    public static void shuffle(List<Card> cards) {
        int size = cards.size();
        for (int i = size-1; i > 0; i--) {
            Random random = new Random();
            int rand = random.nextInt(i);
            swap(cards, i, rand);
        }
    }

    public static void main(String[] args) {
        List<Card> cards = buyCard();
        System.out.println("买牌" + cards);

        shuffle(cards);
        System.out.println("洗牌" + cards);

        System.out.println("揭牌：3个人，每个人轮流揭牌5张");
        /**
         * hands            hand1
         * 见可见的画图
         */
        ArrayList<ArrayList<Card>> hands = new ArrayList<>();

        ArrayList<Card> hand1 = new ArrayList<>();
        ArrayList<Card> hand2 = new ArrayList<>();
        ArrayList<Card> hand3 = new ArrayList<>();

        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);

        // 每个人总共揭牌5次,轮流揭牌。5是揭多少张牌，第一次，一人揭一张牌；第二次，一人揭一张牌，。。。
        // @02:40:53
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = cards.remove(0);
                hands.get(j).add(card); // 每次都remove 0下标
            }
        }
        System.out.println("第一个人的牌：" + hand1);
        System.out.println("第二个人的牌：" + hand2);
        System.out.println("第三个人的牌：" + hand3);

        System.out.println("剩下的牌：" + cards);

    }
}
