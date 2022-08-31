package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
// @Table(name = "item") // table명과 객체명이 같으면 안적어줘도 된다.
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", length = 10) // 컬럼명과 객체 필드명이 다른것만 작성해주면 된다.
    // 하지만 지금처럼 스프링부트와 통합해서 사용하면 필드 이름을 컴럼명으로 변경할때 객체 필드의 카멜 케이스를 테이블 컬럼의 언더스코어로 자동 변환해주어서 생략해도 된다.
    private String itemName;
    private Integer price;
    private Integer quantity;

    // JPA는 public또는 protected의 기본생성자가 필수다.
    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
