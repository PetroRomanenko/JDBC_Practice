package com.ferros.view;

import com.ferros.controller.WriterController;
import com.ferros.model.Post;
import com.ferros.model.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriterView {
    private Scanner scanner = new Scanner(System.in);
    private WriterController controller = new WriterController();

    private final String CRUDMassage = "Chose category in Writer: \n" +
            "1.Create \n" +
            "2.Show all \n" +
            "3.Show by ID \n" +
            "4.Update \n" +
            "5.Delete \n" +
            "6.Exit to previous menu";
    private final String line = "****************************************";

    public void createWriter() {
        scanner.nextLine();
        System.out.println("Enter writer First Name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter writer Last Name: ");
        String lastName = scanner.nextLine();
        //Add List<Post>!!!!!
        List<Post> posts = new ArrayList<>();
        Writer cratedWriter = controller.saveWriter(firstName, lastName, posts);

    }

    public void findWriterById() {

        System.out.println("Enter ID of desired Writer: ");
        Integer lookedId = scanner.nextInt();
        scanner.skip("\n");


        Writer foundWriter = controller.findWriterById(lookedId);
        System.out.println("Desired Writer: " + foundWriter);
    }

    public void showAllWriter() {
        System.out.println("All Writers: ");
        controller.printWriterList(controller.getAllWriters());
    }

    public void updateWriter() {
        System.out.println("Enter Writer id: ");
        Integer updatedWriterId = scanner.nextInt();
        System.out.println("Hi3");
        scanner.skip("\n");

        System.out.println("Enter new writer First Name: ");
        String updatedFirstName = scanner.nextLine();

        System.out.println("Enter new writer Last Name: ");
        String updatedLastName = scanner.nextLine();
        //Add Post List
        List<Post> posts = new ArrayList<>();

        Writer updatedWriter = new Writer(updatedWriterId, updatedFirstName, updatedLastName, posts);
        controller.update(updatedWriter);
    }

    public void deleteWriterById() {
//        System.out.println("Enter Writer Id: ");
//        Integer deletedWriterID = scanner.nextInt();
//        scanner.skip("\n");
//        if (controller.isWriterIdValid(deletedWriterID)) {
//            Writer writer = controller.findWriterById(deletedWriterID);
//            controller.deleteWriterById(deletedWriterID);
//            System.out.println(writer + "  successfully deleted");
//        } else System.out.println("Wrong Id or don`t exist, chose again");

    }

    public void showMenuMassage() {
        System.out.println(line);
        System.out.println(CRUDMassage);
        System.out.println(line);
    }

    public void menuChoice() {
        int chose;
        do {
            showMenuMassage();
            chose = scanner.nextInt();
            switch (chose) {
                case 1:
                    createWriter();

                    break;
                case 2:
                    showAllWriter();
                    break;
                case 3:
                    findWriterById();
                    break;
                case 4:
                    updateWriter();
                    break;
                case 5:
                    deleteWriterById();
                    break;

            }
        } while (chose != 6);
    }


    private void showPrettyWriter(Writer writer) {
        System.out.println("");
    }

}

