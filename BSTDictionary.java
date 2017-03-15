//Brij Patel 101008373
public class BSTDictionary<E,K extends Sortable> implements Dictionary{
BSTNode<String,SortableString> root;
BSTNode<String,SortableString> currentnode;

public BSTDictionary(){
  root = null;
}

public BSTDictionary(){
  this.root = root;
}

public String search(Sortable key){
BSTNode<String,SortableString> tempnode;
if(currentnode == null){
  currentnode = root;
  return null;
}
  if(currentnode.getKey().compareTo(key) == 0){//if key is equal then it'll equal 0
    tempnode = new BSTNode<String,SortableString>(currentnode.getKey(),currentnode.getElement(),currentnode.getLeft(),currentnode.getRight());//creates copy of currentnode so that it can be set back to root
    currentnode = root;
    System.out.print((String)tempnode.getElement()+" <- was found: ");
    return (String)tempnode.getElement();
  }//ends case where key is found
  else if(currentnode.getKey().comparTo(key) < 0){//key is less than currentnode means search left
    currentnode = currentnode.getLeft();
    return search(key);
  }//ends case where key not found so search to left
  else if(currentnode.getKey().compareTo(key)>0){
    currentnode = currentnode.getRight();
    return search(key);
  }
}// ends search

public void insert(Sortable key, Object element){
  BSTNode<String,SortableString> tempnode = new BSTNode<String,SortableString>((SortableString)key,(String)element,null,null);//creates new node with key and element
  if(root == null){
    root = tempnode;
    currentnode = root;
  }
  else if(currentnode.getKey().compareTo(tempnode.getKey()) != 0){//checks if key is not repeated
    if(tempnode.getKey().compareTo(currentnode.getKey()) <0){
      if(currentnode.getLeft() = null){//nothing in the left
        currentnode.setLeft(tempnode);
        currentnode = root;
      } else {//node in the left so update currentnode
        currentnode = currentnode.getLeft();
        insert(key,element);
      }
    }
    if(currentnode.getKey().compareTo(tempnode.getKey())>0){
      if(currentnode.getRight() == null){
        currentnode.setRight(tempnode);
        currentnode = root;
      } else {
        currentnode = currentnode.getRight();
        insert(key,element);
      }
    }
  }

}//ends insert

public void delete(Sortable key){
  BSTNode<String,SortableString> parent = null;
  BSTNode<String,SortableString> target = null; //target node will be deleted
  BSTNode<String,SortableString> curr = root; //the node being evaluated
  if(key != null){ //ensures that key is not null
    while(curr != null){//loop finds location of element
      if(key.compareTo(curr.getKey()) == 0){ //key is found
        target = curr;
        break;
      }
      else if(key.compareTo(curr.getKey()) < 0){ //if key is less go to left
        parent = curr;
        curr = curr.getLeft();
      }
      else if(key.compareTo(curr,getKey()) > 0){//if key is greater go to right
        parent = curr;
        curr = curr.getRight();
      }
    }
      if(target != null){
          if(target.getLeft() != null && target.getRight() != null){
            BSTNode<String,SortableString> tempnode = findmin(target.getRight()); //finds min value on the right
            //intead of deleting the target node the key values are exchanged for minimum value found in the right
            target.key = tempnode.getKey();
            target.element = tempnode.getElement();
            tempnode = null;//delete the node
          }
          else if(target.getLeft() == null && target.getRight() != null){//if node being deleted only has a rightnode
            //sets the rightnode of the element to be deleted
            parent.setRight(target.getRight());
            target = null
          }
          else { //the node does not have any children
            target = null;
          }
      }
    }//ends while

  }//ends if

}//ends delete

public void printTree(){
  System.out.println(preordertraversal(new BSTNode<String,SortableString>(root.getKey(),root.getElement(),root.getLeft(),root.getRight())));
}//ends printTree

public String preordertraversal(BSTNode<String,SortableString> rootnode){
  String s = " ";//space between elements
  if(rootnode == null){
    return "";
  }
  s+=rootnode.getElement();
  s+=preordertraversal(rootnode.getLeft());//goes through all nodes attached to left
  s+=preordertraversal(rootnode.getRight());//goes through all nodes attached to right
  return s;
}//ends preordertraversal
}
