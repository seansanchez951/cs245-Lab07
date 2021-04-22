/*
* Main testing class for BST
* @author: USFCACS 245
*/

public class BSTtest
{
    public static void main(String[] args)
    {
        //TODO CHANGE CLASS AS NEEDED TO TEST CODE
        BST<Integer> tree = new BST<>();

//        int L = Integer.parseInt(args[0]);
//        int R = Integer.parseInt(args[1]);
//        for (int i=2; i < args.length; i++)
//        {
//            tree.insert(Integer.parseInt(args[i]));
//
//        }
//
//        tree.delete(Integer.parseInt(args[3]));
//        System.out.println(tree.find(Integer.parseInt(args[4])));
//        tree.print();
//        System.out.println();
//
//        System.out.println("range sum(7,15): " + tree.rangeSum(L, R));


        // below is another test

        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(18);
        tree.insert(4);

        // should print in order
        tree.print();
        System.out.println(" ");

        // testing find is true
        boolean result = tree.find(7);
        System.out.println(result);

        // testing fins is false
        boolean resultFalse = tree.find(50);
        System.out.println(resultFalse);

        // testing delete
        tree.delete(4);

        // print after delete
        tree.print();
        System.out.println(" ");

        // testing rangeSum function
        int L = 5;
        int R = 10;
        System.out.println("results of rangeSum : " + tree.rangeSum(L,R));

    }
}
