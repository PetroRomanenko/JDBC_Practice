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

        System.out.println("Enter writer First Name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter writer Last Name: ");
        String lastName = scanner.nextLine();

        List<Post> posts = new ArrayList<>();
        Writer cratedWriter = controller.saveWriter(firstName, lastName, posts);
        printWriter(cratedWriter, "Created writer: ");

    }

    public void findWriterById() {

        System.out.println("Enter ID of desired Writer: ");
        Integer lookedId = scanner.nextInt();
        scanner.skip("\n");

        checkIfNoSuchWriterInDB(lookedId);

        Writer foundWriter = controller.findWriterById(lookedId);
        printWriter(foundWriter, "Desired Writer: ");

    }

    public void showAllWriter() {
        System.out.println("All Writers: ");
        printWriterList(controller.getAllWriters());
    }

    public void updateWriter() {
        System.out.println("Enter Writer id: ");
        Integer updatedWriterId = scanner.nextInt();
        scanner.skip("\n");

        System.out.println("Enter new writer First Name: ");
        String updatedFirstName = scanner.nextLine();

        System.out.println("Enter new writer Last Name: ");
        String updatedLastName = scanner.nextLine();

        System.out.println("Enter number of post written by writer ");
        Integer writtenPostID = scanner.nextInt();

        checkIfNoSuchWriterInDB(updatedWriterId);

        Writer updatedWriter = new Writer( updatedFirstName, updatedLastName);
        updatedWriter.setId(updatedWriterId);
        var updatedRetunedWriter = controller.update(updatedWriter, writtenPostID);

        printWriter(updatedRetunedWriter, "Updated Writer: ");

        if (updatedRetunedWriter==null){
            System.out.println("NO such writer choose again");
            menuChoice();
        }
    }

    private void checkIfNoSuchWriterInDB(Integer searchedID) {
        Writer writer = controller.findWriterById(searchedID);

        if (writer==null){
            System.out.println("NO such writer choose again");
            menuChoice();
        }
    }

    public void deleteWriterById() {
        System.out.println("Enter Writer Id: ");
        Integer deletedWriterID = scanner.nextInt();
        scanner.skip("\n");
        checkIfNoSuchWriterInDB(deletedWriterID);
        Writer writer = controller.findWriterById(deletedWriterID);
            controller.deleteWriterById(deletedWriterID);

        printWriter(writer, "Deleted Writer: ");



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


    private void printWriter(Writer writer, String message) {
        if(message!=null) {
            System.out.println(message);
        }
        System.out.println("Writer id: "+writer.getId());
        System.out.println("Writer First Name: " + writer.getFirstName());
        System.out.println("Writer Last Name: " + writer.getLastName());
    }

    private void printWriterList(List<Writer> writers){
        for (Writer writer: writers){
            printWriter(writer, null);
        }
    }

}

