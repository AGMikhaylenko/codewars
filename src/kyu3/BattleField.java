package kyu3;

import java.util.ArrayList;
import java.util.Arrays;

public class BattleField {

    private static int[][] battleField = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    public static ArrayList<Ship> listOfShip;

    public static void main(String[] args) {
        System.out.println(fieldValidator(battleField));
    }

    public static boolean fieldValidator(int[][] field) {

        listOfShip = new ArrayList<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    Cell currentCell = new Cell(j, i);
                    boolean isAdded = false;
                    for (Ship ship : listOfShip) {
                        if (ship.addCell(currentCell)) {
                            isAdded = true;
                            break;
                        }
                    }
                    if (isAdded == false)
                        listOfShip.add(new Ship(currentCell));
                }
            }
        }

        int countOne = 0, countTwo = 0, countThree = 0, countFour = 0;
        for (int i = 0; i < listOfShip.size(); i++) {
            switch (listOfShip.get(i).getLength()) {
                case 1:
                    countOne++;
                    break;
                case 2:
                    countTwo++;
                    break;
                case 3:
                    countThree++;
                    break;
                case 4:
                    countFour++;
                    break;
            }

            for (int j = i + 1; j < listOfShip.size(); j++) {
                if (listOfShip.get(i).isContact(listOfShip.get(j))) {
                    return false;
                }
            }
        }

        if (countOne == 4 && countTwo == 3 && countThree == 2 && countFour == 1)
            return true;
        else
            return false;
    }
}

class Ship {

    private Orientation orientation;
    private ArrayList<Cell> cells = new ArrayList<>();

    public Ship(Cell firstCell) {
        orientation = Orientation.NONE;
        cells.add(firstCell);
    }

    public int getLength() {
        return cells.size();
    }

    public boolean addCell(Cell cell) {
        Cell lastCellOfShip = cells.get(cells.size() - 1);
        switch (orientation) {
            case NONE:
                if (lastCellOfShip.getVertical() == cell.getVertical() &&
                        cell.getHorizontal() - lastCellOfShip.getHorizontal() == 1) {
                    cells.add(cell);
                    orientation = Orientation.HORIZONTAL;
                    return true;
                }
                if (lastCellOfShip.getHorizontal() == cell.getHorizontal() &&
                        cell.getVertical() - lastCellOfShip.getVertical() == 1) {
                    cells.add(cell);
                    orientation = Orientation.VERTICAL;
                    return true;
                }
                break;
            case HORIZONTAL:
                if (lastCellOfShip.getVertical() == cell.getVertical() &&
                        cell.getHorizontal() - lastCellOfShip.getHorizontal() == 1) {
                    cells.add(cell);
                    return true;
                }
                break;
            case VERTICAL:
                if (lastCellOfShip.getHorizontal() == cell.getHorizontal() &&
                        cell.getVertical() - lastCellOfShip.getVertical() == 1) {
                    cells.add(cell);
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean isContact(Ship otherShip) {
        for (Cell cellCurrentShip : this.cells) {
            for (Cell cellOtherShip : otherShip.cells) {
                if (Math.abs(cellCurrentShip.getVertical() - cellOtherShip.getVertical()) <= 1 &&
                        Math.abs(cellCurrentShip.getHorizontal() - cellOtherShip.getHorizontal()) <= 1)
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Orientation = " + orientation +
                " Count of cells " + getLength() +
                " Cells: " + Arrays.toString(cells.toArray()) + "\n";
    }

    enum Orientation {
        NONE,
        VERTICAL,
        HORIZONTAL
    }
}

class Cell {
    private int vertical;
    private int horizontal;

    public Cell(int horizontal, int vertical) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    @Override
    public String toString() {
        String[] book = {"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К",};
        return book[horizontal] + (vertical + 1);
    }
}

