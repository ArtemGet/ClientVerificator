package sample;

import java.io.*;
import java.util.ArrayList;


class Client {

     public static void putis() {
        try (RW rW = new RW("192.168.0.110",9000))
        {
            rW.writeLine("adminId");
            ArrayList<Integer> Id = rW.readUnverifiedId();

            ArrayList<String> data = rW.readUnverifiedData();

            for (int a: Id
            ) {
                System.out.println(a);
            }
            System.out.println(Id.size());
            for (String a: data
            ) {
                System.out.println(a);
            }
            System.out.println(data.size());
            rW.writeVerifiedId(Id);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
