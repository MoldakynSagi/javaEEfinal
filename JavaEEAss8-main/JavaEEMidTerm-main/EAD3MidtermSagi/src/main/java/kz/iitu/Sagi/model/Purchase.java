package kz.iitu.Sagi.model;

public class Purchase {

    private Long id;
    private Long user_id;
    private Long electronic_id;

    public Purchase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getElectronic_id() {
        return electronic_id;
    }

    public void setElectronic_id(Long electronic_id) {
        this.electronic_id = electronic_id;
    }
}
