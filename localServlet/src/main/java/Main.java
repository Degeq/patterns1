import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 8089;

        try(ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = server.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    System.out.println("Новое подключение. Порт: " + clientSocket.getPort());

                    out.println(String.format("Как Вас зовут?"));
                    final String name = in.readLine();
                    out.println(String.format("Сколько Вам лет"));
                    int age = Integer.parseInt(in.readLine());
                    if(age < 18) {
                        out.println(String.format(name + ", добро пожаловать в раздел для детей. Давайте сыграем!"));
                    } else {
                        out.println(String.format(name + ", добро пожаловать на страницу для взрослых. Хороших рабочих будней или п" +
                                "родуктивных выходных!"));
                    }

                }

                }
            }
        }
    }
