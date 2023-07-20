package JavaApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        
        List<Integer> list = new LinkedList<Integer>();
        Queue<Toy> queue = new PriorityQueue<Toy>(FreqComparator);
        boolean a = true;
        boolean b = true;
        Scanner scan = new Scanner(System.in);
        while (a){
            
            System.out.println("Желаете добавить новую игрушку?y/n: ");
            String answer = scan.next();
            switch (answer){
                case ("y"):
                    if (list.isEmpty()){
                        int Id = 1;
                        list.add(Id);
                    }else{
                        int Id = list.size() + 1;
                        list.add(Id);
                    }
                    int ID = list.get(list.size() - 1);
                    System.out.println("Введите название игрушки: ");
                    String nameOfToy = scan.next();
                    System.out.println("Введите количество игрушек");
                    int number = scan.nextInt();
                    System.out.println("Введите вес игрушки: ");
                    int percent = scan.nextInt();
                    Toy toy = AddToy(ID, nameOfToy, number, percent);
                    queue.add(toy);

                    //System.out.println(toy);

                    System.out.println("Список ID: " + list);
                    System.out.println("Очередь игрушек: " + queue);
                    break;

                case ("n"):
                    a = false;
                    break;
                default:
                    break; 

            }
        }                        
        while (b){
            System.out.println("Хотите разыграть игрушку?");
            String answer1 = scan.next();
            switch (answer1){
                case "y":
                    if (queue.size() > 0){
                        Toy gettedToy = GetToy(queue);
                        System.out.println("Выпавшая игрушка: " + gettedToy);
                        System.out.println();
                        System.out.println("Теперь добавим игрушку в файл");
                        String txt = gettedToy.toString();
                        System.out.println(txt);
                        String file = "D:/Coding/JavaApp/file.txt";
                        AppendData(file, txt);
                        
                    }else{
                        System.out.println("В очереди нет игрушек. Добавьте новую игрушку.");
                    }
                    break;
                case "n":
                    System.out.println("Файл будет очищен.");
                    String file = "D:/Coding/JavaApp/file.txt";
                    ClearData(file);
                    System.out.println("До свидания!");
                    b = false;
                    break;
                default:
                    break;     
            }
        }            
            
    }

    // Метод добавления новой игрушки
    public static Toy AddToy(int id, String name, int amount, int freq){
        Toy newToy = new Toy(id, name, amount, freq);
        return newToy;
    }

    // Компаратор для сравнения веса игрушки
    public static Comparator<Toy> FreqComparator = new Comparator<Toy>(){

        @Override
        public int compare (Toy f1, Toy f2){
            if (f1.getFreq() == f2.getFreq()){
                return 0;    
            }else if (f1.getFreq() > f2.getFreq()){
                return -1;
            }else{
                return 1;
            }
        }
    };

  

    // Метод получения игрушки
    public static Toy GetToy(Queue<Toy> priorityQueue){
      Toy getToy = priorityQueue.poll();
      return getToy; 
    }


    // Метод добавления ирушки в файл
    public static void AppendData(String filePath, String addText){
        File file = new File(filePath);
        FileWriter fw = null;
        String text = addText;
         
        try {
            fw = new FileWriter(file, true);
            fw.write(text);
            fw.close();
            System.out.println("Игрушка успешно добавлена в файл");
        }catch (IOException e){
            e.printStackTrace();
        }       
        
    }

    //Метод очистки файла
    public static void ClearData(String filePath){
        String file = filePath;
        try{
            PrintWriter pw = new PrintWriter(file);
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
