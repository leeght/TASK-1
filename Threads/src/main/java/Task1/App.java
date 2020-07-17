package Task1 ;

public class App
{
    public static void main( String[] args )
    {
        Card card = new Card();
        Runnable guest = () -> {
            String name = Thread.currentThread().getName();
            synchronized (card) {
                try {
                    while (card.getCount() >= 4)
//                  if(card.getCount() >= 4)
                        card.wait();
                    card.setName(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Operator operator = new Operator(card);
        new Thread(operator).start();
        for(int i = 0;i < 100; i++)
            new Thread(guest).start();
    }
}
