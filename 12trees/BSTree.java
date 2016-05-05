public class BSTree<T extends Comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

	public Node(T value){
	    data = value;
	}

	public void setLeft(Node child){
	    left = child;
	}

	public void setRight(Node child){
	    right = child;
	}

	public Node getLeft(){
	    return left;
	}

	public Node getRight(){
	    return right;
	}
	  
	public T getData(){
	    return data;
	}
	
	public int height(){
	    if (left == null && right == null){
		return 1;
	    } else if (left == null && right != null){
		return right.height() + 1;
	    } else if (right == null && left != null){
		return left.height() + 1;
	    } else {
		return Math.max(left.height(), right.height()) + 1;
	    }
	}

	public void add(T value){
	    if (value.compareTo(data)<0){
		if (left == null){
		    left = new Node(value);
		} else {
		    left.add(value);
		}
	    } else {
		if (right == null){
		    right = new Node(value);
		} else {
		    right.add(value);
		}
	    }
	}

	public String toString(){
	    if (left == null && right == null){
		return data + " _ _";
	    } else if (left == null){
		return data + " _ " + right;
	    } else if (right == null){
		return data + " " + left + " _";
	    } else {
		return " " + data + " " + left + " " + right;
	    }
	}

	public boolean contains(T value){
	    if (data.compareTo(value) == 0){
		return true;
	    } else if (left != null && right != null){
		return left.contains(value) || right.contains(value);
	    } else if (left != null){
		return left.contains(value);
	    } else if (right != null){
		return right.contains(value);
	    }
	    return false;
	}
    }

    private Node root;
                
    public void add(T value){
	if (root == null){
	    root = new Node(value);
	} else {
	    root.add(value);
	}
    }

    public String toString(){
	return root.toString();
    }

    public boolean contains(T value){
	if (root.getData() == null){
	    return false;
	} else {
	    return root.contains(value);
	}	
    }

    public int getHeight(){
	if (root.getData() == null){
	    return 0;
	}
	return root.height();
    }
 
    
}