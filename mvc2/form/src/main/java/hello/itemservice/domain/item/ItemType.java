package hello.itemservice.domain.item;

public enum ItemType {

    BOOK("도서"), FOOD("음식"), ETC("기타");

    private final String description;

    // 이게 있어야 프로퍼티 접근법이 성립 가능하다
    public String getDescription() {
        return description;
    }

    ItemType(String description) {
        this.description = description;
    }
}
