
// -----------------------------------------------------
// Assignment 4
// Question: 2
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------
import java.util.NoSuchElementException;

/**
 * Zafir Khalid - 40152164 COMP 249 Assignment 4 Due Date: Friday Dec 4, 2020
 */

// A LinkedList class definition along with node class definition
// Has various methods to help the user add, delete and search a linked list

public class CellList {

    // Private CellNode class
    // Used to create nodes to connect into a linked list

    private class CellNode implements Cloneable {

        private Cellphone data;
        private CellNode link;

        /**
         * Default Constructor
         */
        public CellNode() {
            data = null;
            link = null;
        }

        /***
         * Parameterized Constructor - Initializes all attributes to values provided by
         * the user
         * 
         * @param aCellphone - Cellphone, the cellphone object to store in the data
         *                   attribute of a cell node
         * @param aLink      - CellNode, the next node the current node links to
         */
        public CellNode(Cellphone aCellphone, CellNode aLink) {
            this.data = aCellphone;
            this.link = aLink;
        }

        /**
         * Copy Constructor - Initializes all attributes to values of the cell node
         * passed by the user
         * 
         * @param anotherCellNode - CellNode, the cell node object to copy attributes
         *                        from
         */
        public CellNode(CellNode anotherCellNode) {
            this.data = anotherCellNode.data;
            this.link = anotherCellNode.link;
        }

        /**
         * Clone method to create a deep copy of the calling object
         */
        public CellNode clone() throws CloneNotSupportedException {
            CellNode newCellNode = (CellNode) super.clone();
            return (newCellNode);
        }

        // Setters and getters have a privacy leak
        // They allow the contents of a private attribute to be viewed and changed
        // outside of the class definition

        /**
         * Change the data attribute of a CellNode to a new one
         * 
         * @param data - Cellphone, the new Cellphone object to store inside the data
         *             attribute
         */
        public void setData(Cellphone data) {
            this.data = data;
        }

        /**
         * Change the link attribute of a CellNode to a new one
         * 
         * @param data - CellNode, the new CellNode the current node will link to
         */
        public void setLink(CellNode link) {
            this.link = link;
        }

        /**
         * Get back the Cellphone object stored in the data attribute
         * 
         * @return Cellphone, the cellphone object stored in the data attribute
         */
        public Cellphone getData() {
            return (this.data);
        }

        /**
         * Get back the CellNode object stored in the link attribute
         * 
         * @return CellNode, the node the calling node links to
         */
        public CellNode getLink() {
            return (this.link);
        }

    }

    // Linked list class
    // Links together nodes to create a linked list object

    private CellNode head;
    private int size = 0;

    /**
     * Default constructor
     */
    public CellList() {
        this.head = null;
    }

    /**
     * Copy Constructor - Initializes all nodes to the same nodes in the passed
     * linked list
     * 
     * @param aCellList - CellList, the cell list to copy all the nodes from
     */
    public CellList(CellList aCellList) {

        // Checks if the passed list object is empty
        if (aCellList == null) {
            throw new NullPointerException();
        }

        // Initializes the head of the linked list
        CellNode currNode = aCellList.head;
        this.head = currNode;

        CellNode newNode = null;
        try {
            newNode = currNode.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Error with cloning");
            System.exit(0);
        }
        this.size++;

        // Loops through the list passed and creates new cell node objects
        // Links together all the cell nodes as they are created
        while (currNode != null) {

            currNode = currNode.link;

            if (currNode != null) {
                try {
                    newNode.link = currNode.clone();
                } catch (CloneNotSupportedException e) {
                    System.out.println("Error with cloning");
                    System.exit(0);
                }

                this.size++;

            }
            else{
                newNode.link = null;
            }
            
            newNode = newNode.link;
        }

        

    }

    /***
     * Adds a cell node to the start of a linked list
     * @param newCellphoneHead - Cellphone, the cellphone object to be stored in the head node object
     */
    public void addToStart(Cellphone newCellphoneHead){
        CellNode newHead = new CellNode(newCellphoneHead, head);
        this.size++;
        head = newHead;
    }

    /**
     * Adds a cell node to the specified index in the linked list
     * @param aCellphone - Cellphone, the cellphone object to be stored in the node at the specified index
     * @param index - int, the index at which the new node to be added
     */
    public void insertAtIndex(Cellphone aCellphone, int index){

        CellNode cellToAdd = new CellNode(aCellphone, null);
        CellNode currNode = head;
        CellNode prevNode = null;
        int count = 0;

        if(index >= 0 & index <= this.size-1){

            if(index == 0){
                addToStart(aCellphone);
            }
            else{
                while(currNode != null){
                    prevNode = currNode;
                    currNode = currNode.link;
                    count++;
    
                    if(count == index){
                        prevNode.link = cellToAdd;
                        cellToAdd.link = currNode;
                    }
                }
                this.size++;
            }
        }
        else{
            throw new NoSuchElementException();
        }
    }

    /**
     * Deletes the node from the start of the linked list
     */
    public void deleteFromStart(){
        head = head.link;
        this.size--;
    }


    /**
     * Deletes the node from the specified index
     * @param index - int, the index position of the cell node to be deleted
     */
    public void deleteFromIndex(int index){

        if(index >= 0 & index <= this.size-1){

            CellNode currNode = head;
            CellNode prevNode = null;
            int count = 0;

            if(index == 0 ){
                deleteFromStart();
            }

            while(currNode != null){

                prevNode = currNode;
                currNode = currNode.link;
                count++;

                if(count == index){
                    prevNode.link = currNode.link;
                    this.size--;
                }

            }
            

        }
        else{
            throw new NoSuchElementException();
        }

    }


    /**
     * Creates a new cell node and replaces the cell node at the specified index
     * @param aCellphone - Cellphone, The cellphone object to be stored in the new cell node
     * @param index - int, the index at which the cell node will be replaced
     */
    public void replaceAtIndex(Cellphone aCellphone, int index){

        if(index >= 0 & index <= this.size-1){

            CellNode currNode = head;
            int count = 0;

            while(currNode!=null){
                if(count == index){
                    currNode.data = aCellphone;
                }
                currNode = currNode.link;
                count++;

            }

        }else{
            throw new NoSuchElementException();
        }
    }

    /**
     * Searches for a cell node with the specified serialNum
     * @param serialNum - long, the specified serial number to search in the linked list
     * @return CellNode, returns the cellnode at which the serialNum is found
     */

    //Privacy leak encountered here because a Node object is returned
    //The node object is a private object but is returned and can be manipulated
    public CellNode find(long serialNum){

        CellNode currNode = head;
        int count = 0;

        while(currNode != null){
            if(currNode.data.getSerialNum() == serialNum){
                System.out.println("FOUND AFTER " + (count+1) + " ITERATION(S)");
                return(currNode);
            }
            else{
                currNode = currNode.link;
                count++;
            }
        }
        System.out.println("Sorry, the serial number you entered could not be found");
        return(null);
        
        

    }

    /**
     * Checks to see if the serialNum specified is in the linked list
     * @param serialNum - long, the serialNum to search for 
     * @return boolean, returns true if found and false if not found
     */
    public boolean contains(long serialNum){

        CellNode currNode = head;

        while(currNode != null){
            if(currNode.data.getSerialNum() == serialNum){
                return(true);
            }
            else{
                currNode = currNode.link;
            }
        }
        return(false);
        
    }

    /**
     * Prints the linked list to the console
     * @return String, the linked list in a string format
     */
    public String showContents(){

        String gap = "=".repeat(70);
        String toReturn = "\n"+"The current size of the list is " + this.size + ". Here are the contents of the list" + "\n" + gap + "\n";

        CellNode currNode = head;

        while(currNode != null){
            
            if(currNode.data != null){
                toReturn += "[" + currNode.data + "] ---> ";
            }

            currNode = currNode.link;
        }

        toReturn += "X";
        return(toReturn);

    }

    /**
     * Checks to see if two linked lists are equal
     * @param anotherList - the linked list to compare to
     * @return boolean, true if equal and false if not equal
     */
    public boolean equals(CellList anotherList){

        boolean toReturn = true;

        if(this.size != anotherList.size){
            return(false);
        }

        CellNode currNode = head;
        CellNode currOtherNode = anotherList.head;

        while(currNode != null){
            if(!((currNode.data).equals(currOtherNode.data))){
                toReturn = false;
                break;
            }
            currNode = currNode.link;
            currOtherNode = currOtherNode.link;
        }

        return(toReturn);


    }

}
