package com.naat.bontu.api.bontu.model;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author David
 */
@AllArgsConstructor
public class CreditDetailResponse implements Serializable{
    @Getter @Setter
    private List<Movement> movements = null;
}
