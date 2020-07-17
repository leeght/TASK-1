package Task1;

import static java.lang.Thread.sleep;

public class Operator implements Runnable{

    private int countCards = 25;
    private int countGuests = 100;
    private Card card;

    public Operator(Card _card)
    {
        this.card = _card;
    }

    @Override
    public void run() {
        while (countGuests!=0)
        {
            try
            {
                sleep(1000);
                synchronized (card)
                {
                    if(card.getCount() >= 4)
                    {
                        System.out.print("Card № " + (26 - countCards) + ", Guests: ");
                        card.display();
                        card.clear();
                        countGuests-=4;
                        countCards-=1;
                        System.out.println("Count of Guests = " + countGuests);
                        card.notifyAll();
//                        for(int i = 0; i < 4; i++)
//                            card.notify();
                    }
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
