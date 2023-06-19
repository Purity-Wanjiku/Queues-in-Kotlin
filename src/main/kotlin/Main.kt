fun main() {
//var x = y?: 0 iff value is not there, return 0
    var a = Queue(5)
a.dequeue()
    a.enqueue(1)
    a.enqueue(2)
    a.enqueue(3)
    a.display()
    a.dequeue()
    a.display()

    a.enqueue(45)
    a.enqueue(32)
    a.enqueue(64)
    a.enqueue(32)
    a.display()
}
//Queues use FIFO format (First In First Out)
//peek see what is at the front
//enqueue add element in the queue
//dequeue removes an element from a queue
//isFull checks if queue is full
//isEmpty checks if queue is empty

class Queue(var capacity: Int){
    var data = IntArray(capacity)  //an integer array of size capacity. The array is fixed in size
    var front = 0                  //keep track of the front and the rear (back)
    var rear = 0                   //rear gets incremeneted as we add elements while the front remains 0
                                   //rear indicates the next available slot

    fun enqueue(value:Int) {
        if (isFull()) {
            println("Queue is full")
            return
        }
        data[rear] = value
        rear++
    }
    fun dequeue(): Int? {
        if (isEmpty()) {
            println("Queue is empty")
            return null
        }
        var removed = data[front]
        for (i in front until rear - 1) {
            data[i] = data[i + 1]
        }
        rear--
        return removed
    }
    fun peek(): Int? {
        if (isEmpty()) {
            return null
        }
        return  data[front]
    }
    fun isFull():Boolean{
        return rear == capacity
    }

    fun isEmpty():Boolean{
        return front == rear
    }

    fun display(){
        if (isEmpty()){
            return
        }
        for (i in front until rear){
            println(data[i])
        }
    }

}