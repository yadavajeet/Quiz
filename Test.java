public class Test
{
    public static void main(String[] args)
    {
        // Creating object of class CustomLinkedList
        CustomLinkedList list = new CustomLinkedList();

        //Adding elements to List
        list.add(8);
        list.add(17);
        list.add(10);
        list.add(34);
        list.add(1);
        list.add(2);
		
		//Show all list elements
        list.show();

        list.removeTailElement();
        list.show();

        list.removeElementsGreaterThanTo(10);
        list.show();

        list.removeTailElement();
        list.show();
    }
}