package exercise.models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RentDetails {

    @JsonProperty("rentExpireDate")
    private String rentExpireDate;

    public RentDetails(){}

/*    public RentDetails(String rentExpireDate) {
        this.rentExpireDate = rentExpireDate;
    }*/

    public String getRentExpireDate() {
        return rentExpireDate;
    }

    public void setRentExpireDate(String rentExpireDate) {
        this.rentExpireDate = rentExpireDate;
    }

}
