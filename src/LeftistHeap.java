public class LeftistHeap<AnyType extends Comparable> {

    public static void  main(String[] args){
        LeftistHeap<Integer> heap = new LeftistHeap<>();
        heap.printTree("-");
        Integer[] list = {3,2,4,10,9,4,1,7,8,7,34,234,65,76,23,12,87,98};
        for(Integer i : list){
            heap.insert(i);
            System.out.println("After insert of (" + i + "):");
            heap.printTree("-");
            System.out.println("=========================");
        }

    }


    public LeftistHeap(){
        root = null;
    }

    /***
     * Merge another Leftist heap to this heap
     * @param rhs: the right heap sort to merge to this LeftistHeap
     */
    public void merge(LeftistHeap<AnyType> rhs){
        root = merge(root, rhs.root);
        rhs.root = null;
    }

    public void insert(AnyType x){
        root = merge(new Node<AnyType>(x), root);
        //todo: implement later
    }

    public AnyType findMin(){
        //todo: implement later
        return null; // todo: delete
    }

    public AnyType deleteMin(){
        //todo: implement later
        return null; // todo: delete later
    }

    public boolean isEmpty(){
        return this.root == null;
    }
    public void MakeEmpty(){
        root = null;
    }

    /***
     * Method to print a Leftist Heap
     * @param label: the title for the heap to be printed
     */
    public void printTree( String label )
    {
        System.out.println(label);
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root,"");
    }


    /***
     *  Internal Method to print a LeftistHeap
     * @param t: the root to be printed
     * @param indent: the String to use as the indent
     */
    private void printTree( Node<AnyType> t, String indent )
    {
        if( t != null )
        {
            printTree( t.right, indent+"   " );
            System.out.println( indent+ t.element + "("+ t.npl  +")" );
            printTree( t.left, indent+"   " );
        }
    }

    private static class Node<AnyType>{
        AnyType element;
        Node<AnyType> left;
        Node<AnyType> right;
        int npl;
        Node(AnyType element){
            this(element, null, null);
        }
        Node(AnyType e, Node<AnyType> lt, Node<AnyType> rt){
            element = e;
            left = lt;
            right = rt;
            npl = 0;
        }
        /***
         * swaps the children of t.
         * Does nothing if t is null;
         */
        private void swapChildren(){
                Node<AnyType> temp = right;
                right = left;
                left = temp;
        }

        /***
         * corrects the npl for the node
         */
        private void updateNpl(){
            if(right == null || left == null){
                npl = 0;
            }
            else {
                npl = (Math.min(right.npl, left.npl) + 1);
            }
        }

        private boolean isLeftist(){
            if(left != null && right != null){
                return (left.npl >= right.npl);
            }
            if(left == null){
                return (right == null);
            }
            return true; // left is not null and right is null
        }

    }

    private Node<AnyType> root;

    /***
     * internal method for merging two heaps
     * @param h1 the first heap to merge, has smallest item
     * @param h2 the second heap to merge
     * @return the new root node of the merged heap
     */
    private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2){
        Node<AnyType> small;
        if(h1 == null) return h2; // if one is null, return the other
        if(h2 == null) return h1;
        if(h1.element.compareTo(h2.element) < 0){
            h1.right = merge(h1.right, h2);
            small = h1;
        }
        else {
            h2.right = merge(h2.right, h1);
            small = h2;
        }
        //todo: check for Leftist Property and swap kids
        small.updateNpl(); // I think this is correct spot to do this recursively
        if(!small.isLeftist()) { // if not leftist
            small.swapChildren();
        }
        return small;
    }



}
