package Task1;


public class Card {

    private StringBuffer name;
    private int count;

    public Card()
    {
        name = new StringBuffer();
        count = 0;
    }

    public void setName(String nameGuests)
    {
        name.append(nameGuests);
        name.append(" ");
        count++;
    }

    public int getCount()
    {
        return count;
    }

    public void clear()
    {
        count = 0;
        name.delete(0, name.length());
    }

    public void display()
    {
        System.out.println(name.toString());
    }
}
