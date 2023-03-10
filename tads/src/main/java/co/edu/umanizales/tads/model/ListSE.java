package co.edu.umanizales.tads.model;

import lombok.Data;

@Data
public class ListSE {
    private Node head;

    public void add(Kid kid){
        if(head != null){
            Node temp = head;
            while(temp.getNext() !=null)
            {
                temp = temp.getNext();
            }
            /// Parado en el último
            Node newNode = new Node(kid);
            temp.setNext(newNode);
        }
        else {
            head = new Node(kid);
        }
    }
    public void addToStart(Kid kid){
        if(head !=null)
        {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;
        }
        else {
            head = new Node(kid);
        }
    }

    public int size() {
        int sizeList = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.getNext();
            sizeList++;
        }
        return sizeList;
    }
    public Node addKidPos(int pos, Kid kid) {
        if (size() >= pos) {
            if (pos == 0) {
                addToStart(kid);
            } else {
                Node temp = head;
                for (int i = 0; i < pos - 1; i++) {
                    temp = temp.getNext();
                }
                Node newNode = new Node(kid);
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
            }
        } else {
            add(kid);
        }
        return null;
    }
    public Node DeleteKidByIdentification(String identification) {
        Node temp = head;
        Node Nodeanterior = null;
        while ((temp != null) && (temp.getData().getIndentification() != identification)) {
            Nodeanterior = temp;
            temp= temp.getNext();
        }
        if (temp != null){
            if (Nodeanterior== null){
                head=temp.getNext();
            }
            else {
                Nodeanterior.setNext(temp.getNext());
            }
        }
        return null;
    }
    public Node invertir(){
        Node anterior = null;
        Node temp = head;
        while (temp != null) {
            anterior.setNext(temp);
            temp = head.getNext();
        }
        temp.setNext(anterior);
        head = temp;
        return null;
    }
    public Node enviarKidFinalxLetra(String letra){
        String option1 = letra.toLowerCase();
        String option2 = letra.toUpperCase();
        Node temp = head;
        Node copyList = null;
        Node anterior = null;
        Node next;

        for (int i = 0; i < size(); i++) {
            while(temp != null){
                String nameKid = temp.getData().getName();
                String ini = nameKid.substring(0,1);
                if ((ini == option1) || (ini == option2)){
                    copyList.setNext(temp);
                    next = temp.getNext();
                    anterior.setNext(next);
                    anterior.setNext(copyList);
                }
                temp = anterior;
            }
        }
        return null;
    }

} // fin clase