package com.ferros.view;

import com.ferros.controller.LabelController;
import com.ferros.model.Label;

import java.util.List;
import java.util.Scanner;

public class LabelView  {

    private final Scanner scanner = new Scanner(System.in);
    private final LabelController controller = new LabelController();



    private final String CRUDMassage = """
            Chose action in Label:\s
            1.Create\s
            2.Show all\s
            3.Show by ID\s
            4.Update\s
            5.Delete\s
            6.Exit to previous menu""";
    private final String line = "****************************************";

    public void createLabel() {
        scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        Label createdLabel = controller.saveLabel(name);

        printLabel(createdLabel, "Saved label: " );
    }

    public void findLabelById() {
        System.out.println("Enter ID of desired Label: ");
        int lookedId = scanner.nextInt();
        scanner.skip("\n");

        Label findLabel = controller.findLabelById(lookedId);
        printLabel(findLabel, "Saved label: ");
    }

    public void showAllLabels() {
        System.out.println("All labels: ");
        printList(controller.getAllLabels());
    }

    public void updateLabel() {
        System.out.println("Enter Label id: ");
        int updatedLabelID = scanner.nextInt();
        scanner.skip("\n");
        System.out.println("Desired Label: " + controller.findLabelById(updatedLabelID));


        System.out.println("Change name of Label: ");
        String updatedLabelName = scanner.nextLine();

        Label updatedLabel = new Label(updatedLabelID, updatedLabelName);
       printLabel(controller.update(updatedLabel)," Updated message");

    }

    public void deleteLabelByID() {
        System.out.println("Enter Label Id: ");
        int deletedLabelID = scanner.nextInt();
        scanner.skip("\n");
        Label label = controller.findLabelById(deletedLabelID);
        controller.deleteLabelByID(deletedLabelID);
        printLabel(label , "Successfully deleted:");
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
                case 1 -> createLabel();
                case 2 -> showAllLabels();
                case 3 -> findLabelById();
                case 4 -> updateLabel();
                case 5 -> deleteLabelByID();
            }
        } while (chose != 6);
    }

    public void printList(List<Label> labelList){
        for (Label label:labelList  ) {
            printLabel(label,null);
        }
    }

    public void printLabel(Label label, String message){
        if(message!=null) {
            System.out.println(message);
        }
        System.out.print("Label id: " +label.getId()+"    ");
        System.out.println("Label name: " +label.getName());

    }
}
