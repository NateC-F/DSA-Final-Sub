public class Tasks{
    final private int maxSize =10;
    private String[] queueArray;
    private int front;
    private int rear;


    public Tasks(){

        this.queueArray = new String[maxSize];
        front = -1;
        rear = -1;
    }

    public void enqueue(String value){

        if((rear + 1) % maxSize == front){
            System.out.println("Cannot add any more tasks. Unless you buy the premium version. ");
        }

        else if(isEmpty()){
            front = 0;
            rear = 0;
            queueArray[rear] = value;
        }

        else{
            rear = (rear +1) % maxSize;
            queueArray[rear] = value;
        }
    }

    public String dequeue(){
        String element = "";
        if(isEmpty()){
            System.out.println("There are no current tasks available");
        }

        else if(front == rear){
            element = queueArray[front];
            front = -1;
            rear = -1;
        }

        else {
            element = queueArray[front];
            queueArray[front]=null;
            front = (front + 1) % maxSize;

        }
        return element;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public String toString(){
        String string="";
        int size=1;
        for(int n=0; n<queueArray.length;n++)
        {

            if (queueArray[n]!=null) {

                string += "["+size+"] " + queueArray[n] + "\n";
                size++;
            }
        }
        if (isEmpty())
            System.out.println("There are no current tasks available");
        return string;
    }

}
