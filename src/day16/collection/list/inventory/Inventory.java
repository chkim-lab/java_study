package day16.collection.list.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    //메서드 선언

    //제품 정보 추가 기능
    public void insert(Product product) {
        products.add(product);
    }

    //제품 가격 수정 기능
    public void updatePrice(Product product, int newPrice) {
        if (products.contains(product)) {
            Product p = products.get(products.indexOf(product));
            p.setPrice(newPrice);
            System.out.printf("가격이 %d원으로 변경되었습니다.\n", newPrice);
//            //총액 갱신
//            p.setTotalPrice(newPrice * product.getAmount());
        } else {
            System.out.println("검색하신 제품은 존재하지 않습니다.");
        }
    }

    //제품 수량 수정 기능
    public void updateAmount(Product product, int amount) {
        if (products.contains(product)) {
            Product p = products.get(products.indexOf(product));
            p.setAmount(amount);
            System.out.printf("수량이 %d개로 변경되었습니다.\n", amount);
//            //총액 갱신
//            p.setTotalPrice(amount * product.getPrice());
        } else {
            System.out.println("검색하신 제품은 존재하지 않습니다.");
        }
    }

    //제품 삭제 기응
    public void removeProduct(Product delProduct) {
        products.remove(delProduct);
    }

    //전체 제품 조회
    public void selectAll() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    //바코드 번호로 리스트에서 특정 제품 객체를 찾아서 리턴하는 메서드
    public Product getProduct(String barcode) {
        for (Product product : products) {
            if (barcode.equals(product.getBarcode())) {
                return product;
            }
        }
        return null; //탐색 실패 - 즉, 바코드번호가 없거나 잘못된 경우
    }

    @Override
    public String toString() {
        return products.toString();
    }
}