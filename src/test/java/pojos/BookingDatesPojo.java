package pojos;

public class BookingDatesPojo {
    // Tüm keyler içinprivate variable oluşturuyoruz
    private String checkin;
    private String checkout;

    // Tüm parametrelerle cons oluştur
    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
    // Parametresiz cons oluştur
    public BookingDatesPojo() {
    }

    // Public Getter ve Setter methodlarını oluşturuzu


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
