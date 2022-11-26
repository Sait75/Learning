package Shildt;


public class Encode {

    public static void main(String[]args){
        String msg = "Шифруем этот текст";
        String codMsg = "";
        String encMsg = "";
        int key = 88; // ключ шифрования

        System.out.println("Исходное сообщение:" + msg);

        for (int i=0; i<msg.length(); i++){
            codMsg = codMsg + (char) (msg.charAt(i)^key);
        }
        System.out.println("Зашифрованное сообщение: " + codMsg);

        for (int i = 0; i<codMsg.length(); i++){
            encMsg = encMsg + (char) (codMsg.charAt(i)^key);
        }
        System.out.println("Дешифрованное сообщение: " + encMsg);
    }
}
