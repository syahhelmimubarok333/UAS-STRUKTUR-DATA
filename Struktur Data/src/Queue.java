import java.lang.reflect.Array;
import java.util.Scanner;
public class Queue<T> {
    public Integer pointer;
    private final Integer sizeArray;
    private final T[] element;

    public Queue(Class namaClass, Integer size) {
        pointer = -1;
        sizeArray = size;
        element = (T[]) Array.newInstance(namaClass, size);
    }

    public void enqueue(T data)
    {
        if(pointer < (sizeArray - 1))
        {
            pointer++;
            element[pointer] = data;
        }
        else
        {
            System.out.println("Queue Sudah Penuh");
        }
    }

    public void dequeue()
    {
        if(pointer >= 0) {
            for (Integer i = 0; i <= pointer; i++) {
                element[i] = element[i + 1];
            }
            pointer--;
        }
        else
        {
            System.out.println("Queue Sudah Kosong");
        }
    }
    public void viewQueue()
    {
        for(Integer i = 0; i <= pointer; i++)
        {
            System.out.print(element[i]);
            System.out.print(" ");
        }
    }

    public void clearQueue()
    {
        pointer = -1;
    }

    public static void main(String[] args)
    {
        Integer pil;
        Queue queue = new Queue<>(String.class, 10);
        Scanner scanner = new Scanner(System.in);

        do
        {
            queue.viewQueue();
            System.out.println();
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Clear");
            System.out.println("4. Exit");
            pil = scanner.nextInt();
            if(pil > 0 && pil < 4)
            {
                switch (pil) {
                    case 1:
                        String data;
                        System.out.print("Masukkan Data: ");
                        data = scanner.next();
                        queue.enqueue(data);
                        break;
                    case 2:
                        queue.dequeue();
                        break;
                    case 3:
                        queue.clearQueue();
                        break;
                    default:
                        break;
                }
            }
            else
                break;
        }while(true);
    }
}
