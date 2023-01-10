package com.ferros.view;

import com.ferros.controller.LabelController;
import com.ferros.model.Label;

import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class LabelView  {

    private final Scanner scanner = new Scanner(System.in);
    private final LabelController controller = new LabelController();



    private final String CRUDMassage = "Chose action in Label: \n" +
            "1.Create \n" +
            "2.Show all \n" +
            "3.Show by ID \n" +
            "4.Update \n" +
            "5.Delete \n" +
            "6.Exit to previous menu";
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
       printLabel(controller.update(updatedLabel)," Updated message"); ;

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
                case 1:
                    createLabel();

                    break;
                case 2:
                    showAllLabels();
                    break;
                case 3:
                    findLabelById();
                    break;
                case 4:
                    updateLabel();
                    break;
                case 5:
                    deleteLabelByID();
                    break;

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
