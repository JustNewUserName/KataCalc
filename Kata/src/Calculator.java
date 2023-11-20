import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class Calculator {
    public static void main (String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите операцию :");
        String inputStr = in.nextLine();
        System.out.println(calc(inputStr));
    }
    public static String calc(String input) throws IOException {
        char[] inputChar = input.toCharArray();
        int result;
        String resultStr;
        int a;
        int b;
        int c = 0;
        char symbol = 0;
        for(int i = 0; i< input.length(); i++ ){
            if(inputChar[i]=='+'){
                symbol ='+';
                c++;
                break;
            }
            if(inputChar[i]=='-'){
                symbol ='-';
                c++;
                break;
            }
            if(inputChar[i]=='*'){
                symbol ='*';
                c++;
                break;
            }
            if(inputChar[i]=='/'){
                symbol ='/';
                c++;
                break;
            }
        }
        if(symbol == 0){
            throw new IOException("Строка не является математической операцией");
        }
        if(c >= 1){
            throw new IOException("Допускается один оператор счисления.");
        }
        String inputReturn = String.valueOf(inputChar);
        String inputReturn2 = inputReturn.replaceAll("\\s",""); //удаление пробелов
        //логика такая: ищет пробелы //s и заменяет их на ничто))
        String[] afterSplit = inputReturn2.split("[+/*-]");
        if((Objects.equals(afterSplit[0],"1") || Objects.equals(afterSplit[0],"2")
                || Objects.equals(afterSplit[0],"3")|| Objects.equals(afterSplit[0],"4")
                || Objects.equals(afterSplit[0],"5")|| Objects.equals(afterSplit[0],"6")
                || Objects.equals(afterSplit[0],"7")|| Objects.equals(afterSplit[0],"8")
                || Objects.equals(afterSplit[0],"9")|| Objects.equals(afterSplit[0],"10"))
                &&(Objects.equals(afterSplit[1],"1")|| Objects.equals(afterSplit[1],"2")
                || Objects.equals(afterSplit[1],"3")|| Objects.equals(afterSplit[1],"4")
                || Objects.equals(afterSplit[1],"5")|| Objects.equals(afterSplit[1],"6")
                || Objects.equals(afterSplit[1],"7")|| Objects.equals(afterSplit[1],"8")
                || Objects.equals(afterSplit[1],"9")|| Objects.equals(afterSplit[1],"10"))){
            a = Integer.parseInt(afterSplit[0]); // из строки получили int
            b = Integer.parseInt(afterSplit[1]); // из строки получили int
            if(symbol=='+'){
                result = a + b;
            }else if(symbol=='-'){
                result = a - b;
            }else if(symbol=='*'){
                result = a * b;
            }else {
                result = a / b;
            }
            resultStr = Integer.toString(result);
        }else if ((Objects.equals(afterSplit[0],"I") || Objects.equals(afterSplit[0],"II")
                || Objects.equals(afterSplit[0],"III")|| Objects.equals(afterSplit[0],"IV")
                || Objects.equals(afterSplit[0],"V")|| Objects.equals(afterSplit[0],"VI")
                || Objects.equals(afterSplit[0],"VII")|| Objects.equals(afterSplit[0],"VIII")
                || Objects.equals(afterSplit[0],"IX")|| Objects.equals(afterSplit[0],"X"))
                &&(Objects.equals(afterSplit[1],"I") || Objects.equals(afterSplit[1],"II")
                || Objects.equals(afterSplit[1],"III")|| Objects.equals(afterSplit[1],"IV")
                || Objects.equals(afterSplit[1],"V")|| Objects.equals(afterSplit[1],"VI")
                || Objects.equals(afterSplit[1],"VII")|| Objects.equals(afterSplit[1],"VIII")
                || Objects.equals(afterSplit[1],"IX")|| Objects.equals(afterSplit[1],"X"))){
            Rome part1 = Rome.valueOf(afterSplit[0]); // из строки получили enum
            a = part1.getArab(); //метод из enum, который вернул значение по имени
            Rome part2 = Rome.valueOf(afterSplit[1]); // из строки получили enum
            b = part2.getArab(); //метод из enum, который вернул значение по имени
            if(symbol=='+'){
                result = a + b;
            }else if(symbol=='-'){
                result = a - b;
            }else if(symbol=='*'){
                result = a * b;
            }else {
                result = a / b;
            }
            if(result < 1){
                throw new IOException("В римской системе нет отрицательных чисел");
            }
            else {
                Rome resultRome = Rome.values()[result-1];
                resultStr = resultRome.toString();
            }
        }
        else if ((Objects.equals(afterSplit[0],"1") || Objects.equals(afterSplit[0],"2")
                || Objects.equals(afterSplit[0],"3")|| Objects.equals(afterSplit[0],"4")
                || Objects.equals(afterSplit[0],"5")|| Objects.equals(afterSplit[0],"6")
                || Objects.equals(afterSplit[0],"7")|| Objects.equals(afterSplit[0],"8")
                || Objects.equals(afterSplit[0],"9")|| Objects.equals(afterSplit[0],"10"))
                &&(Objects.equals(afterSplit[1],"I") || Objects.equals(afterSplit[1],"II")
                || Objects.equals(afterSplit[1],"III")|| Objects.equals(afterSplit[1],"IV")
                || Objects.equals(afterSplit[1],"V")|| Objects.equals(afterSplit[1],"VI")
                || Objects.equals(afterSplit[1],"VII")|| Objects.equals(afterSplit[1],"VIII")
                || Objects.equals(afterSplit[1],"IX")|| Objects.equals(afterSplit[1],"X"))){
            throw new IOException("Операнды в разных системах счисления!");
        }
        else if ((Objects.equals(afterSplit[0],"I") || Objects.equals(afterSplit[0],"II")
                || Objects.equals(afterSplit[0],"III")|| Objects.equals(afterSplit[0],"IV")
                || Objects.equals(afterSplit[0],"V")|| Objects.equals(afterSplit[0],"VI")
                || Objects.equals(afterSplit[0],"VII")|| Objects.equals(afterSplit[0],"VIII")
                || Objects.equals(afterSplit[0],"IX")|| Objects.equals(afterSplit[0],"X"))
                &&(Objects.equals(afterSplit[1],"1")|| Objects.equals(afterSplit[1],"2")
                || Objects.equals(afterSplit[1],"3")|| Objects.equals(afterSplit[1],"4")
                || Objects.equals(afterSplit[1],"5")|| Objects.equals(afterSplit[1],"6")
                || Objects.equals(afterSplit[1],"7")|| Objects.equals(afterSplit[1],"8")
                || Objects.equals(afterSplit[1],"9")|| Objects.equals(afterSplit[1],"10"))){
            throw new IOException("Операнды в разных системах счисления!");
        }
        else {
            throw new IOException("Один из операндов не соответствует диапазону от 1 до 10");
        }
        return resultStr;
    }
}
