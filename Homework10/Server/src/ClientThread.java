import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.image.Raster;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ClientThread extends Thread {
    private Socket socket = null ;
    private  boolean exit = false;
    private String logged = "";
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {

            try {
                Retea retea = new Retea();
                // Get the request from the input stream: client → server
                    while (true) {

                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));
                        String request;
                        request = in.readLine();
                        // Send the response to the oputput stream: server → client
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                        String raspuns = "";

                        if (request.equals("stop")) {
                            raspuns = "Server stopped";
                            exit = true;
                        } else if (request.contains("register")) {
                            String name = request.substring(8);
                            retea.add_user(name);
                            raspuns = "User inregistrat" + name;
                            System.out.println(retea.getUsers());
                        } else if (request.contains("login")) {
                            String name = request.substring(5);
                            if (retea.User_exists(name) == true) {
                                raspuns = "Successfully logged in";
                                retea.setLogged(name);
                            } else {
                                raspuns = "Login failed. User not registered";
                            }
                        } else if (request.contains("friends")) {
                            // if (logged == "") raspuns = "Not logged";
                            // else {
                            String friends = request.substring(7);
                            retea.add_friends(retea.getLogged(), friends);
                            raspuns = "prieteni adaugati";
                            System.out.println(retea.getFriends());
                            //  }
                        } else if (request.contains("send")) {
                            String mess = request.substring(4);
                            retea.send_messages(retea.getLogged(), mess);
                            raspuns = "Mesaj trimis!";
                            System.out.println(retea.getMessages());
                        } else if (request.equals("read")) {
                            System.out.println(retea.getMessages());
                            raspuns = retea.receive_messages(retea.getLogged());
                        } else {
                            raspuns = "Server received the request " + request + "!";
                        }

                        out.println(raspuns);
                        out.flush();
                        if (exit == true) System.exit(0);
                    }

            }    catch (IOException e) {
                System.err.println("Communication error... " + e);
            }finally{
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
