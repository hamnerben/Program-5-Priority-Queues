public class LeftistHeap<AnyType extends Comparable> {

    public LeftistHeap(){
        root = null;
    }

    public void merge(LeftistHeap<AnyType> rhs){
        //todo: implement later
    }

    public void insert(AnyType x){
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
    }

    private Node<AnyType> root;

    private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2){
        // todo: implement later
        return null; // todo: delete later
    }

    private Node<AnyType> mergeInternal(Node<AnyType> h1, Node<AnyType> h2){
        // todo: implement later
        return null; // todo: delete later
    }

    private void swapChildren(Node<AnyType> t){
        // todo: implement later
    }
}
