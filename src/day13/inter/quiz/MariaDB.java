package day13.inter.quiz;

public class MariaDB implements DataBaseAccess{
    @Override
    public void insert() {
        System.out.println("MariaDB에 데이터 입력!");
    }

    @Override
    public void update() {
        System.out.println("MariaDB에 데이터 수정!");
    }

    @Override
    public void delete() {
        System.out.println("MariaDB에 데이터 삭제!");
    }

    @Override
    public void select() {
        System.out.println("MariaDB에 데이터 조회!");
    }
}
