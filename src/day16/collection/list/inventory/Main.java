package day16.collection.list.inventory;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Inventory inventory = new Inventory();
    public static Scanner sc = new Scanner(System.in);

    //테스트 데이터 삽입
    private static void testInsert() {
        Product t1 = new Product("a001", "냉장고", 400000, 4);
        Product t2 = new Product("a002", "에어컨", 500000, 8);
        Product t3 = new Product("a003", "선풍기", 120000, 9);
        inventory.insert(t1);
        inventory.insert(t2);
        inventory.insert(t3);
    }

    //제품 기능 등록 처리
    private static void addProduct() {
        Product newProduct = new Product();
        inventory.insert(newProduct);
        System.out.printf("제품(%s) 등록이 완료되었습니다.\n"
                , newProduct.getProductName());
//        System.out.println(inventory);
        saveData();
    }

    //제품 정보 전체 조회 기능
    private static void showAllProducts() {
        System.out.println("############  전체 제품 정보 ############");
        inventory.selectAll();
        System.out.println();
    }

    //제품 개별 검색 기능
    private static void searchProduct() {
        System.out.println("\n# 조회하실 제품의 바코드 번호를 입력하세요.");
        System.out.print("> ");
        String barcode = sc.next();

        Product product = inventory.getProduct(barcode);

        if (product != null) {
            System.out.println("\n# 조회 결과");
            System.out.println("- 제품명: " + product.getProductName());
            System.out.println("- 가격: " + product.getPrice() + "원");
            System.out.println("- 수량: " + product.getAmount() + "개");
            System.out.println("- 총액: " + product.getTotalPrice() + "원");
        } else {
            System.out.println("\n# 해당 제품은 존재하지 않습니다.");
        }
    }

    //제품 수정 처리 메서드
    private static void modifyProduct() {
        System.out.println("\n# 수정하실 제품의 바코드 번호를 입력하세요.");
        System.out.print("> ");
        String barcode = sc.next();
        Product product = inventory.getProduct(barcode);

        if (product != null) {
            System.out.printf("\n# [%s]%s 제품의 수정을 시작합니다.\n",
                    barcode, product.getProductName());
            System.out.println("[ 1. 가격 수정 | 2. 수량 수정 | 3. 수정 취소 ]");
            System.out.print("> ");
            try {
                int selection = sc.nextInt();
                if (selection == 1) {
                    System.out.println("# 수정하실 가격을 입력하세요.");
                    System.out.print("> ");
                    int newPrice = sc.nextInt();
                    inventory.updatePrice(product, newPrice);
                }
            } catch (Exception e) {
                System.out.println("\n# 숫자만 입력하세요. 수정을 취소합니다.");
            }
            saveData();
        } else {
            System.out.println("\n# 해당 제품은 존재하지 않습니다.");
        }
    }

    private static void deleteProduct() {
        System.out.println("\n# 삭제하실 제품의 바코드 번호를 입력하세요.");
        System.out.print("> ");
        String barcode = sc.next();
        Product product = inventory.getProduct(barcode);

        if (product != null) {
            inventory.removeProduct(product);
            System.out.println("삭제가 정상 처리되었습니다.");
            saveData();
        } else {
            System.out.println("\n# 해당 제품은 존재하지 않습니다.");
        }

    }

    public static void main(String[] args) {

//        testInsert();

        //디렉토리를 생성하는 코드.
        File f = new File("D:/inven");//File객체의 생성자에 생성할 디렉토리 경로를 적음.
        if (!f.exists()) {//해당 경로에 디렉토리가 존재하지 않는다면~~
            f.mkdirs(); //디렉토리를 만들어라~~
        }

        loadData();//저장된 데이터 자동 불러오기 기능.

        while (true) {
            System.out.println("\n*** 재고 관리 프로그램 ***");
            System.out.println("# 1. 제품 정보 등록");
            System.out.println("# 2. 제품 정보 전체조회");
            System.out.println("# 3. 제품 정보 개별조회");
            System.out.println("# 4. 제품 정보 수정");
            System.out.println("# 5. 제품 정보 삭제");
            System.out.println("# 6. 프로그램 종료");
            System.out.print("- 메뉴 입력: ");
            int menu = 0;
            try {
                menu = sc.nextInt();
            } catch (Exception e) {
                System.out.println("메뉴는 숫자로만 입력하세요.");
                sc.nextLine();
                continue;
            }

            switch (menu) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showAllProducts();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    modifyProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0); //프로그램 강제종료
                    break;
                default:
                    System.out.println("해당 메뉴는 없는 메뉴입니다.");
            }
        }

    }

    //입력된 재고데이터를 저장하는 메서드.
    private static void saveData() {

        //먼저 저장할 경로와 파일명을 변수에 저장.
        String fileName = "D:/inven/inven.sav";

        //파일 저장기능을 하는 java.io패키지의 api사용.
        FileOutputStream fos = null;
        //보조스트림 oos는 객체저장 기능을 가지고 있음.
        ObjectOutputStream oos = null;

        try {
            //파일 저장을 위한 객체 생성.
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);

            //성적정보가 저장된 리스트를 파일에 저장.
            oos.writeObject(inventory);

        } catch (FileNotFoundException e) {
            System.out.println("해당 경로가 존재하지 않습니다.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (oos != null) try {
                oos.close();
            } catch (Exception e) {
            }
        }

    }

    //파일에 저장된 정보를 불러오는 메서드.
    private static void loadData() {

        String fileName = "D:/inven/inven.sav";

        //파일 입력(불러오기)을 위한 api
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);

            //readObject는 파일에저장된 객체를 Object타입으로 리턴한다.
            inventory = (Inventory) ois.readObject();

        } catch (Exception e) {
        } finally {
            if (ois != null) try {
                ois.close();
            } catch (Exception e) {
            }
        }
    }
}