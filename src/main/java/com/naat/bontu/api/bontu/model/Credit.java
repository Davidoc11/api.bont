package com.naat.bontu.api.bontu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naat.bontu.api.bontu.utils.Constants;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NonNull;
    import lombok.Setter;
/**
 *
 * @author David
 */
@Entity
public class Credit implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull @Getter @Setter
    private Long number;
    @NonNull @Getter @Setter
    private String type;
    @Getter @Setter
    private Double amount;
    @JsonIgnore @Getter @Setter @OneToMany(mappedBy = "credit", fetch = FetchType.EAGER)
    private List<Movement> movements;
    @Getter @Setter
    private Double available;
    @Getter @Setter
    private Double charge;
    @Getter @Setter
    private Double minimumPayment;
    @Getter @Setter
    private Double monthlyPayment;
    @Getter @Setter
    private Double remainingDebt;
    @Getter @Setter
    private Date deadline;
   
    @ManyToOne(optional = false)
    @JoinColumn(name="USER_ID")
    private User user;
    public Double getProgress(){
        Double progress;
        if(type.equals(Constants.CreditTypes.TYPE_1)){
            progress = 100-(100*available/amount);
        }else{
            progress = 100-(100*remainingDebt/amount);
        }
        return progress;
    }

}
